import administrators.AdminCollection;
import constants.Rolls;
import promos.PromoCollection;
import students.StudentCollection;
import teachers.TeacherCollection;


import java.util.Scanner;

public class Main {
    public static String selectedAccount;
    public static String selectedRoll;

    static TeacherCollection teachers = new TeacherCollection();
    static StudentCollection students = new StudentCollection();
    static PromoCollection promos = new PromoCollection();

    public static void main(String[] args) {
        boolean inUserSelection = true;
        while(inUserSelection) {
            System.out.printf("%25s", "____Menu____\n\n");
            System.out.println("shoos one of the rolls to start:\n");
            System.out.println("1. Admin");
            System.out.println("2. Teacher");
            System.out.println("3. Student");
            System.out.println("4. Exit");

            // get roll from user
            Scanner rollIn = new Scanner(System.in);
            int rollSelection = rollIn.nextInt();

            switch (rollSelection) {
                case 1 -> adminSelection();
                case 2 -> teacherSelection();
                case 3 -> studentSelection();
                default -> System.exit(1);

            }
        }

    }

    public static void adminSelection() {
        boolean inAdminSelection = true;

        System.out.println("Select one of the Admins");
        AdminCollection adm = new AdminCollection();
        adm.addAdmin("Mouhcine Daali", "0634175255", "the.daali.mouhcine@gmail.com");
        adm.showAdminsList();

        // get admin from user
        Scanner adminIn = new Scanner(System.in);
        int adminSelection = adminIn.nextInt();
        selectedAccount = "A-" + adminSelection;
        selectedRoll = String.valueOf(Rolls.Admin);

        while(inAdminSelection) {
            // display the admin functionality
            System.out.printf("%25s", "____Admin Menu____\n\n");
            System.out.println("What you want to do:\n");
            System.out.println("1. Create new Teacher");
            System.out.println("2. Show existent Teachers");
            System.out.println("3. Create new Student");
            System.out.println("4. Show existent Students");
            System.out.println("5. Create new Promo");
            System.out.println("6. Show existent Promos");
            System.out.println("7. Assign Promo to Teacher");
            System.out.println("8. Return");

            Scanner adminMenuIn = new Scanner(System.in);
            int adminMenuSelection = adminMenuIn.nextInt();

            switch (adminMenuSelection) {
                // add new Teacher.
                case 1 -> {
                    Scanner newTeacherIn = new Scanner(System.in);
                    System.out.println("Teacher's Full Name: ");
                    String newTeacherFullName = newTeacherIn.nextLine();
                    System.out.println("Teacher's Phone number: ");
                    String newTeacherPhone = newTeacherIn.nextLine();
                    System.out.println("Teacher's Email: ");
                    String newTeacherEmail = newTeacherIn.nextLine();
                    teachers.addTeacher(newTeacherFullName, newTeacherPhone, newTeacherEmail);
                }
                case 2 -> {
                    System.out.println("\n\n");
                    teachers.showTeacherList();
                    System.out.println("\n\n");
                }
                case 3 -> {
                    Scanner newStudentIn = new Scanner(System.in);
                    System.out.println("Student's Full Name: ");
                    String newStudentFullName = newStudentIn.nextLine();
                    System.out.println("Student's Phone number: ");
                    String newStudentPhone = newStudentIn.nextLine();
                    System.out.println("Student's Email: ");
                    String newStudentEmail = newStudentIn.nextLine();
                    students.addStudent(newStudentFullName, newStudentPhone, newStudentEmail);
                }
                case 4 -> {
                    System.out.println("\n\n");
                    students.showStudentList();
                    System.out.println("\n\n");
                }
                case 5 -> {
                    Scanner newPromo = new Scanner(System.in);
                    System.out.println("Name of the Promo: ");
                    String newPromoName = newPromo.nextLine();
                    promos.addPromo(newPromoName);
                }
                case 6 -> {
                    System.out.println("\n\n");
                    promos.showPromoList();
                    System.out.println("\n\n");
                }
                case 7 -> {
                    System.out.println("Select a teacher");
                    teachers.showUnassignedTeachers();
                    Scanner assigningIn = new Scanner(System.in);
                    String teacherToAssign = assigningIn.nextLine();

                    System.out.println("and now select the promo");
                    promos.showUnassignedPromos();
                    String promoToAssign = assigningIn.nextLine();
                    // after getting the teacher id and promo id now we're going to assign each it to the other.
                    teachers.getTeachers().get(teacherToAssign).setPromoId(promoToAssign);
                    promos.getPromos().get(promoToAssign).setTeacherId(teacherToAssign);

                }
                case 8 -> {
                    inAdminSelection = false;
                }
            }
        }
    }



    public static void teacherSelection() {
        boolean inAdminSelection = true;
        System.out.println("Select one of the Teachers");

        // get admin from user
        Scanner adminIn = new Scanner(System.in);
        int adminSelection = adminIn.nextInt();
        adminIn.close();
    }

    public static void studentSelection() {
        System.out.println("student");
    }
}