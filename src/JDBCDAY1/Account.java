package JDBCDAY1;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
class Accounter{
private String	Account_number,name;
float balance;
public String getAccount_number() {
	return Account_number;
}
public void setAccount_number(String account_number) {
	Account_number = account_number;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getBalance() {
	return balance;
}
public void setBalance(float balance) {
	this.balance = balance;
}


}
public class Account {
ArrayList<Accounter> accounters;
Connection conn=null;
Scanner scanner;

Account() throws ClassNotFoundException, SQLException{
	accounters = new ArrayList<Accounter>();
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
	ResultSet rs = statement.executeQuery("Select * from accounts");
	Accounter accounterss;
	/*while(rs.next()) {
		
		System.out.println(" ID :"+rs.getInt(1));
		 
		System.out.println(" Name :"+rs.getString(2));
		System.out.println(" age :"+rs.getInt(3));
		System.out.println("-------------------------------");*/
		accounterss = new Accounter();
		accounterss.setAccount_number(rs.getString(1));
		accounterss.setName(rs.getString(2));
		accounterss.setBalance(rs.getFloat(3));
		accounters.add(accounterss);
	}



void getUserDetailsFromUser() throws SQLException {
	String Account_number,name;
	float balance;

	System.out.println("Please enter the Accoount balance");
	balance=scanner.nextFloat();
	
	scanner.nextLine();
	System.out.println("Please enter the Account number");
	Account_number=scanner.nextLine();
	System.out.println("Please enter the Name");
	name=scanner.nextLine();
	
	
	Accounter accounterss = new Accounter();
	accounterss.setAccount_number(Account_number);
	accounterss.setName(name);
	accounterss.setBalance(balance);
	insertUserDetailsToDatabase(accounterss);
	
}
void getUserDetailsFromDatabaseview() throws SQLException {
	Statement statement = conn.createStatement();
	ResultSet rs = statement.executeQuery("Select * from accounts");
	Accounter accounterss;
	while(rs.next()) {
		
		System.out.println(" Account_number is :"+rs.getString(1));
		 
		System.out.println(" Name is :"+rs.getString(2));
		System.out.println(" Balance is :"+rs.getFloat(3));
		System.out.println("-------------------------------");
		accounterss = new Accounter();
		accounterss.setAccount_number(rs.getString(1));
		accounterss.setName(rs.getString(2));
		accounterss.setBalance(rs.getFloat(3));
		accounters.add(accounterss);
	}}
void insertUserDetailsToDatabase(Accounter  accounterss) throws SQLException {
	PreparedStatement st  = conn.prepareStatement("insert into accounts values(?,?,?)");
	st.setString(1, accounterss.getAccount_number());
	st.setString(2, accounterss.getName());
	st.setFloat(3, accounterss.getBalance());
	int result = st.executeUpdate();//DML
	System.out.println("Data Inserted");
}
void getUserDetailsFromUserfordelete() throws SQLException {
	String Account_number,name;
	float balance;
		System.out.println("If You Want Delete Record Change Account_number inside Code---");
	//Account_number=scanner.nextLine();

	
	Accounter accounterss = new Accounter();
	//accounterss.setAccount_number(Account_number);
	PreparedStatement st  = conn.prepareStatement("delete from accounts where Account_number='1001'");

	 st.executeUpdate();//DML
		System.out.println("Data deleted");
	//accounterss.setName(name);
	//accounterss.setBalance(balance);
	//DeleteUserDetailsToDatabase(accounterss);
	
}
void getUserDetailsFromUserforupdate() throws SQLException {
	String Account_number,name;
	float balance;
		System.out.println("If You Want Update Record Change data inside Code---");
	//Account_number=scanner.nextLine();

	
	Accounter accounterss = new Accounter();
	//accounterss.setAccount_number(Account_number);
	PreparedStatement st  = conn.prepareStatement("update accounts Set name='DEVA' where Account_number='1003'");

	 st.executeUpdate();//DML
		System.out.println("Data Updated");
	//accounterss.setName(name);
	//accounterss.setBalance(balance);
	//DeleteUserDetailsToDatabase(accounterss);
	
}



void ChooseAction() {
	int userChoice = 0;
	do {
		System.out.println("--------------------");
		System.out.println("1. Insert Data Into the Database");
		System.out.println("2. Print The Data");
		System.out.println("3. Update The Data");
		System.out.println("4. Delete The Data");
		System.out.println("5. exit");
		System.out.println("--------------------");
		userChoice  = scanner.nextInt();
		switch (userChoice ) {
		case 1:
			try {
				getUserDetailsFromUser();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			break;
		case 2:
			try {
				getUserDetailsFromDatabaseview();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
							
			break;
		
		case 3:
			try {
				getUserDetailsFromUserforupdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case 4:
			try {
				getUserDetailsFromUserfordelete();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		case 5:
			System.out.println("exiting.....");
			break;
		default:
			System.out.println("Invalid option.. Try again");
			break;
		}
		
	} while (userChoice!=5);
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Account acc = new Account();
	//acc.getUserDetailsFromUser();
	acc.ChooseAction();
}catch(ClassNotFoundException e){
	e.printStackTrace();
}catch(SQLException e) {
	e.printStackTrace();
}
	}

}
