package JDBCDAY1;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Scanner;

public class Example {
	
	

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","Sfafa543@"); 
		Statement statment = conn.createStatement();
			ResultSet rs =  statment.executeQuery("Select * from actor");
			while(rs.next()) {
				System.out.println("Actor ID " +rs.getInt(1));
				System.out.println("Actor Name " +rs.getString(2) +" " +rs.getString(3) );
				System.out.println("------------");
			}
			System.out.println("Driver loaded");

			
			/*PreparedStatement st = conn.prepareStatement("insert into userdetails values(?,?,?)");
			Scanner scanner = new Scanner(System.in);
			int id=0,age=0;
			String name = null;*/
			
			
			
		}	
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			conn.close();
		}
	}

}