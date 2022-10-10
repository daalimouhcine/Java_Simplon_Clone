package config;
import java.sql.Statement;

public class ConnectionDB {
    private static java.sql.Connection connection;
    public static Statement stm = null;

    public static Statement getConnection() {
        if(connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://localhost:5432/java_simplon_clone";
                String user = "postgres";
                String password  = "369852741.dadA";
                connection = java.sql.DriverManager.getConnection(url, user, password);
                stm = connection.createStatement();
            } catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return stm;
    }

}
