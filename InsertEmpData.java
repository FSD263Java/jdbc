package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertEmpData {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 try {
			
				System.out.println("Enter Employee Id :");
				int id = scan.nextInt();
				
				System.out.println("Enter Employee Name :");
				String name = scan.next();
				
				System.out.println("Enter Employee salary :");
				double salary = scan.nextDouble();
				
				scan.close();
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
				PreparedStatement stmt = con.prepareStatement("insert into empploy values(?,?,?,1)");
				stmt.setInt(1, id);
				stmt.setString(2, name);
				stmt.setDouble(3, salary);
				
				int count = stmt.executeUpdate();
				stmt.close();
				con.close();
				
				System.out.println(count + " : row inserted....");
				
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}


	}

}
