import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DEL_traning_Exception {
    public static void main(String[] args) {
        final String url = "jdbc:postgresql://localhost:5432/librarydb";
        final String user = "admin";
        final String password = "0721";
        final String DEL = "delete from monsters where hp =? or name =?;";
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("接続成功！");
            try (PreparedStatement ps = con.prepareStatement(DEL)) {
                ps.setInt(1, 200);
                ps.setString(2, "勇者");
                int r = ps.executeUpdate();
                if (r != 0) {
                    System.out.println(r + "件のモンスターを削除しました。");
                } else {
                    System.out.println("該当なし！");
                }
            } catch (SQLException e) {
                System.out.println("");
            }
        } catch (SQLException s) {
            System.out.println("接続失敗！");
        }
    }
}
