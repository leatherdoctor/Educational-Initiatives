import java.util.logging.Logger;

public class Teacher implements Observer {
    private static final Logger logger = Logger.getLogger(Teacher.class.getName());

    private String name;

    public Teacher(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Teacher name cannot be null or empty");
        }
        this.name = name;
    }

    @Override
    public void update(String studentName, String progress) {
        logger.info("Teacher " + name + " is notified. Student: " + studentName + ", Progress: " + progress);
    }
}
