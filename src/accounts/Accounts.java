package accounts;
import constants.Rolls;


public class Accounts {
        private int id;
        private String fullName;
        private int phone;
        private String email;
        private String roll;

        public Accounts(int id, String fullName, int phone, String email, String roll) {
            this.id = id;
            this.fullName = fullName;
            this.phone = phone;
            this.email = email;
            this.roll = roll;
        }

        private void showDuties(String roll) {
            switch (roll) {
                case "Administrator" -> System.out.println("administrator");
                case "Teacher" -> System.out.println("Teacher");
                case "Student" -> System.out.println("Student");
            }
        }

    @Override
    public String toString() {
        return "\nAccount Id: " + this.id + "\nFull Name: " + this.fullName + "\nPhone Number: " + this.phone + "\nEmail: " + this.email + "\nRoll: " + this.roll + "\n";
    }
}

