package promos;

import briefs.Briefs;
import students.Students;

import java.util.HashMap;

public class Promos {
    private String id;
    private String name;
    private String teacherId;
    private HashMap<String, Students> students = new HashMap<>();
    private HashMap<String, Briefs> briefs = new HashMap<>();

    public Promos(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void addStudent(Students student) {
        String id = "S-" + ( students.size() + 1);
        students.put(id, student);
    }

    public void addBrief(Briefs brief) {
        String id = "B-" + ( briefs.size() + 1);
        briefs.put(id, brief);
    }
}
