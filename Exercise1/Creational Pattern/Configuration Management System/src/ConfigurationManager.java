import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private static final Logger logger = Logger.getLogger(ConfigurationManager.class.getName());

    // Configuration settings
    private String gradingScheme;
    private String questionPool;
    private String userSettings;

    private ConfigurationManager() {
        this.gradingScheme = "Standard";
        this.questionPool = "DefaultPool";
        this.userSettings = "DefaultUserSettings";
        logger.info("ConfigurationManager instance created with default settings.");
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
            logger.info("Created the unique instance of ConfigurationManager.");
        }
        return instance;
    }

    public String getGradingScheme() {
        return gradingScheme;
    }

    public void setGradingScheme(String gradingScheme) {
        if (gradingScheme == null || gradingScheme.isEmpty()) {
            logger.warning("Attempted to set an invalid grading scheme.");
            throw new IllegalArgumentException("Grading scheme cannot be null or empty.");
        }
        this.gradingScheme = gradingScheme;
        logger.info("Grading scheme updated to: " + gradingScheme);
    }

    public String getQuestionPool() {
        return questionPool;
    }

    public void setQuestionPool(String questionPool) {
        if (questionPool == null || questionPool.isEmpty()) {
            logger.warning("Attempted to set an invalid question pool.");
            throw new IllegalArgumentException("Question pool cannot be null or empty.");
        }
        this.questionPool = questionPool;
        logger.info("Question pool updated to: " + questionPool);
    }

    public String getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(String userSettings) {
        if (userSettings == null || userSettings.isEmpty()) {
            logger.warning("Attempted to set invalid user settings.");
            throw new IllegalArgumentException("User settings cannot be null or empty.");
        }
        this.userSettings = userSettings;
        logger.info("User settings updated to: " + userSettings);
    }
}
