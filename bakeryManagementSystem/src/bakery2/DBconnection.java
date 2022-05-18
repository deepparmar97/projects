package bakery2;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;



public class DBconnection 
{
	static String url="jdbc:mysql://localhost:3306/study";
	static String username="root";
	static String password="root";
	static Connection con;
	public static Connection getConnection() 
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception o)
		{
			JOptionPane.showMessageDialog(null, "Error in connection");
		}
		return con;
		
	}

}
