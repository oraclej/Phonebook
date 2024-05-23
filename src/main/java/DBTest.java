import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTest {
    private static int n = 2;
    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/contacts";
        String username = "arash";
        String password = "1234";
        Connection connection  = DriverManager.getConnection(jdbcURL, username, password);
        PreparedStatement ps = connection.prepareStatement("insert into contact values(?,?,?)");
        ps.setString(1, "09125001400");
        ps.setString(2, "Amir");
        ps.setString(3, "Shalbaf");
        ps.executeUpdate();
    }
}
