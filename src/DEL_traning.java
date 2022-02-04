import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DEL_traning {
    public static void main(String[] args) {
        final String url = "jdbc:postgresql://localhost:5432/librarydb";
        final String user = "admin";
        final String pass = "0721";
        final String DEL = "delete from monsters where hp =? or name =?;";
      try (Connection con = DriverManager.getConnection(url, user, pass);
      PreparedStatement ps = con.prepareStatement(DEL)) {
          ps.setInt(1, 200);
          ps.setString(2, "勇者");
          int r = ps.executeUpdate();
          if(r != 0){
              System.out.println(r + "件のモンスターを削除しました。");
          }else{
              System.out.println("該当なし");
          }
      } catch (Exception e) {
        System.out.println("おろろ？");
      }  
    }
}
