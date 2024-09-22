import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassroomManager manager = ClassroomManager.getInstance();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Virtual Classroom Manager!");

        while (true) {
            System.out.print("\nEnter command: ");
            command = scanner.nextLine();
            String[] parts = command.split(" ");

            try {
                switch (parts[0]) {
                    case "add_classroom":
                        if (parts.length == 2) {
                            manager.addClassroom(parts[1]);
                        } else {
                            throw new ClassroomException("Usage: add_classroom <class_name>");
                        }
                        break;

                    case "remove_classroom":
                        if (parts.length == 2) {
                            manager.removeClassroom(parts[1]);
                        } else {
                            throw new ClassroomException("Usage: remove_classroom <class_name>");
                        }
                        break;

                    case "add_student":
                        if (parts.length == 3) {
                            Classroom classroom = manager.getClassroom(parts[2]);
                            if (classroom != null) {
                                Student student = new Student(parts[1]);
                                classroom.addStudent(student);
                            } else {
                                throw new ClassroomException("Classroom " + parts[2] + " does not exist.");
                            }
                        } else {
                            throw new ClassroomException("Usage: add_student <student_id> <class_name>");
                        }
                        break;

                    case "schedule_assignment":
                        if (parts.length >= 3) {
                            Classroom classroom = manager.getClassroom(parts[1]);
                            if (classroom != null) {
                                String assignmentTitle = command.substring(command.indexOf(parts[2]));
                                classroom.scheduleAssignment(assignmentTitle);
                            } else {
                                throw new ClassroomException("Classroom " + parts[1] + " does not exist.");
                            }
                        } else {
                            throw new ClassroomException("Usage: schedule_assignment <class_name> <assignment_title>");
                        }
                        break;

                    case "submit_assignment":
                        if (parts.length >= 4) {
                            Classroom classroom = manager.getClassroom(parts[2]);
                            if (classroom != null) {
                                String assignmentTitle = command.substring(command.indexOf(parts[3]));
                                classroom.submitAssignment(parts[1], assignmentTitle);
                            } else {
                                throw new ClassroomException("Classroom " + parts[2] + " does not exist.");
                            }
                        } else {
                            throw new ClassroomException("Usage: submit_assignment <student_id> <class_name> <assignment_title>");
                        }
                        break;

                    case "check_submissions":
                        if (parts.length == 3) {
                            Classroom classroom = manager.getClassroom(parts[1]);
                            if (classroom != null) {
                                classroom.checkSubmissions(parts[2]);
                            } else {
                                throw new ClassroomException("Classroom " + parts[1] + " does not exist.");
                            }
                        } else {
                            throw new ClassroomException("Usage: check_submissions <class_name> <assignment_title>");
                        }
                        break;

                    case "list_classrooms":
                        manager.listClassrooms();
                        break;

                    case "list_students":
                        if (parts.length == 2) {
                            Classroom classroom = manager.getClassroom(parts[1]);
                            if (classroom != null) {
                                classroom.listStudents();
                            } else {
                                throw new ClassroomException("Classroom " + parts[1] + " does not exist.");
                            }
                        } else {
                            throw new ClassroomException("Usage: list_students <class_name>");
                        }
                        break;

                    case "exit":
                        Logger.info("Exiting the application.");
                        System.exit(0);

                    default:
                        Logger.error("Unknown command.");
                        break;
                }
            } catch (ClassroomException e) {
                Logger.error(e.getMessage());
            }
        }
    }
}
