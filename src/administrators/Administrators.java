package administrators;
import accounts.Accounts;
import constants.Rolls;

import java.util.HashMap;

public class Administrators {
    HashMap<Integer, Accounts> administrators = new HashMap<>();

    public void AddAdministrators(int id, String fullName, int phone, String email) {
        this.administrators.put(1, new Accounts(id, fullName, phone, email, String.valueOf(Rolls.Administrator)));
    }

    public void getAllAdministrators() {
        System.out.println(administrators);
    }
}
