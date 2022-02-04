import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class INSERT_traning {
    public static void main(String[] args) {
        final String url = "jdbc:postgresql://localhost:5432/librarydb";
        final String user = "admin";
        final String pass = "0721";
        final String DEL = "insert into items(name,price,weight) values (?,?,?);";
        try (Connection con = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = con.prepareStatement(DEL)) {
            con.setAutoCommit(false);
            ps.setString(1, "どくけしそう");
            ps.setInt(2, 7);
            ps.setInt(3, 2);
            int r = ps.executeUpdate();
            con.commit();
            System.out.println(r + "件のモンスターを追加しました。");
        } catch (SQLException s) {
            System.out.println("おろろ？");
        }
    }
}
