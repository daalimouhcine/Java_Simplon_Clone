import administrators.AdminCollection;
import briefs.BriefCollection;
import briefs.Briefs;
import constants.Rolls;
import constants.Technologies;
import promos.PromoCollection;
import promos.Promos;
import students.StudentCollection;
import students.Students;
import teachers.TeacherCollection;
import teachers.Teachers;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static String selectedAccountId;
    public static String selectedRoll;

    static AdminCollection admins = new AdminCollection();
    static TeacherCollection teachers = new TeacherCollection();
    static StudentCollection students = new StudentCollection();
    static PromoCollection promos = new PromoCollection();
    static BriefCollection briefs = new BriefCollection();

    public static void main(String[] args) {
        admins.addAdmin("Mouhcine Daali", "0634175255", "the.daali.mouhcine@gmail.com");

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
                case 4 -> System.exit(1);
                default -> System.out.println("this selection is not supported");
            }
        }

    }

    public static void adminSelection() {
        boolean inAdminSelection = true;

        System.out.println("Select one of the Admins");
        admins.showAdminsList();

        // get admin from user
        Scanner adminIn = new Scanner(System.in);
        selectedAccountId = adminIn.nextLine();
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
                case 11 -> {
                    teachers.addTeacher("first teacher", "5678", "firstTeacher@gmail.com");
                    teachers.addTeacher("second teacher", "28486", "secondTeacher@gmail.com");
                    teachers.addTeacher("third teacher", "90170", "thirdTeacher@gmail.com");
                }
                case 33 -> {
                    students.addStudent("first student", "12635", "firstStudent@gmail.com");
                    students.addStudent("second student", "34059", "secondStudent@gmail.com");
                    students.addStudent("third student", "047647", "thirdStudent@gmail.com");
                    students.addStudent("fifth student", "52683", "fifthStudent@gmail.com");
                    students.addStudent("sixth student", "25659", "sixthStudent@gmail.com");
                    students.addStudent("seventh student", "037583", "seventhStudent@gmail.com");
                    students.addStudent("eight student", "34529", "eightStudent@gmail.com");
                    students.addStudent("ninth student", "17583", "ninthStudent@gmail.com");
                    students.addStudent("tenth student", "6347090", "tenthStudent@gmail.com");
                }
                case 55 -> {
                    promos.addPromo("first promo");
                    promos.addPromo("second promo");
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
        teachers.showTeacherList();

        // get teacher from user
        Scanner teacherIn = new Scanner(System.in);
        selectedAccountId = teacherIn.nextLine();
        selectedRoll = String.valueOf(Rolls.Teacher);

        if(teachers.getSpecificTeacher(selectedAccountId).getPromoId() == null) {
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
                    Briefs createdBrief = briefs.addBrief(newBriefTitle, teachers.getSpecificTeacher(selectedAccountId).getPromoId(), newBriefDescription, techs);
                    promos.getSpecificPromo(teachers.getSpecificTeacher(selectedAccountId).getPromoId()).addBrief(createdBrief);
                    teachers.getSpecificTeacher(selectedAccountId).addCreateBrief(createdBrief.id);

                    teachers.getSpecificTeacher(selectedAccountId).showListOfCreatedBriefs();
                }
                case 2 -> {
                    ArrayList<String> createdBriefs =  teachers.getSpecificTeacher(selectedAccountId).getCreatedBriefs();
                    System.out.println("\n\n");
                    createdBriefs.forEach(brief -> {
                        Briefs getBrief = briefs.getSpecificBrief(brief);
                        if(getBrief.promoId.equals(teachers.getSpecificTeacher(selectedAccountId).getPromoId())){
                            System.out.println(getBrief.id + ": " + getBrief.title + " / Launched: " + getBrief.launch + ".");
                        }
                    });
                    System.out.println("\n\n");
                }
                case 3 -> {
                    System.out.println("Select the Brief that you want to launch");
                    ArrayList<String> createdBriefs = teachers.getSpecificTeacher(selectedAccountId).getCreatedBriefs();
                    System.out.println("\n\n");
                    for (String createdBrief : createdBriefs) {
                        Briefs brief = briefs.getSpecificBrief(createdBrief);
                        if(!brief.launch) {
                            System.out.println(brief.id + ": " + brief.title);
                        }
                    }
                    System.out.println("\n\n");
                    Scanner briefIn = new Scanner(System.in);
                    String selectedBrief = briefIn.nextLine();
                    briefs.getSpecificBrief(selectedBrief).launchTheBrief();
                }
                case 4 -> {
                    System.out.println("Select Students that you want (ex:S-1,S-5,S-4): ");
                    students.getAllStudents().forEach((key, value) -> {
                        if(value.getPromoId() == null) {
                            System.out.println(key + ": " + value.getFullName());
                        }
                    });
                    System.out.println("\n\n");
                    Scanner selectStudentIn = new Scanner(System.in);
                    String[] selectedStudents = selectStudentIn.nextLine().split(",");
                    for (String selectedStudent : selectedStudents) {
                        students.getSpecificStudent(selectedStudent).setPromoId(teachers.getSpecificTeacher(selectedAccountId).getPromoId());
                    }
                    System.out.println("All the selected students is added to the promo.");
                }
                case 5 -> {
                    System.out.println("\n\n");
                    students.getAllStudents().forEach((key, value) -> {
                        if(Objects.equals(value.getPromoId(), teachers.getSpecificTeacher(selectedAccountId).getPromoId())) {
                            System.out.println(key + ": " + value.getFullName() + ".");
                        }
                    });
                    System.out.println("\n\n");
                }
                case 6 -> {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    inTeacherSelection = false;
                }
                default -> {
                    System.out.println("sorry this number is not supported.");
                }
            }

        }
    }

    public static void studentSelection() {
        boolean inStudentSelection = true;
        System.out.println("Select one of the Students");
        students.showStudentList();

        // get student from user
        Scanner studentIn = new Scanner(System.in);
        selectedAccountId = studentIn.nextLine();
        selectedRoll = String.valueOf(Rolls.Student);

        if(students.getSpecificStudent(selectedAccountId).getPromoId() == null) {
            System.out.println("***** Sorry you are not in anny of the promos you don't have access to any thing yat *****");
            inStudentSelection = false;
        }

        while(inStudentSelection) {
            // display the student's functionality
            System.out.printf("%25s", "____student's Menu____\n\n");
            System.out.println("What you want to do:\n");
            System.out.println("1. Show my Promo details");
            System.out.println("2. Show existent Briefs");
            System.out.println("3. Show details about specific Brief");
            System.out.println("4. Validate a brief");
            System.out.println("5. Return");

            Scanner studentMenuIn = new Scanner(System.in);
            int studentMenuSelection = studentMenuIn.nextInt();

            Promos studentPromo =  promos.getSpecificPromo(students.getSpecificStudent(selectedAccountId).getPromoId());
            ArrayList<String> myBriefsByTeacher = teachers.getSpecificTeacher(studentPromo.getTeacherId()).getCreatedBriefs();


            switch (studentMenuSelection) {
                case 1 -> {
                    Teachers studentTeacher = teachers.getSpecificTeacher(studentPromo.getTeacherId());
                    System.out.println("Name of the promo: " + studentPromo.getName() + ".\nName of the teacher: " + studentTeacher.getFullName());
                }
                case 2 -> {
                    myBriefsByTeacher.forEach(briefKey -> {
                        Briefs myBrief = briefs.getSpecificBrief(briefKey);
                        if(myBrief.isStudentValidate(selectedAccountId) == null) {
                            System.out.println(myBrief.id + ": " + myBrief.title + " / didn't valid");
                        } else {
                            System.out.println(myBrief.id + ": " + myBrief.title + " / validated");
                        }
                    });
                }
                case 3 -> {
                    myBriefsByTeacher.forEach(briefKey -> {
                        Briefs myBrief = briefs.getSpecificBrief(briefKey);
                        System.out.println(myBrief.id + ": " + myBrief.title);
                    });
                    System.out.println("Select the Brief to see details: ");
                    Scanner briefIn = new Scanner(System.in);
                    String selectedBriefId = briefIn.nextLine();
                    Briefs selectedBrief = briefs.getSpecificBrief(selectedBriefId);
                    System.out.println("Title: " + selectedBrief.title);
                    System.out.println("Description: " + selectedBrief.description);
                    System.out.print("Technologies: ");
                    selectedBrief.technologies.forEach(tech -> {
                        System.out.print(tech + ",");
                    });
                    if(selectedBrief.isStudentValidate(selectedAccountId) == null) {
                        System.out.println("\nValidation: didn't valid");
                    } else {
                        System.out.println("\nValidation: validated");
                        System.out.println("Validation Message: " + selectedBrief.isStudentValidate(selectedAccountId).message);
                        System.out.println("Link of the repository: " + selectedBrief.isStudentValidate(selectedAccountId).repoLink);
                    }
                }
                case 4 -> {
                    myBriefsByTeacher.forEach(briefKey -> {
                        Briefs myBrief = briefs.getSpecificBrief(briefKey);
                        if(myBrief.isStudentValidate(selectedAccountId) == null) {
                            System.out.println(myBrief.id + ": " + myBrief.title);
                        }
                    });
                    System.out.println("Select the Brief to valid: ");
                    Scanner briefIn = new Scanner(System.in);
                    String selectedBriefId = briefIn.nextLine();
                    Briefs selectedBrief = briefs.getSpecificBrief(selectedBriefId);
                    System.out.println("Message: ");
                    String validationMessage = briefIn.nextLine();
                    System.out.println("the link of the repository: ");
                    String repoLink = briefIn.nextLine();
                    selectedBrief.validateBrief(selectedAccountId, selectedBriefId, validationMessage, repoLink);
                }
                case 5 -> {
                    inStudentSelection = false;
                }
            }
        }
    }
}