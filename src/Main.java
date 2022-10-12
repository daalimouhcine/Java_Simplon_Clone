import administrators.AdminDB;
import briefs.BriefDB;
import constants.Rolls;
import constants.Technologies;
import promos.PromosDB;
import students.StudentsDB;

import teachers.TeachersDB;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int selectedAccountId;
    public static String selectedRoll;


    public static void main(String[] args) {
//        AdminDB.addAdmin("Mouhcine Daali", "0634175255", "the.daali.mouhcine@gmail.com");

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
//                case 3 -> studentSelection();
                case 4 -> System.exit(1);
                default -> System.out.println("this selection is not supported");
            }
        }
    }

    public static void adminSelection() {
        boolean inAdminSelection = true;

        System.out.println("Select one of the Admins");
        AdminDB.showAdminsList();

        // get admin from user
        Scanner adminIn = new Scanner(System.in);
        selectedAccountId = adminIn.nextInt();
        selectedRoll = String.valueOf(Rolls.Admin);

        while(inAdminSelection) {
            // display the admin's functionality
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
                    TeachersDB.addTeacher(newTeacherFullName, newTeacherPhone, newTeacherEmail);
                }
                case 2 -> {
                    System.out.println("\n\n");
                    TeachersDB.showTeachersList();
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
                    StudentsDB.addStudent(newStudentFullName, newStudentPhone, newStudentEmail);
                }
                case 4 -> {
                    System.out.println("\n\n");
                    StudentsDB.showStudentsList();
                    System.out.println("\n\n");
                }
                case 5 -> {
                    Scanner newPromo = new Scanner(System.in);
                    System.out.println("Name of the Promo: ");
                    String newPromoName = newPromo.nextLine();
                    PromosDB.addPromo(newPromoName);
                }
                case 6 -> {
                    System.out.println("\n\n");
                    PromosDB.showPromosList();
                    System.out.println("\n\n");
                }
                case 7 -> {
                    System.out.println("Select a teacher");
                    TeachersDB.showUnassignedTeachers();
                    Scanner assigningIn = new Scanner(System.in);
                    int teacherToAssign = assigningIn.nextInt();

                    System.out.println("and now select the promo");
                    PromosDB.showUnassignedPromos();
                    int promoToAssign = assigningIn.nextInt();
                    // after getting the teacher id and promo id now we're going to assign each it to the other.
                    PromosDB.assignTeacher(promoToAssign, teacherToAssign);
                    TeachersDB.assignPromo(promoToAssign, teacherToAssign);

                }
                case 8 -> {
                    inAdminSelection = false;
                }
                default -> {
                    System.out.println("sorry this number is not supported.");
                }
            }
        }
    }

    public static void teacherSelection() {
        boolean inTeacherSelection = true;
        System.out.println("Select one of the Teachers");
        TeachersDB.showTeachersList();

        // get teacher from user
        Scanner teacherIn = new Scanner(System.in);
        selectedAccountId = teacherIn.nextInt();
        selectedRoll = String.valueOf(Rolls.Teacher);

        if(!TeachersDB.checkForPromo(selectedAccountId)) {
            System.out.println("**** that teacher is not related with a promo ****");
            inTeacherSelection = false;
        }

        while(inTeacherSelection) {
            // display the teacher's functionality
            System.out.printf("%25s", "____Teacher's Menu____\n\n");
            System.out.println("What you want to do:\n");
            System.out.println("1. Create new Brief");
            System.out.println("2. Show existent Briefs");
            System.out.println("3. Assign Brief to Promo");
            System.out.println("4. Assign Student to Promo");
            System.out.println("5. Show all students of my Promo");
            System.out.println("6. Return");

            Scanner teacherMenuIn = new Scanner(System.in);
            int teacherMenuSelection = teacherMenuIn.nextInt();

            int promoId = TeachersDB.getPoromoId(selectedAccountId);

            switch(teacherMenuSelection) {
                case 1 -> {
                    Scanner newBriefIn = new Scanner(System.in);
                    System.out.print("Enter Brief Title: ");
                    String newBriefTitle = newBriefIn.nextLine();
                    System.out.println("\nEnter Brief Description: ");
                    String newBriefDescription = newBriefIn.nextLine();
                    System.out.println("Select the Technologies (ex:1,2,3,5):");
                    for (Technologies tech : Technologies.values()) {
                        System.out.print(tech.getId() + ": " + tech.getName() + ".  ");
                    }
                    System.out.println("\n");
                    String[] newBriefTechnologies = newBriefIn.nextLine().split(",");
                    ArrayList<String> techs = new ArrayList<>();
                    for (String newBriefTechnology : newBriefTechnologies) {
                        techs.add(Technologies.getById(Integer.parseInt(newBriefTechnology)));
                    }
                    BriefDB.addBrief(promoId, newBriefTitle, newBriefDescription, techs);

                }
                case 2 -> {
                    System.out.println("\n\n");
                    BriefDB.showBriefsList(promoId);
                    System.out.println("\n\n");
                }
                case 3 -> {
                    System.out.println("Select the Brief that you want to launch");
                    System.out.println("\n\n");
                    BriefDB.showBriefsListToLaunch(promoId);
                    System.out.println("\n\n");
                    Scanner briefIn = new Scanner(System.in);
                    int selectedBrief = briefIn.nextInt();
                    BriefDB.launchTheBrief(selectedBrief);

                }
                case 4 -> {
                    System.out.println("\n");
                    System.out.println("Select Students that you want (ex:1,5,4): ");
                    StudentsDB.showStudentsListToAssign();
                    System.out.println("\n\n");
                    Scanner selectStudentIn = new Scanner(System.in);
                    String[] selectedStudents = selectStudentIn.nextLine().split(",");
                    for (String selectedStudent : selectedStudents) {
                        StudentsDB.assignToPromo(Integer.parseInt(selectedStudent), promoId);
                    }
                    System.out.println("All the selected students is added to the promo.");
                }
                case 5 -> {
                    System.out.println("\n");
                    StudentsDB.showStudentsList(promoId);
                    System.out.println("\n\n");
                }
                case 6 -> {
                    inTeacherSelection = false;
                }
                default -> {
                    System.out.println("sorry this number is not supported.");
                }
            }

        }
    }

