import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class App {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/sample"; 
        String user = "root"; 
        String password = "root";
        String sql = "CREATE TABLE IF NOT EXISTS data (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY," +
                     "name VARCHAR(100) NOT NULL," +
                     "value VARCHAR(100)" +
                     ")";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'data' created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}