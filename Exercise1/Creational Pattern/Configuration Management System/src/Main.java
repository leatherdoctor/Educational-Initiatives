import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Current Grading Scheme: " + configManager.getGradingScheme());
            System.out.println("1. Update Grading Scheme");
            System.out.println("2. Update Question Pool");
            System.out.println("3. Update User Settings");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new grading scheme: ");
                    String gradingScheme = scanner.nextLine();
                    configManager.setGradingScheme(gradingScheme);
                    break;
                case 2:
                    System.out.print("Enter new question pool: ");
                    String questionPool = scanner.nextLine();
                    configManager.setQuestionPool(questionPool);
                    break;
                case 3:
                    System.out.print("Enter new user settings: ");
                    String userSettings = scanner.nextLine();
                    configManager.setUserSettings(userSettings);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
