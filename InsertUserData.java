package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class InsertUserData {

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter Employeee Id :");
			int empid = scan.nextInt();
			
			System.out.println("Enter Employeee Name :");
			String name = scan.next();
			
			System.out.println("Enter Employeee Email :");
			String email = scan.next();
			
			System.out.println("Enter Employeee Password :");
			String password = scan.next();
			
				
			scan.close();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			PreparedStatement stmt = con.prepareStatement("insert into employeee values(?,?,?,?)");
			stmt.setInt(1, empid);
			stmt.setString(2, name);
			stmt.setString(3, email );
			stmt.setString(4, password);
			
			int count = stmt.executeUpdate();
			stmt.close();
			con.close();
			
			System.out.println(count + " : row inserted....");
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
