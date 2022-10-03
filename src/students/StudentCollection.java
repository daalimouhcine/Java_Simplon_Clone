package students;

import constants.Rolls;

import java.util.HashMap;

public class StudentCollection {
    HashMap<String, Students> students;



    public StudentCollection() {
        students = new HashMap<>();
    }

    public void addStudent(String fullName, String phone, String email) {
        String id = "S-" + (students.size() + 1);
        students.put(id, new Students(id, fullName, phone, email, String.valueOf(Rolls.Student)));
    }

    public HashMap<String, Students> getAllStudents() {
        return students;
    }

    public void showStudentList() {
        students.forEach((key, value) -> {
            System.out.println(key + ". " + value.getFullName());
        });
    }

    public Students getSpecificStudent(String key) {
        return students.get(key);
    }
}




