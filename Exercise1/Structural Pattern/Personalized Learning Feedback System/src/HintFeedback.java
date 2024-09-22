import java.util.logging.Logger;

public class HintFeedback extends FeedbackDecorator {
    private static final Logger logger = Logger.getLogger(HintFeedback.class.getName());

    public HintFeedback(Feedback feedback) {
        super(feedback);
        logger.info("HintFeedback added.");
    }

    @Override
    public String getFeedback() {
        return super.getFeedback() + " Hint: Review the material on your last quiz.";
    }
}
