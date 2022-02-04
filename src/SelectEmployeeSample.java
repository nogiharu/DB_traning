import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectEmployeeSample {

	public static void main(String[] args) {
		//データベースに接続
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "sa", "")) {
			
		//SELECT文の準備
		String sql = "SELECT * FROM EMPLOYEE";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		//SELECT文を実行し結果表を（ResultSet）を取得
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			String ID = rs.getString("ID");
			String NAME = rs.getString("NAME");
			int AGE = rs.getInt("AGE");
			
			System.out.println("ID:" + ID);
			System.out.println("名前:" + NAME);
			System.out.println("年齢:" + AGE + "\n");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
