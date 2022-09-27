package students;

import accounts.Accounts;
import constants.Rolls;

import java.util.HashMap;

public class Students {
    HashMap<Integer, Accounts> students = new HashMap<>();

    public void addStudent(String fullName, String phone, String email) {
        int id = students.size()+1;
        this.students.put(id, new Accounts(id, fullName, phone, email, String.valueOf(Rolls.Student)));
    }

    public void getAllStudents() {
        System.out.println(students);
    }

}
