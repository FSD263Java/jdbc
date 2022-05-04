package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RegLoginUser {

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			int i = 1;
			switch(i=1)
			{
			case 1:
			System.out.println("Enter the employee empid :");
			int empid = scan.nextInt();
			
			System.out.println("Enter the employee Name :");
			String name  = scan.next();
			
			System.out.println("Enter the employee email :");
			String email = scan.next();
			
			System.out.println("Enter the employee password :");
			String password = scan.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			PreparedStatement stmt = con.prepareStatement("insert into employeee values(?,?,?,?)");
			stmt.setInt(1, empid);
			stmt.setString(2, name);
			stmt.setString(3, email);
			stmt.setString(4, password);
			
			int count= stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("User Registration Successfully.....");
			
			break;
			
			case 2:
				
				PreparedStatement st = con.prepareStatement("Select * from employeee where email = 'akyaho.com'and password='123456'");
				ResultSet rs = st.executeQuery();
				if(rs.next())
				{
					System.out.print(rs.getString("email") + "\t");
					System.out.print(rs.getString("password") + "\t");
					System.out.println("Login Succsess.......");
					
				}
				else {
					System.err.println("Invalid User");
				}
			
				break;
			}
		
		
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
