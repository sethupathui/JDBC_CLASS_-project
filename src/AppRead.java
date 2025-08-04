import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class AppRead {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/sample"; 
        String user = "root"; 
        String password = "root";
        String selectSql = "SELECT id, name, mobile_number FROM student";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSql)) {
            System.out.println("ID\tName\tMobile_number");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String mobile_number = rs.getString("mobile_number");
                System.out.println(id + "\t" + name + "\t" + mobile_number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}