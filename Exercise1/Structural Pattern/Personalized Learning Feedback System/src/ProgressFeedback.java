import java.util.logging.Logger;

public class ProgressFeedback extends FeedbackDecorator {
    private static final Logger logger = Logger.getLogger(ProgressFeedback.class.getName());

    public ProgressFeedback(Feedback feedback) {
        super(feedback);
        logger.info("ProgressFeedback added.");
    }

    @Override
    public String getFeedback() {
        return super.getFeedback() + " You're making great progress!";
    }
}
