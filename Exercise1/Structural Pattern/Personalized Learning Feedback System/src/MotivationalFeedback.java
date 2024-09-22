import java.util.logging.Logger;

public class MotivationalFeedback extends FeedbackDecorator {
    private static final Logger logger = Logger.getLogger(MotivationalFeedback.class.getName());

    public MotivationalFeedback(Feedback feedback) {
        super(feedback);
        logger.info("MotivationalFeedback added.");
    }

    @Override
    public String getFeedback() {
        return super.getFeedback() + " Keep pushing! Every effort counts!";
    }
}
