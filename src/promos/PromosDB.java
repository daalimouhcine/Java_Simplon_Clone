package promos;

import config.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class PromosDB {
    static String query = "";

    public static void addPromo(String name) {
        try {
            query = "INSERT INTO promos (name, teacherid) VALUES ('"+ name +"', null);";
            Objects.requireNonNull(ConnectionDB.getConnection()).executeUpdate(query);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showPromosList() {
        try {
            query = "SELECT * FROM promos ;";
            ResultSet rspromos = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            while(rspromos.next()) {
                System.out.println(rspromos.getString("id") + ": " + rspromos.getString("name") + " / " + rspromos.getString("teacherId") );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showUnassignedPromos() {
        try {
            query = "SELECT * FROM promos ;";
            ResultSet rspromos = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            while(rspromos.next()) {
                if(rspromos.getString("teacherId") == null) {
                    System.out.println(rspromos.getString("id") + ": " + rspromos.getString("name"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void assignTeacher(int promoId, int teacherId) {
        try {
            query = "SELECT * FROM promos WHERE id = " + promoId + ";";
            ResultSet rspromo = Objects.requireNonNull(ConnectionDB.getConnection()).executeQuery(query);
            while(rspromo.next()) {
                if(rspromo.getString("teacherid") == null) {
                    query = "UPDATE promos SET teacherid = " + teacherId + " WHERE id = " + promoId + ";";
                    Objects.requireNonNull(ConnectionDB.getConnection()).executeUpdate(query);
                    System.out.println("you assign a teacher to promo successfully");
                } else {
                    System.out.println("you selected a promo that all ready assigned.");
                }
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
