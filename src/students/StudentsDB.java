package students;

import briefs.Briefs;
import config.ConnectionDB;
import models.SendEnhancedRequestBody;
import models.SendEnhancedResponseBody;
import models.SendRequestMessage;
import services.Courier;
import services.SendService;
import teachers.Teachers;
import teachers.TeachersDB;

import java.io.IOException;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;

public class StudentsDB {
    static String query = "";

    public static void addStudent(String fullName, String phone, String email) {
        try {
            query = "INSERT INTO students (fullName, phone, email, promoId) VALUES ('"+ fullName +"', '"+ phone +"', '"+ email +"', null);";
            Objects.requireNonNull(ConnectionDB.getConnection()).executeUpdate(query);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showStudentsList() {
        try {
            query = "SELECT * FROM students ;";
            ResultSet rsstudents = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            while(rsstudents.next()) {
                System.out.println(rsstudents.getString("id") + ": " + rsstudents.getString("fullName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void showStudentsList(int promoId) {
        try {
            query = "SELECT * FROM students WHERE promoid = " + promoId + ";";
            ResultSet rsstudents = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            while(rsstudents.next()) {
                System.out.println(rsstudents.getString("id") + ": " + rsstudents.getString("fullName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sendEmailToStudent(Briefs brief) {

        try{
            query = "SELECT * FROM students WHERE promoid = " + brief.promoId + " ;";
            ResultSet rsstudents = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            while(rsstudents.next()) {
                sendEmail(brief, new Students(rsstudents.getInt("id"), rsstudents.getString("fullName"), rsstudents.getString("phone"), rsstudents.getString("email")));
            }

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void sendEmail(Briefs brief, Students student) {

        Courier.init("pk_prod_Q02ESMDGP3MRBNMWTZ3Q1XN0A244");

        SendEnhancedRequestBody sendEnhancedRequestBody = new SendEnhancedRequestBody();
        SendRequestMessage sendRequestMessage = new SendRequestMessage();
        HashMap<String, String> to = new HashMap<String, String>();
        to.put("email", student.getEmail());
        sendRequestMessage.setTo(to);


        HashMap<String, String> content = new HashMap<String, String>();
        content.put("title", "Simplon Clone : Nouveau Brief");
        content.put("body", "Hello " + student.getFullName() + ",\nYour teacher is assign the brief: " + brief.title + " for your promo.\n" + "Brief Details:\nTitle: " + brief.title +".\nDescription: " + brief.description + ".\nTechnologies: " + brief.technologies);
        sendRequestMessage.setContent(content);

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("joke", "Why do Java programmers have to wear glasses? Because they don't C#");
        sendRequestMessage.setData(data);
        sendEnhancedRequestBody.setMessage(sendRequestMessage);

        try {
            SendEnhancedResponseBody response = new SendService().sendEnhancedMessage(sendEnhancedRequestBody);
            System.out.println(response);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showStudentsListToAssign() {
        try {
            query = "SELECT * FROM students WHERE promoid IS NULL ;";
            ResultSet rsstudents = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            while(rsstudents.next()) {
                System.out.println(rsstudents.getString("id") + ": " + rsstudents.getString("fullName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void assignToPromo(int studentId, int promoId) {
        try {
            query = "UPDATE students SET promoid = " + promoId + " WHERE id = " + studentId + " ;";
            Objects.requireNonNull(ConnectionDB.getConnection()).executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
