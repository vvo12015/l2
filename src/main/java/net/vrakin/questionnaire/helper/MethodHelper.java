package net.vrakin.questionnaire.helper;

import jakarta.servlet.http.HttpServletRequest;
import net.vrakin.questionnaire.model.Question;

import java.util.List;

import static net.vrakin.questionnaire.helper.NameHelper.*;

public class MethodHelper {
    public static List<Question> getQuestions(HttpServletRequest request) {
        List<String> stringQuestions;

        if (request.getSession().getAttribute(QUESTION_LIST_NAME) == null){
            stringQuestions = (List<String>) request.getServletContext().getAttribute(QUESTION_LIST_NAME);
        }else{
            stringQuestions = (List<String>) request.getSession().getAttribute(QUESTION_LIST_NAME);
        }

        return stringQuestions.stream().map(Question::new).toList();
    }

    public static Integer getRequestCounter(HttpServletRequest request) {

        int requestCounter = REQUEST_COUNTER_START_VALUE;

        if (request.getSession().getAttribute(REQUEST_COUNTER_NAME) != null){
            requestCounter = Integer.parseInt(request.getSession().getAttribute(REQUEST_COUNTER_NAME).toString());
        }
        return requestCounter;
    }
}
