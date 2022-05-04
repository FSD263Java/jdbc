package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectUserData {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			PreparedStatement stmt = con.prepareStatement("select * from empploy");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				System.out.println(rs.getInt("id") + "\t");
				System.out.println(rs.getString("name") + "\t");
				System.out.println(rs.getDouble("salary") + "\t");
				System.out.println(rs.getInt("active_flag") + "\n");
			}
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
