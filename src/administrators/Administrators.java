package administrators;
import accounts.Accounts;
import constants.Rolls;

import java.util.HashMap;

public class Administrators {
    HashMap<Integer, Accounts> administrators = new HashMap<>();


    public void addAdministrators(String fullName, String phone, String email) {
        int id = administrators.size()+1;
        this.administrators.put(id, new Accounts(id, fullName, phone, email, String.valueOf(Rolls.Administrator)));
    }

    public void getAllAdministrators() {
        administrators.forEach((key, value) -> {
            System.out.println(key + ". " + value.getFullName());
        });
    }
    public void showListAdmins() {
        administrators.forEach((key, value) -> {
            System.out.print(key + ". " + value.getFullName());
        });
    }
}
