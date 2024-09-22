import java.util.logging.Logger;

public class FillInTheBlankQuestionFactory implements QuestionFactory {
    private static final Logger logger = Logger.getLogger(FillInTheBlankQuestionFactory.class.getName());

    @Override
    public Question createQuestion() {
        logger.info("Creating a Fill-in-the-Blank question.");
        return new FillInTheBlankQuestion("The capital of France is _____.", "Paris");
    }
}
