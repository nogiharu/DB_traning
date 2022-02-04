import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UPDATE_traning_Exception {
    public static void main(String[] args) {
        final String url = "jdbc:postgresql://localhost:5432/librarydb";
        final String user = "admin";
        final String password = "0721";
        final String sql = "update monsters set days=? where name=?";
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("DB接続成功！");
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                con.setAutoCommit(false);
                ps.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
                ps.setString(2, "サムライ");
                int eu = ps.executeUpdate();
                con.commit();
                System.out.println(eu+"件コミットしました！");
            } catch (Exception e) {
               con.rollback();
               System.out.println("更新失敗！更新前に戻しました！");
            }
        } catch (SQLException s) {
            System.out.println("DB接続失敗！");
        }
    }
}
