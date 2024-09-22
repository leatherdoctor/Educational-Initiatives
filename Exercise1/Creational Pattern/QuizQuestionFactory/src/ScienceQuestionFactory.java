import java.util.logging.Logger;

public class ScienceQuestionFactory implements QuestionFactory {
    private static final Logger logger = Logger.getLogger(ScienceQuestionFactory.class.getName());

    @Override
    public Question createQuestion() {
        logger.info("Creating a Science Short Answer question.");
        return new ShortAnswerQuestion("What is the chemical symbol for water?", "H2O");
    }
}
