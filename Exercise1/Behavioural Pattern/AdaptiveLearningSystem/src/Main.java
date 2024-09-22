import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student(new TextLearning());
        int choice = 0;

        do {
            System.out.println("\n--- Adaptive Learning System ---");
            System.out.println("1. Study");
            System.out.println("2. Update Performance Score");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        student.study();
                        break;
                    case 2:
                        System.out.print("Enter performance score (0-100): ");
                        int score = scanner.nextInt();
                        student.updatePerformanceScore(score);
                        break;
                    case 3:
                        logger.log(Level.INFO, "Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                logger.log(Level.SEVERE, "Input mismatch error: {0}", e.getMessage());
                scanner.next(); // Clear invalid input
                System.out.println("Please enter a valid number.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
