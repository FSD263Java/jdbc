package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertData {

	public static void main(String[] args) {
		try {
			//1.Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.Create Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			//3.Create Statement
			 PreparedStatement stmt = con.prepareStatement("insert into empploy values(6,'Demo1',4545.45,1)");
			 //4. Execute statement
			 int count = stmt.executeUpdate();
			 //5.close connection
			 stmt.close();
			 con.close();
			 System.out.println("Total Rows Affetced: " + count);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