//    public static void studentSelection() {
//        boolean inStudentSelection = true;
//        System.out.println("Select one of the Students");
//        students.showStudentList();
//
//        // get student from user
//        Scanner studentIn = new Scanner(System.in);
//        selectedAccountId = studentIn.nextLine();
//        selectedRoll = String.valueOf(Rolls.Student);
//
//        if(students.getSpecificStudent(selectedAccountId).getPromoId() == null) {
//            System.out.println("***** Sorry you are not in anny of the promos you don't have access to any thing yat *****");
//            inStudentSelection = false;
//        }
//
//        while(inStudentSelection) {
//            // display the student's functionality
//            System.out.printf("%25s", "____student's Menu____\n\n");
//            System.out.println("What you want to do:\n");
//            System.out.println("1. Show my Promo details");
//            System.out.println("2. Show existent Briefs");
//            System.out.println("3. Show details about specific Brief");
//            System.out.println("4. Validate a brief");
//            System.out.println("5. Return");
//
//            Scanner studentMenuIn = new Scanner(System.in);
//            int studentMenuSelection = studentMenuIn.nextInt();
//
//            Promos studentPromo =  promos.getSpecificPromo(students.getSpecificStudent(selectedAccountId).getPromoId());
//            ArrayList<String> myBriefsByTeacher = teachers.getSpecificTeacher(studentPromo.getTeacherId()).getCreatedBriefs();
//
//
//            switch (studentMenuSelection) {
//                case 1 -> {
//                    Teachers studentTeacher = teachers.getSpecificTeacher(studentPromo.getTeacherId());
//                    System.out.println("Name of the promo: " + studentPromo.getName() + ".\nName of the teacher: " + studentTeacher.getFullName());
//                }
//                case 2 -> {
//                    myBriefsByTeacher.forEach(briefKey -> {
//                        Briefs myBrief = briefs.getSpecificBrief(briefKey);
//                        if(myBrief.isStudentValidate(selectedAccountId) == null) {
//                            System.out.println(myBrief.id + ": " + myBrief.title + " / didn't valid");
//                        } else {
//                            System.out.println(myBrief.id + ": " + myBrief.title + " / validated");
//                        }
//                    });
//                }
//                case 3 -> {
//                    myBriefsByTeacher.forEach(briefKey -> {
//                        Briefs myBrief = briefs.getSpecificBrief(briefKey);
//                        System.out.println(myBrief.id + ": " + myBrief.title);
//                    });
//                    System.out.println("Select the Brief to see details: ");
//                    Scanner briefIn = new Scanner(System.in);
//                    String selectedBriefId = briefIn.nextLine();
//                    Briefs selectedBrief = briefs.getSpecificBrief(selectedBriefId);
//                    System.out.println("Title: " + selectedBrief.title);
//                    System.out.println("Description: " + selectedBrief.description);
//                    System.out.print("Technologies: ");
//                    selectedBrief.technologies.forEach(tech -> {
//                        System.out.print(tech + ",");
//                    });
//                    if(selectedBrief.isStudentValidate(selectedAccountId) == null) {
//                        System.out.println("\nValidation: didn't valid");
//                    } else {
//                        System.out.println("\nValidation: validated");
//                        System.out.println("Validation Message: " + selectedBrief.isStudentValidate(selectedAccountId).message);
//                        System.out.println("Link of the repository: " + selectedBrief.isStudentValidate(selectedAccountId).repoLink);
//                    }
//                }
//                case 4 -> {
//                    myBriefsByTeacher.forEach(briefKey -> {
//                        Briefs myBrief = briefs.getSpecificBrief(briefKey);
//                        if(myBrief.isStudentValidate(selectedAccountId) == null) {
//                            System.out.println(myBrief.id + ": " + myBrief.title);
//                        }
//                    });
//                    System.out.println("Select the Brief to valid: ");
//                    Scanner briefIn = new Scanner(System.in);
//                    String selectedBriefId = briefIn.nextLine();
//                    Briefs selectedBrief = briefs.getSpecificBrief(selectedBriefId);
//                    System.out.println("Message: ");
//                    String validationMessage = briefIn.nextLine();
//                    System.out.println("the link of the repository: ");
//                    String repoLink = briefIn.nextLine();
//                    selectedBrief.validateBrief(selectedAccountId, selectedBriefId, validationMessage, repoLink);
//                }
//                case 5 -> {
//                    inStudentSelection = false;
//                }
//            }
//        }
//    }

}



