import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        ExamSystemFacade examSystem = new ExamSystemFacade();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter number of questions (or type 'exit' to quit): ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    logger.info("Exiting the exam setup.");
                    break;
                }

                int numQuestions = Integer.parseInt(input);
                if (numQuestions <= 0) {
                    logger.warning("Number of questions must be positive.");
                    continue;
                }

                String[] questions = new String[numQuestions];
                for (int i = 0; i < numQuestions; i++) {
                    System.out.print("Enter question " + (i + 1) + ": ");
                    questions[i] = scanner.nextLine();
                }

                examSystem.addQuestions(questions);
                examSystem.startExam();

                System.out.println("Press Enter to submit the exam.");
                scanner.nextLine();

                examSystem.submitExam();
            } catch (NumberFormatException e) {
                logger.warning("Invalid input. Please enter a number.");
            } catch (Exception e) {
                logger.severe("An error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
