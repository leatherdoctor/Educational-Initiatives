import java.util.logging.Logger;

public class ExamSystemFacade implements ExamSystem {
    private static final Logger logger = Logger.getLogger(ExamSystemFacade.class.getName());
    private QuestionSystem questionSystem;
    private TimerSystem timerSystem;
    private GradingSystem gradingSystem;

    public ExamSystemFacade() {
        questionSystem = new QuestionSystem();
        timerSystem = new TimerSystem();
        gradingSystem = new GradingSystem();
    }

    @Override
    public void startExam() {
        timerSystem.startTimer();
        logger.info("Exam started.");
    }

    @Override
    public void addQuestions(String[] questions) {
        questionSystem.addQuestions(questions);
    }

    @Override
    public void submitExam() {
        timerSystem.stopTimer();
        gradingSystem.gradeExam();
        logger.info("Exam submitted and graded.");
    }
}
