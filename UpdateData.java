package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class UpdateData {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			PreparedStatement stmt = con.prepareStatement("Update empploy set salary=44444.44 where id=3");
			int count = stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Total Row Update : "+ count);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
