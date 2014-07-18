package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	private static DBManager self=new DBManager();
	public static Connection connection(){
		return self.conn;
	};
	private Connection conn;
	{
		try {
			conn = 
					DriverManager.getConnection("jdbc:mysql://localhost/jdbctest?user=root");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	private DBManager(){
		
	}
	public static void main(String[] args) {
		System.out.println("Start");
		try {
			
			Statement st = DBManager.connection().createStatement();
			
			ResultSet resultSet = st.executeQuery("select now()");
			System.out.println(resultSet.isBeforeFirst());
			resultSet.next();
			System.out.println(resultSet.getString(1));
			resultSet.close();
			
			resultSet = st.executeQuery("Select * from User");
			while(resultSet.next()){
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("password"));
				System.out.println(resultSet.getString("email"));
			}
			resultSet.close();
			st.close();

			
			
			PreparedStatement prepareStatement = 
					DBManager.connection().prepareStatement("insert into User values(?,?,?)");
			addUser(prepareStatement, "Pete", "54321", "s@hjkhk");
			addUser(prepareStatement, "Pete", "54321", "s@hjkhk");
			addUser(prepareStatement, "Pete", "54321", "s@hjkhk");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
	public static void addUser(PreparedStatement prepareStatement,String name,String password,String email){
		try {
			
			prepareStatement.setString(1, name);
			prepareStatement.setString(2, password);
			prepareStatement.setString(3, email);
			prepareStatement.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

}
