import java.util.HashMap;
import java.util.Map;

public class ClassroomManager {
    private Map<String, Classroom> classrooms;
    private static ClassroomManager instance;

    private ClassroomManager() {
        this.classrooms = new HashMap<>();
    }

    public static ClassroomManager getInstance() {
        if (instance == null) {
            instance = new ClassroomManager();
        }
        return instance;
    }

    public void addClassroom(String className) {
        if (!classrooms.containsKey(className)) {
            classrooms.put(className, new Classroom(className));
            Logger.info("Classroom " + className + " has been created.");
        } else {
            Logger.error("Classroom " + className + " already exists.");
        }
    }

    public Classroom getClassroom(String className) {
        if (classrooms.containsKey(className)) {
            return classrooms.get(className);
        } else {
            Logger.error("Classroom " + className + " does not exist.");
            return null;
        }
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            Logger.info("No classrooms available.");
        } else {
            Logger.info("Classrooms:");
            for (String className : classrooms.keySet()) {
                System.out.println("- " + className);
            }
        }
    }

    public void removeClassroom(String className) throws ClassroomException {
        Classroom classroom = classrooms.remove(className);
        if (classroom != null) {
            Logger.info("Classroom " + className + " has been removed.");
        } else {
            Logger.error("Attempted to remove non-existent classroom: " + className);
            throw new ClassroomException("Classroom " + className + " does not exist.");
        }
    }

}
