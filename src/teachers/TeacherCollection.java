package teachers;

import constants.Rolls;

import java.util.HashMap;

public class TeacherCollection {
    HashMap<String, Teachers> teachers;

    public TeacherCollection() {
        teachers = new HashMap<>();
    }

    public void addTeacher(String fullName, String phone, String email) {
        String id = "T-" + (teachers.size() + 1);
        teachers.put(id, new Teachers(id, fullName, phone, email, String.valueOf(Rolls.Teacher)));
    }

    public HashMap<String, Teachers> getTeachers() {
        return teachers;
    }
    public Teachers getSpecificTeacher(String key) {
        return teachers.get(key);
    }

    public void showTeacherList() {
        teachers.forEach((key, value) -> {
            System.out.println(key + ". " + value.getFullName());
        });
    }

    public void showUnassignedTeachers() {
        teachers.forEach((key, value) -> {
            if(value.getPromoId() == null) {
                System.out.println(key + ". " + value.getFullName());
            }
        });
    }


}
