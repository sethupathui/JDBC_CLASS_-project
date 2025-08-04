import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class AppDelete {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/sample"; 
        String user = "root";
        String password = "root";
        String deleteSql = "DELETE FROM data WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in);
             PreparedStatement pstmt = conn.prepareStatement(deleteSql)) {
            System.out.print("Enter ID to delete: ");
            var id = Integer.parseInt(scanner.nextLine());
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Row deleted successfully.");
            } else {
                System.out.println("No row found with the given ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}