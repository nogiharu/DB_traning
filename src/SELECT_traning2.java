import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SELECT_traning2 {
    public static void main(String[] args) throws Exception {
        final String url = "jdbc:postgresql://localhost:5432/librarydb";
        final String user = "admin";
        final String password = "0721";
        final String select = "select * from 蔵書テーブル where 著者=? and ページ数=? and 蔵書id=? and 発行年月日=?";
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("接続成功！");
            try (PreparedStatement ps = con.prepareStatement(select)) {
                ps.setString(1, "目黒聖");
                ps.setInt(2, 500);
                ps.setString(3, "Z0003");
                ps.setDate(4, Date.valueOf("2010-08-01"));
                System.out.println("セット成功！");
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        System.out.println("タイトル：" + rs.getString("タイトル"));
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
