package teachers;

import config.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class TeachersDB {
    static String query = "";

    public static void addTeacher(String fullName, String phone, String email) {
        try {
            query = "INSERT INTO teachers (fullName, phone, email, promoid) VALUES ('"+ fullName +"', '"+ phone +"', '"+ email +"', null);";
            Objects.requireNonNull(ConnectionDB.getConnection()).executeUpdate(query);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showTeachersList() {
        try {
            query = "SELECT * FROM teachers ;";
            ResultSet rsteachers = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            while(rsteachers.next()) {
                System.out.println(rsteachers.getString("id") + ": " + rsteachers.getString("fullName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showUnassignedTeachers() {
        try {
            query = "SELECT * FROM teachers ;";
            ResultSet rsteachers = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            while(rsteachers.next()) {
                if(rsteachers.getString("promoId") == null) {
                    System.out.println(rsteachers.getString("id") + ": " + rsteachers.getString("fullName"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Teachers getSpecificTeacher(int id) {
        try {
            query = "SELECT * FROM teachers WHERE id = " + id + ";";
            ResultSet rsteachers = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            return new Teachers(rsteachers.getInt("id"), rsteachers.getString("fullName"), rsteachers.getString("phone"), rsteachers.getString("email"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static Teachers getSpecificTeacherByPromo(int promoId) {
        try {
            query = "SELECT * FROM teachers WHERE promoid = " + promoId + ";";
            ResultSet rsteachers = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            return new Teachers(rsteachers.getInt("id"), rsteachers.getString("fullName"), rsteachers.getString("phone"), rsteachers.getString("email"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean assignPromo(int promoId, int teacherId) {
        try {
            query = "SELECT * FROM teachers WHERE id = " + teacherId + ";";
            ResultSet rsteacher = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            while(rsteacher.next()) {
                if (rsteacher.getString("promoid") == null) {
                    query = "UPDATE teachers SET promoid = " + promoId + " WHERE id = " + teacherId + ";";
                    Objects.requireNonNull(ConnectionDB.getConnection()).executeUpdate(query);
                    System.out.println("you assign a teacher to promo successfully");
                    return true;
                } else {
                    System.out.println("you selected a teacher that all ready assigned to a promo.");
                    return false;
                }
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    public static boolean checkForPromo(int id) {
        try {
            query = "SELECT * FROM teachers WHERE id = " + id + ";";
            ResultSet rsteachers = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            while(rsteachers.next()) {
                if(rsteachers.getString("promoId") == null) {
                    return false;
                } else {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }


    public static int getPoromoId(int id) {
        try {
            query = "SELECT * FROM teachers WHERE id = " + id + ";";
            ResultSet rsteachers = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            while(rsteachers.next()) {
                return rsteachers.getInt("promoId");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
