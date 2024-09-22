import java.util.logging.Level;
import java.util.logging.Logger;

public class Student {
    private static final Logger logger = Logger.getLogger(Student.class.getName());
    private LearningStrategy learningStrategy;
    private int performanceScore; // Score from 0 to 100

    public Student(LearningStrategy learningStrategy) {
        this.learningStrategy = learningStrategy;
        this.performanceScore = 100; // Assume starting performance is perfect
    }

    public void setLearningStrategy(LearningStrategy learningStrategy) {
        this.learningStrategy = learningStrategy;
    }

    public void study() {
        learningStrategy.learn();
    }

    public void updatePerformanceScore(int score) {
        if (score < 0 || score > 100) {
            logger.log(Level.WARNING, "Invalid score: {0}. Score must be between 0 and 100.", score);
            return; // Invalid score, do not proceed
        }
        this.performanceScore = score;
        logger.log(Level.INFO, "Performance score updated to: {0}", performanceScore);
        adjustLearningStrategy();
    }

    private void adjustLearningStrategy() {
        if (performanceScore < 60) {
            setLearningStrategy(new VideoLearning());
        } else if (performanceScore < 80) {
            setLearningStrategy(new QuizLearning());
        } else {
            setLearningStrategy(new TextLearning());
        }
    }
}
