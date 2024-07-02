package net.vrakin.questionnaire.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import net.vrakin.questionnaire.helper.MethodHelper;
import net.vrakin.questionnaire.model.Question;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import static net.vrakin.questionnaire.helper.HtmlHelper.*;
import static net.vrakin.questionnaire.helper.NameHelper.*;

@Slf4j
public class StatisticServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        out.println(String.format(TEMPLATE, BEFORE_STATISTIC_ANSWERS));

        int requestCounter = MethodHelper.getRequestCounter(request)+1;

        request.getSession().setAttribute(REQUEST_COUNTER_NAME, requestCounter);


        List<Question> questionList = MethodHelper.getQuestions(request);

        questionList.forEach(q->{
            Object answerName = request.getParameter(PREFIX_QUESTIONS+q.getName());

            if (answerName != null){
                int oldValue = q.getAnswers().get(answerName.toString())+1;
                q.getAnswers().put(answerName.toString(), oldValue);
            }
        });

        request.getSession().setAttribute(QUESTION_LIST_NAME, questionList.stream().map(Question::toString).toList());


        out.println(String.format(BEFORE_TOTAL_NUMBER_OF_REQUEST, requestCounter));
        for (Question question: questionList) {
            out.println(String.format("%s: <br>", question.getText()));
            for (Map.Entry<String, Integer> answer : question.getAnswers().entrySet()) {
                out.println(String.format("%s %d%% "
                               +  "<div class=\"w3-border\">"
                                +   "<div class=\"w3-green\" style=\"" + "height:24px;width:%d%%\">"
                                +   "</div>"
                                + "</div> <br>"
                        , answer.getKey(), question.getPercents().get(answer.getKey()), question.getPercents().get(answer.getKey())));
            }
        }

        out.println("</div><br><a href=\"\\questionServlet\">Next user</a>");

    }
}