package net.vrakin.questionnaire.helper;

public class HtmlHelper {
    public static final String CONTENT_TYPE = "text/html";
    public static final String TEMPLATE = "<html>"
            + "<head><title>%s</title></head>"
            + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
            + "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">"
            + "<body>" +
            "<div class=\"w3-container\">";
    public static final String BEFORE_ANSWERS = "<h1>Answer these questions:</h1> <br>";
    public static final String ANSWER_FORM_BEGIN = "<form action=\"\\staticServlet\" method=\"POST\">" +
            "<label for=\"firstname\">First name:</label><br>" +
            "  <input type=\"text\" id=\"firstname\" name=\"firstname\" hint=\"First name\"><br>" +
            "  <label for=\"lastname\">Last name:</label><br>" +
            "  <input type=\"text\" id=\"lastname\" name=\"lastname\" hint=\"Last name\"><br>" +
            "  <label for=\"age\">Your age:</label><br>" +
            "  <input type=\"text\" id=\"age\" name=\"age\" hint=\"Age\"><br><br>";
    public static final String QUESTION_TEXT = "<h3>%s</h3>";
    public static final String ANSWER =
            "<input type=\"radio\" id=\"%1s\" name=\"%2$s\" value=\"%1$s\">"+
                    "<label for=\"%1$s\">%1$s</label><br>";
    public static final String ANSWER_FORM_END = "<input type=\"submit\" value=\"Submit\">" +
            "</form></div></body>";

    public static final String PROGRESS_BAR_SYMBOL = "|";

    public static final String BEFORE_STATISTIC_ANSWERS = "Statistic of answers: <br>";
    public static final String BEFORE_TOTAL_NUMBER_OF_REQUEST = "Total number of request: %s<br>";
}
