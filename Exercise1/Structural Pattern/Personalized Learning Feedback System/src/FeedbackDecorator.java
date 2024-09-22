public abstract class FeedbackDecorator implements Feedback {
    protected Feedback feedback;

    public FeedbackDecorator(Feedback feedback) {
        if (feedback == null) {
            throw new IllegalArgumentException("Feedback cannot be null.");
        }
        this.feedback = feedback;
    }

    @Override
    public String getFeedback() {
        return feedback.getFeedback();
    }
}
