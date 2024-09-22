import java.util.logging.Logger;

public class QuestionSystem {
    private static final Logger logger = Logger.getLogger(QuestionSystem.class.getName());

    public void addQuestions(String[] questions) {
        logger.info("Questions added:");
        for (String question : questions) {
            logger.info("- " + question);
        }
    }
}
