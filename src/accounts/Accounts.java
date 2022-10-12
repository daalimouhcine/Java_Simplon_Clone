package accounts;
import constants.Rolls;


public class Accounts {
        private int id;
        private String fullName;
        private String phone;
        private String email;


        public Accounts(int id, String fullName, String phone, String email) {
            this.id = id;
            this.fullName = fullName;
            this.phone = phone;
            this.email = email;

        }


    @Override
    public String toString() {
        return "\nAccount Id: " + this.id + "\nFull Name: " + this.fullName + "\nPhone Number: " + this.phone + "\nEmail: " + this.email + "\n";
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

}

