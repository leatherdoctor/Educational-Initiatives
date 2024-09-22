import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private String name;
    private List<Student> students;
    private List<Assignment> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
        Logger.info("Created classroom: " + name);
    }

    public void addStudent(Student student) throws ClassroomException {
        if (!students.contains(student)) {
            students.add(student);
            Logger.info("Student " + student.getId() + " enrolled in " + name);
        } else {
            throw new ClassroomException("Student " + student.getId() + " is already enrolled in " + name);
        }
    }

    public void scheduleAssignment(String title) {
        Assignment assignment = new Assignment(title);
        assignments.add(assignment);
        Logger.info("Assignment scheduled for " + name + ": " + title);
    }

    public void submitAssignment(String studentId, String assignmentTitle) throws ClassroomException {
        Student student = findStudentById(studentId);
        if (student != null) {
            Assignment assignment = findAssignmentByTitle(assignmentTitle);
            if (assignment != null && !assignment.isSubmitted()) {
                assignment.submit(studentId);
                Logger.info("Assignment submitted by Student " + studentId + " in " + name);
            } else {
                throw new ClassroomException("Assignment " + assignmentTitle + " not found or already submitted in " + name);
            }
        } else {
            throw new ClassroomException("Student " + studentId + " is not enrolled in " + name);
        }
    }

    private Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    private Assignment findAssignmentByTitle(String title) {
        for (Assignment assignment : assignments) {
            if (assignment.getTitle().equals(title)) {
                return assignment;
            }
        }
        return null;
    }

    public void listStudents() {
        if (students.isEmpty()) {
            Logger.info("No students in " + name);
        } else {
            Logger.info("Students in " + name + ":");
            for (Student student : students) {
                System.out.println("- " + student.getId());
            }
        }
    }

    public void checkSubmissions(String assignmentTitle) throws ClassroomException {
        Assignment assignment = findAssignmentByTitle(assignmentTitle);
        if (assignment != null) {
            Logger.info("Submissions for " + assignmentTitle + ":");
            for (String studentId : assignment.getSubmissions().keySet()) {
                String status = assignment.isSubmittedBy(studentId) ? "Submitted" : "Not Submitted";
                System.out.println("Student ID: " + studentId + " - " + status);
            }
        } else {
            throw new ClassroomException("Assignment " + assignmentTitle + " not found in " + name);
        }
    }


}
