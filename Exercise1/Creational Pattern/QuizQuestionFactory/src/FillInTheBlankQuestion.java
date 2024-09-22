public class FillInTheBlankQuestion implements Question {
    private String questionText;
    private String answer;

    public FillInTheBlankQuestion(String questionText, String answer) {
        if (questionText == null || questionText.trim().isEmpty() || answer == null) {
            throw new IllegalArgumentException("Invalid parameters for Fill-in-the-Blank question.");
        }
        this.questionText = questionText;
        this.answer = answer;
    }

    @Override
    public String getQuestionText() {
        return questionText.replace("_____", "_____");
    }

    @Override
    public String getAnswer() {
        return answer;
    }
}
