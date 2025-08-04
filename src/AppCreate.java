import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
public class AppCreate {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "root"; 
        String password = "root";
        String sql = "CREATE TABLE IF NOT EXISTS student (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY," +
                     "name VARCHAR(100) NOT NULL," +
                     "mobile_number INT NOT NULL" +
                     ")";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             Scanner scanner = new Scanner(System.in)) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'student' created successfully.");
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter mobile_number: ");
            String mobile_number = scanner.nextLine();
            String insertSql = "INSERT INTO student (name, mobile_number) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, mobile_number);
                pstmt.executeUpdate();
                System.out.println("Inserted a row into 'student' table.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}