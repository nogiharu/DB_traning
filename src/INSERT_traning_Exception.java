import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class INSERT_traning_Exception {
    public static void main(String[] args) {
        final String url = "jdbc:postgresql://localhost:5432/librarydb";
        final String user = "admin";
        final String pass = "0721";
        final String INS = "insert into monsters(hp,name,days,money) values (?,?,?,?);";
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            System.out.println("接続成功！");
            try (PreparedStatement ps = con.prepareStatement(INS)) {
                ps.setInt(1, 200);
                ps.setString(2, "勇者");
                ps.setTimestamp(3, Timestamp.valueOf("2020-02-01 18:30:00"));
                ps.setInt(4, 20000);
                int r = ps.executeUpdate();
                System.out.println(r + "件のモンスターを追加しました。");
            } catch (SQLException s) {
                System.out.println("更新失敗！");
            }
        } catch (SQLException s) {
            System.out.println("接続失敗！");
        }
    }
}
