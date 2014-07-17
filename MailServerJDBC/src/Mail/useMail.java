package Mail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class useMail {
	private static useMail self=new useMail();
	public static Connection connection(){
		return self.conn;
	};
	private Connection conn;
	{
		try {
			conn = 
					DriverManager.getConnection("jdbc:mysql://localhost/Trofimova?user=root");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println("Start");
		try {
			
			Statement st = useMail.connection().createStatement();
			

			
			PreparedStatement prepareStatement = 
					useMail.connection().prepareStatement("insert into Text (text) values (?);");
			addRowToTableText(prepareStatement, "Pete");
			
			ResultSet resultSet = st.executeQuery("Select * from Text");
			while(resultSet.next()){
				System.out.print(resultSet.getString("id")+" ");
				System.out.println(resultSet.getString("text"));
				
			}
			resultSet.close();
			st.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
	
	public static void addRowToTableText(PreparedStatement prepareStatement,String name){
		try {
			
			prepareStatement.setString(1, name);
			
			prepareStatement.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
