import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DataBaseConnect {

	@Test
	public void testDB() throws ClassNotFoundException, SQLException {
		
		//Load mysql jdbc driver	
		Class.forName("com.mysql.cj.jdbc.Driver");		
		System.out.println("Driver loaded");
		
		//Create Connection to DB	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","Lamine225");
		System.out.println("Connected to MySQL DB");
		
		//Create Statement Object	
		Statement smt = con.createStatement();
		
		// Execute the SQL Query. Store results in ResultSet	
		ResultSet rs = smt.executeQuery("select * from studentinfo");
		
		while (rs.next()) {
			int id = rs.getInt("id");					
			String name = rs.getString("name");		
			String grade = rs.getString("grade");			
			System.out.println( id+" "+name+" "+grade);
			
/*			
			System.out.println(" DataBase record id : "+grade);
			System.out.println("DataBase record id : "+id);
			System.out.println(" DataBase record id : "+name);
*/			
		}
	}
}
