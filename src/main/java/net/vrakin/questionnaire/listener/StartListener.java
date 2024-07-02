package net.vrakin.questionnaire.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import lombok.extern.slf4j.Slf4j;
import net.vrakin.questionnaire.helper.NameHelper;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class StartListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent contextEvent) {
        log.info("contextInitialized run");
        List<String> questionList = new ArrayList<>();
        contextEvent.getServletContext().getInitParameterNames().asIterator()
                .forEachRemaining(
                        pn->
                        {
                            if (pn.startsWith(NameHelper.PREFIX_QUESTIONS)) {
                                String questionToString = pn.substring(pn.indexOf(NameHelper.QUESTION_CONTEXT_SEPARATOR)+ NameHelper.SHIFT_FOR_CONTEXT_SEPARATOR)
                                        + NameHelper.QUESTION_SYMBOL +
                                        contextEvent.getServletContext().getInitParameter(pn);
                                questionList.add(questionToString);
                                log.info(questionToString);
                            }
                        }
                );

        contextEvent.getServletContext().setAttribute(NameHelper.QUESTION_LIST_NAME, questionList);
        contextEvent.getServletContext().setAttribute(NameHelper.REQUEST_COUNTER_NAME, NameHelper.REQUEST_COUNTER_START_VALUE);
    }
}

