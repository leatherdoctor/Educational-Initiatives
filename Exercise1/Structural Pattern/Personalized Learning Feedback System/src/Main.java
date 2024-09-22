import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter your feedback message (or type 'exit' to quit): ");
            String message = scanner.nextLine();

            // Exit condition
            if (message.equalsIgnoreCase("exit")) {
                running = false;
                System.out.println("Exiting the Personalized Learning Feedback System.");
                break; // Break the loop to exit
            }

            // Input validation for feedback message
            if (message == null || message.isEmpty()) {
                logger.warning("Invalid feedback message input.");
                System.out.println("Feedback message cannot be empty. Please try again.");
                continue;
            }

            Feedback feedback = new BasicFeedback(message);

            System.out.print("Enter your score: ");
            int score;
            try {
                score = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                logger.warning("Invalid score input: " + e.getMessage());
                System.out.println("Please enter a valid number for the score. Try again.");
                continue;
            }

            // Determine which feedback to apply
            if (score < 50) {
                feedback = new MotivationalFeedback(feedback);
            } else if (score >= 50 && score < 80) {
                feedback = new HintFeedback(feedback);
            } else {
                feedback = new ProgressFeedback(feedback);
            }

            System.out.println("Personalized Feedback: " + feedback.getFeedback());
            logger.info("Feedback delivered to the user.");
        }

        scanner.close();
    }
}
