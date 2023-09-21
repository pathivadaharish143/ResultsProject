package resultsbackend;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public class DBconfiguration {
	Connection con;
	public Connection getDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver class Found");
			String username="c##harish123";
			String password = "Harish123";
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Connected successfylly");
		} catch (ClassNotFoundException e) {
			
			System.out.println("Unable to find the Driver class");
		} catch(SQLException e){
			System.out.println("Unable to connect");
		}
		return con;
	}
	
}
