public class ShortAnswerQuestion implements Question {
    private String questionText;
    private String answer;

    public ShortAnswerQuestion(String questionText, String answer) {
        if (questionText == null || questionText.trim().isEmpty() || answer == null) {
            throw new IllegalArgumentException("Invalid parameters for Short Answer question.");
        }
        this.questionText = questionText;
        this.answer = answer;
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public String getAnswer() {
        return answer;
    }
}
