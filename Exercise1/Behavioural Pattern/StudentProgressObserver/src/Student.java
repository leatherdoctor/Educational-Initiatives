import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student {
    private static final Logger logger = Logger.getLogger(Student.class.getName());

    private String name;
    private String progress;
    private List<Observer> observers = new ArrayList<>();

    public Student(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be null or empty");
        }
        this.name = name;
        this.progress = "Not started";
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void submitAnswer(String answer) {
        if (answer == null || answer.trim().isEmpty()) {
            logger.log(Level.WARNING, "Attempted to submit an empty answer");
            return; // Early exit for invalid input
        }

        this.progress = "Answered: " + answer;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            try {
                observer.update(name, progress);
                logger.info("Notified " + observer.getClass().getSimpleName() + " about " + progress);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error notifying observer: " + observer.getClass().getSimpleName(), e);
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getProgress() {
        return progress;
    }
}
