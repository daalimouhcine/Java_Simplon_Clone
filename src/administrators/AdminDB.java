package administrators;

import config.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class AdminDB {
    static String query = "";

    public static void addAdmin(String fullName, String phone, String email) {
        try {
            query = "INSERT INTO admins (fullName, phone, email) VALUES ('"+ fullName +"', '"+ phone +"', '"+ email +"');";
            Objects.requireNonNull(ConnectionDB.getConnection()).executeUpdate(query);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showAdminsList() {
        try {
            query = "SELECT * FROM admins ;";
           ResultSet rsAdmins = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
           while(rsAdmins.next()) {
               System.out.println(rsAdmins.getString("id") + ": " + rsAdmins.getString("fullName"));
           }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
