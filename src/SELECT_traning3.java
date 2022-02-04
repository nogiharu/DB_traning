import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SELECT_traning3 {
    public static void main(String[] args) throws Exception {
        final String url = "jdbc:postgresql://localhost:5432/docotsubu";
        final String user = "sa";
        final String password = "";
        final String select = "select * from mutter";
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("接続成功！");
            try (PreparedStatement ps = con.prepareStatement(select)) {
                
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        System.out.println(rs.getString("name") + "：" + rs.getString("text"));
                    }
                } catch (Exception e) {

                }
            } catch (Exception e) {
                System.out.println("セット失敗！");
            }
        } catch (Exception e) {
            System.out.println("接続失敗！");
        }
    }
}
