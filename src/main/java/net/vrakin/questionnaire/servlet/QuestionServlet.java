package net.vrakin.questionnaire.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.vrakin.questionnaire.helper.MethodHelper;
import net.vrakin.questionnaire.model.Question;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static net.vrakin.questionnaire.helper.HtmlHelper.*;
import static net.vrakin.questionnaire.helper.NameHelper.*;

public class QuestionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        List<String> stringQuestions;

        List<Question> questionList = MethodHelper.getQuestions(request);

        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();

        out.println(String.format(TEMPLATE + BEFORE_ANSWERS, "Questions"));
        out.println(ANSWER_FORM_BEGIN);

        for (Question question : questionList) {
            out.println(String.format(QUESTION_TEXT, question.getText()));
            question.getAnswers().forEach((key, value) -> out.println(String.format(ANSWER, key, PREFIX_QUESTIONS + question.getName())));
        }

        out.println(ANSWER_FORM_END);
    }
}