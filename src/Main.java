import administrators.Administrators;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.printf("%25s", "____Menu____\n\n");
        System.out.println("shoos one of the rolls to start:\n");
        System.out.println("1. Administrator");
        System.out.println("2. Teacher");
        System.out.println("3. Student");

        Scanner rollIn = new Scanner(System.in);
        int rollSelection = rollIn.nextInt();
        rollIn.close();

        switch (rollSelection) {
            case 1 -> administratorSelection();
            case 2 -> teacherSelection();
            case 3 -> studentSelection();
        }

        System.exit(1);
    }

    public static void administratorSelection() {
        System.out.println("Select one of the Admins");
        Administrators adm = new Administrators();
        adm.addAdministrators("Mouhcine Daali", "0634175255", "the.daali.mouhcine@gmail.com");
        adm.showListAdmins();
    }
    public static void teacherSelection() {
        System.out.println("teacher");
    }
    public static void studentSelection() {
        System.out.println("student");
    }
}