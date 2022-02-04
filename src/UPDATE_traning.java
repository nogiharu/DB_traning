import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class UPDATE_traning {
    public static void main(String[] args) {
        final String url = "jdbc:postgresql://localhost:5432/librarydb";
        final String user = "admin";
        final String password = "0721";
        final String sql = "update monsters set days=? where days=?";
        try (Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.valueOf("2000-08-02 18:30:15"));
            ps.setTimestamp(2, Timestamp.valueOf("2020-02-01 18:30:00"));
            int up = ps.executeUpdate();
            System.out.println(up+"件の修正をしました。");
        } catch (Exception e) {
            
        }
    }
}
