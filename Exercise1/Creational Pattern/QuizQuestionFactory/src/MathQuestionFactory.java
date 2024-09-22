import java.util.Random;
import java.util.logging.Logger;

public class MathQuestionFactory implements QuestionFactory {
    private static final Logger logger = Logger.getLogger(MathQuestionFactory.class.getName());
    private static final Random random = new Random();

    private static final String[] questions = {
            "What is 2 + 2?",
            "What is 5 * 6?",
            "What is 10 - 4?"
    };

    private static final String[] answers = {
            "4", "30", "6"
    };

    @Override
    public Question createQuestion() {
        int index = random.nextInt(questions.length);
        logger.info("Creating a Math MCQ question.");
        return new MCQQuestion(questions[index], new String[]{"Option 1", "Option 2", "Option 3"}, answers[index]);
    }
}
