package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class UpdateUserData {

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter Id: ");
			int empId = scan.nextInt();
			
			System.out.println("Enter Employee Status : ");
			int status = scan.nextInt();
			
			scan.close();
			
			//1.Register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			//Prepared Statement
			PreparedStatement stmt = con.prepareStatement("update empploy set active_flag=? where id=?");
			stmt.setInt(1, status);
			stmt.setInt(2, empId);
			//execute statement
			int count = stmt.executeUpdate();
			//5.close connection
			stmt.close();
			con.close();
			 System.out.println("Record Updated Successfully......");
		}catch(Exception e) {
	      e.printStackTrace();
		}
		

	}

}
