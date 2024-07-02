package net.vrakin.questionnaire.helper;

public class NameHelper{
    public static final String PREFIX_QUESTIONS = "question.";
    public static final String QUESTION_LIST_NAME = "questions";
    public static final String REQUEST_COUNTER_NAME = "requests";
    public static final String QUESTION_CONTEXT_SEPARATOR = ".";
    public static final int SHIFT_FOR_CONTEXT_SEPARATOR = 1;

    public static final int REQUEST_COUNTER_START_VALUE = 0;
    public static final int NAME_INDEX = 0;
    public static final int TEXT_INDEX = 1;
    public static final int ANSWERS_INDEX = 2;
    public static final int ANSWER_STATISTIC_INDEX = 3;
    public static final String QUESTION_SYMBOL = "?";
    public static final String REGEX_QUESTION_SYMBOL = "\\?";
    public static final String SEPARATOR_SYMBOL = "|";
    public static final String REGEX_SEPARATOR_SYMBOL = "\\|";

    public static final int ANSWER_COUNTER_START_VALUE = 0;
    //4 ELEMENTS: NAME?TEXT?ANSWERS?ANSWER_STATISTIC
    public static final int ELEMENT_COUNT_IN_TO_STRING_OF_OBJECT = 4;
}
