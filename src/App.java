import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
public class App{
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3686/sample";
        String user = "root";
        String password "root";
        String sql "CREAT TABLE IF NOT EXISTS data ("+"id INT AUTO_INCREATE PRIMARY KEY,"+"name VARCHAR(100} NOT NULL,"+")";
        try(Connection conn = DriverManager.getConnection(url,user,password);
            Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(sql);
                System.out.println("")
            }

        
    }
}