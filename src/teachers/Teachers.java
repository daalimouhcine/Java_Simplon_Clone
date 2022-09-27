package teachers;

import accounts.Accounts;
import briefs.Briefs;
import constants.Rolls;

import java.util.ArrayList;
import java.util.HashMap;

public class Teachers extends Accounts{
    private int promoId;
    private ArrayList<Briefs> createdBriefs;
    HashMap<Integer, Accounts> teachers = new HashMap<>();

    public Teachers(int id, String fullName, String phone, String email, String roll) {
        super(id, fullName, phone, email, roll);
    }

    public void addTeacher(String fullName, String phone, String email) {
        int id = teachers.size()+1;
        this.teachers.put(id, new Accounts(id, fullName, phone, email, String.valueOf(Rolls.Teacher)));
    }

    public void getAllTeachers() {
        System.out.println(teachers);
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }
}
