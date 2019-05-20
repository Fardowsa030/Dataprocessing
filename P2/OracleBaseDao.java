package P2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao  {
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String DB_USER = "Fardowsa";
	private static final String DB_PASS = "Twilight";
	public static Connection conn;
	

    // De methode die met JDBC aan de slag gaat moet een SQLException opvangen of gooien
	public Connection getConnection(){
	//Besluit welke driver je gaat gebruiken voor je verbinding		
		try {
			Class.forName(DB_DRIV).newInstance();
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
				e1.printStackTrace();
		}
			
		// Leg de connectie met de database
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connection made");			
		return conn;
		
		

}
}
