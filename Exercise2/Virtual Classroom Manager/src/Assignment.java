import java.util.HashMap;
import java.util.Map;

public class Assignment {
    private String title;
    private boolean submitted;
    private Map<String, Boolean> submissions; // Maps student IDs to submission status

    public Assignment(String title) {
        this.title = title;
        this.submitted = false;
        this.submissions = new HashMap<>();
    }

    public String getTitle() {
        return title;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void submit(String studentId) {
        this.submitted = true;
        submissions.put(studentId, true);
    }

    public boolean isSubmittedBy(String studentId) {
        return submissions.getOrDefault(studentId, false);
    }

    public Map<String, Boolean> getSubmissions() {
        return submissions;
    }
}
