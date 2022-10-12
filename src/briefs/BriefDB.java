package briefs;

import config.ConnectionDB;
import students.StudentsDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class BriefDB {
    static String query = "";

    public static void addBrief(int promoId, String title, String description, ArrayList technologies) {
        try {
            String techs = "";
            for (int i = 0; i <= technologies.size()-1; i++) {
                techs = techs + String.valueOf(technologies.get(i));
                if(i != technologies.size()-1) {
                    techs = techs + " , ";
                }
            }

            query = "INSERT INTO briefs (promoid, title, description, technologies) VALUES ('"+ promoId +"', '"+ title +"', '"+ description+"', '{"+ techs +"}');";
            Objects.requireNonNull(ConnectionDB.getConnection()).executeUpdate(query);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showBriefsList(int promoId) {
        try {
            query = "SELECT * FROM briefs WHERE promoid = " + promoId + ";";
            ResultSet rsbriefs = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            while(rsbriefs.next()) {
                System.out.println(rsbriefs.getString("id") + ": " + rsbriefs.getString("title") + " \ndescription: " + rsbriefs.getString("description") + " \ntechnologies: " + rsbriefs.getString("technologies") + "\nLaunched: " + rsbriefs.getBoolean("launch") + "." );
                System.out.println("--------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showBriefsListToLaunch(int promoId) {
        try {
            query = "SELECT * FROM briefs WHERE promoid = " + promoId + ";";
            ResultSet rsbriefs = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            while(rsbriefs.next()) {
                if(!rsbriefs.getBoolean("launch")) {
                    System.out.println(rsbriefs.getString("id") + ": " + rsbriefs.getString("title") + " \ndescription: " + rsbriefs.getString("description") + " \ntechnologies: " + rsbriefs.getString("technologies") );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void launchTheBrief(int selectedBrief) {
        try {
            query = "UPDATE briefs SET launch = true  WHERE id = " + selectedBrief + ";";
            Objects.requireNonNull(ConnectionDB.getConnection()).executeUpdate(query);
            System.out.println("you launched the brief successfully");
            query = "SELECT * FROM briefs WHERE id = " + selectedBrief + " ;";
            ResultSet brief = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            while(brief.next()) {
                StudentsDB.sendEmailToStudent(new Briefs(brief.getInt("id"),brief.getInt("promoId"), brief.getString("title"), brief.getString("description"), brief.getString("technologies")));
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
