import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SELECT_traning {
    public static void main(String[] args) throws Exception {
      final String url = "jdbc:postgresql://localhost:5432/librarydb";
      final String user = "admin";
      final String pass = "0721";
      final String select = "select * from 蔵書テーブル;";
       try (Connection con = DriverManager.getConnection(url, user, pass);
       PreparedStatement ps = con.prepareStatement(select);
       ResultSet rs = ps.executeQuery()){
               while(rs.next()){
                   System.out.println(rs.getString("蔵書id") + rs.getString("タイトル") + rs.getString("発行年月日") + rs.getString("著者"));
               }
       } catch (Exception e) {
          System.out.println("んん？");
       }
    }
}
