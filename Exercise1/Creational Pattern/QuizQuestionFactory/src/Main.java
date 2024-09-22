import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Set up console logging
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);

        logger.info("Question generation system started. Enter 'exit' to terminate.");

        while (true) {
            System.out.println("Select question type (1 for MCQ, 2 for Short Answer, 3 for Fill-in-the-Blank) or type 'exit' to quit:");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                logger.info("Exiting the system.");
                break; // Exit the loop
            }

            QuestionFactory factory = null;

            switch (input) {
                case "1":
                    factory = new MathQuestionFactory();
                    break;
                case "2":
                    factory = new ScienceQuestionFactory();
                    break;
                case "3":
                    factory = new FillInTheBlankQuestionFactory();
                    break;
                default:
                    logger.warning("Invalid question type choice. Please enter 1, 2, or 3.");
                    continue; // Go back to the start of the loop
            }

            Question question = factory.createQuestion();
            System.out.println("Generated Question: " + question.getQuestionText());
            System.out.println("Correct Answer: " + question.getAnswer());
        }

        scanner.close(); // Close the scanner when done
    }
}
