package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckEmailPwd {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			
			PreparedStatement stmt = con.prepareStatement("Select * from employeee where email = 'akyaho.com'and password='123456'");
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				System.out.print(rs.getString("email") + "\t");
				System.out.print(rs.getString("password") + "\t");
				System.out.println("Login Succsess.......");
				
			}
			else {
				System.err.println("Invalid User");
			}
			
			rs.close();
			stmt.close();
			con.close();
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}

}
