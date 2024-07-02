package net.vrakin.questionnaire.model;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

import static net.vrakin.questionnaire.helper.NameHelper.*;

@Getter
@Setter
@Data
@EqualsAndHashCode
public class Question {

    String name;
    String text;
    Map<String, Integer> answers = new HashMap<>();

    public Question(String questionWhole){
        List<String> questionStrings = new ArrayList<>(Arrays.asList(questionWhole.split(REGEX_QUESTION_SYMBOL)));

        this.name = questionStrings.get(NAME_INDEX);
        this.text = questionStrings.get(TEXT_INDEX);

        String[] answerStrings = questionStrings.get(ANSWERS_INDEX).split(REGEX_SEPARATOR_SYMBOL);

        for (String answerString : answerStrings) {
            answers.put(answerString, ANSWER_COUNTER_START_VALUE);
        }
        if (questionStrings.size()== ELEMENT_COUNT_IN_TO_STRING_OF_OBJECT){
            String[] answerStaticStrings = questionStrings.get(ANSWER_STATISTIC_INDEX).split(REGEX_SEPARATOR_SYMBOL);
            for (int i = 0; i < answerStaticStrings.length; i++) {
                answers.put(answerStrings[i], Integer.valueOf(answerStaticStrings[i]));
            }
        }
    }

    public Map<String, Integer> getPercents() {
        int sum = 0;
        for (Integer value : answers.values()) {
            sum += value;
        }

        Map<String, Integer> percents = new HashMap<>();

        for (Map.Entry<String, Integer> entry : answers.entrySet()) {
            percents.put(entry.getKey(), (entry.getValue()*100) / sum);
        }

        return percents;
    }

    @Override
    public String toString() {
        String questionFullText = name + QUESTION_SYMBOL + text + QUESTION_SYMBOL;
        StringBuilder answerString = new StringBuilder();
        StringBuilder countAnswer = new StringBuilder();

        for (Map.Entry<String, Integer> entry:
                answers.entrySet()) {
            answerString.append(entry.getKey()).append(SEPARATOR_SYMBOL);
            countAnswer.append(entry.getValue()).append(SEPARATOR_SYMBOL);
        }

        //DELETE LAST SEPARATOR
        answerString.deleteCharAt(answerString.length()-1);
        countAnswer.deleteCharAt(countAnswer.length()-1);

        return questionFullText + answerString.toString() + QUESTION_SYMBOL + countAnswer.toString();
    }
}
