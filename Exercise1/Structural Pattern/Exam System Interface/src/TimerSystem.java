import java.util.logging.Logger;

public class TimerSystem {
    private static final Logger logger = Logger.getLogger(TimerSystem.class.getName());
    private long startTime;
    private long endTime;

    public void startTimer() {
        startTime = System.currentTimeMillis();
        logger.info("Timer started.");
    }

    public void stopTimer() {
        endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        logger.info("Timer stopped. Duration: " + (duration / 1000) + " seconds.");
    }
}
