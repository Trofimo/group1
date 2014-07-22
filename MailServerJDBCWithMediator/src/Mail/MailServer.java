package Mail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;









public class MailServer {
	private static MailServer self=new MailServer();
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
	
	
	
	
	
	public LinkedList<String> selectAllMessagesForReceivder(String key) {
		LinkedList<String> tx = new LinkedList<>();
		StringBuilder sb=new StringBuilder();
		sb.append("select text from Inbox where address ").append("= '").append(key).append("'");
			
		
		String selectSQL = sb.toString();
		
		try {
			PreparedStatement preparedStatement = MailServer.connection().prepareStatement(selectSQL);
			
			
			
			ResultSet rs = preparedStatement.executeQuery(selectSQL);
			while (rs.next()) {
				tx.add(rs.getString("text"));
				
			}
			rs.close();
			
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		}
		
		
		return tx;
	}
	
	
	
	
	public void putMessage(MailClient mailClient) {
		PreparedStatement prepareStatement;
		
		String addr=mailClient.getAddress();
		String value=mailClient.getText();
		try {
			prepareStatement = MailServer.connection().prepareStatement("insert into Inbox (address,text) values(?,?)");
            prepareStatement.setString(1, addr);
            prepareStatement.setString(2, value);
			prepareStatement.execute();
			
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
        
		
	}
}
