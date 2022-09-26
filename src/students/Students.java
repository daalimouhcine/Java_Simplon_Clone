package students;

import accounts.Accounts;
import constants.Rolls;

import java.util.HashMap;

public class Students {
    HashMap<Integer, Accounts> students = new HashMap<>();

    public void addStudent(int id, String fullName, int phone, String email) {
        this.students.put(id, new Accounts(id, fullName, phone, email, String.valueOf(Rolls.Student)));
    }

    public void getAllStudents() {
        System.out.println(students);
    }

}
