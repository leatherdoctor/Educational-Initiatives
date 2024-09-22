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

        // Create students and teachers
        Student student1 = new Student("John");
        Student student2 = new Student("Emma");
        Teacher teacher1 = new Teacher("Mr. Smith");
        Teacher teacher2 = new Teacher("Ms. Johnson");

        // Add observers (teachers) to the students
        student1.addObserver(teacher1);
        student1.addObserver(teacher2);
        student2.addObserver(teacher1);

        logger.info("System started. Enter 'exit' to terminate.");

        while (true) {
            System.out.println("Choose a student (1 for John, 2 for Emma) or type 'exit' to quit:");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                logger.info("Exiting the system.");
                break; // Exit the loop
            }

            Student selectedStudent = null;
            if (input.equals("1")) {
                selectedStudent = student1;
            } else if (input.equals("2")) {
                selectedStudent = student2;
            } else {
                logger.warning("Invalid student choice. Please enter 1 or 2.");
                continue; // Go back to the start of the loop
            }

            System.out.println("Enter an answer for " + selectedStudent.getName() + ":");
            String answer = scanner.nextLine().trim();

            try {
                selectedStudent.submitAnswer(answer);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "An error occurred while submitting the answer.", e);
            }
        }

        scanner.close(); // Close the scanner when done
    }
}
