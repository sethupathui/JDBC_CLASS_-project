import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class AppUpdate {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "root"; 
        String password = "root";
        String updateSql = "UPDATE student SET name = ?, value = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in);
             PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
            System.out.print("Enter ID to update: 23CS514 ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new name: sethu ");
            String name = scanner.nextLine();
            System.out.print("Enter new mobile_number: 7788999900");
            String mobile_number = scanner.nextLine();
            pstmt.setString(1, name);
            pstmt.setString(2, mobile_number);
            pstmt.setInt(3, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Row updated successfully.");
            } else {
                System.out.println("No row found with the given ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}