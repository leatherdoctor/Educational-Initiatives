public class MCQQuestion implements Question {
    private String questionText;
    private String[] options;
    private String answer;

    public MCQQuestion(String questionText, String[] options, String answer) {
        if (questionText == null || questionText.trim().isEmpty() ||
                options == null || options.length < 2 || answer == null) {
            throw new IllegalArgumentException("Invalid parameters for MCQ question.");
        }
        this.questionText = questionText;
        this.options = options;
        this.answer = answer;
    }

    @Override
    public String getQuestionText() {
        return questionText + "\nOptions: " + String.join(", ", options);
    }

    @Override
    public String getAnswer() {
        return answer;
    }
}
