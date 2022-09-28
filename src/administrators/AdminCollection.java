package administrators;

import constants.Rolls;

import java.util.HashMap;

public class AdminCollection {
    HashMap<String, Admins> admins;
    public AdminCollection() {
        admins = new HashMap<>();
    }

    public void addAdmin(String fullName, String phone, String email) {
        String id = "A-" + (admins.size()+1);
        this.admins.put(id, new Admins(id, fullName, phone, email, String.valueOf(Rolls.Admin)));
    }

    public void getAllAdmins() {
        System.out.println(admins);
    }

    public void showAdminsList() {
        admins.forEach((key, value) -> {
            System.out.println(key + ". " + value.getFullName());
        });
    }
}
