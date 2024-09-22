import java.util.logging.Level;
import java.util.logging.Logger;

public class BasicFeedback implements Feedback {
    private static final Logger logger = Logger.getLogger(BasicFeedback.class.getName());
    private String feedbackMessage;

    public BasicFeedback(String feedbackMessage) {
        if (feedbackMessage == null || feedbackMessage.isEmpty()) {
            logger.warning("Attempted to create BasicFeedback with invalid message.");
            throw new IllegalArgumentException("Feedback message cannot be null or empty.");
        }
        this.feedbackMessage = feedbackMessage;
        logger.info("BasicFeedback created: " + feedbackMessage);
    }

    @Override
    public String getFeedback() {
        return feedbackMessage;
    }
}
