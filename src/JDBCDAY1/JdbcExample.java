package JDBCDAY1;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Getting the Connector Jar
 * Loading the Driver-Register the driver
 * Getting the connection
 * Creating a statement
 * Executing Query
 * Closing the connection*/

class User{
	private int id,age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
}

public class JdbcExample {

	ArrayList<User> users ;
	Connection conn=null;
	Scanner scanner;
	
	
	JdbcExample() throws ClassNotFoundException, SQLException{
		users = new ArrayList<User>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","Sfafa543@");
		scanner = new Scanner(System.in);
	}
	
	@Override
	protected void finalize() throws Throwable {
		conn.close();
	}
	
	
	
	void getUserDetailsFromDatabase() throws SQLException {
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("Select * from userdetails");
		User user;
		while(rs.next()) {
			
			System.out.println(" ID :"+rs.getInt(1));
			 
			System.out.println(" Name :"+rs.getString(2));
			System.out.println(" age :"+rs.getInt(3));
			System.out.println("-------------------------------");
			user = new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setAge(rs.getInt(3));
			users.add(user);
		}
	}
	
	void printAllUser() {
		for (User user : users) {
			System.out.println(user);
			
		}
	}
	

	
	void getUserDetailsFromUser() throws SQLException {
		int id=0,age=0;
		String name = null;
		System.out.println("Please enter the USer id");
		id=scanner.nextInt();
		System.out.println("Please enter the USer age");
		age=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Please enter the USer name");
		name=scanner.nextLine();
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		insertUserDetailsToDatabase(user);
		
	}
	
	void insertUserDetailsToDatabase(User user) throws SQLException {
		PreparedStatement st  = conn.prepareStatement("insert into userdetails values(?,?,?)");
		st.setInt(1, user.getId());
		st.setString(2, user.getName());
		st.setInt(3, user.getAge());
		int result = st.executeUpdate();//DML
		System.out.println("Data Inserted");
	}
/*	void getUserDetailsFromUserForUpdate() throws SQLException {
		int id=0,age=0;
		String name = null;
		
		System.out.println("Please enter the USer name for update");
		name=scanner.nextLine();
		System.out.println("Please enter the USer id for update");
		id=scanner.nextInt();
		User user = new User();
		
		user.setName(name);
		user.setId(id);
	//	user.setAge(age);
		updateUserDetailsToDatabase(user);
	}*/

	void updateUserDetailsToDatabase(User user) throws SQLException{
		PreparedStatement st  = conn.prepareStatement("UPDATE userdetails "
                + "SET name = ? "
                + "WHERE id = ?");
		st.setInt(1, user.getId());
		st.setString(2, user.getName());
//	st.setInt(3, user.getAge());
		int result = st.executeUpdate();//DML
		System.out.println("Data updated");
	}

	public static void main(String[] args)  {
		try {
			JdbcExample example = new JdbcExample();
			//example.getUserDetailsFromUser();
			//example.getUserDetailsFromDatabase();
		//	example.getUserDetailsFromUserForUpdate();
			
			//example.printAllUser();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
