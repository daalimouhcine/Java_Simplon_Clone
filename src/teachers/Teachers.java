package teachers;

import accounts.Accounts;
import constants.Rolls;

import java.util.HashMap;

public class Teachers {
    HashMap<Integer, Accounts> teachers = new HashMap<>();

    public void addTeacher(int id, String fullName, int phone, String email) {
        this.teachers.put(id, new Accounts(id, fullName, phone, email, String.valueOf(Rolls.Teacher)));
    }

    public void getAllTeachers() {
        System.out.println(teachers);
    }
}
