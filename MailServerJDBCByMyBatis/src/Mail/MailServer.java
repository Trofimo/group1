package Mail;


import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MailServer {
	
	
	public LinkedList<String> selectAllMessagesForReceivder(String key) {
		LinkedList<String> tx = new LinkedList<>();
		try {
			InputStream resourceAsStream = Resources.getResourceAsStream("Config.xml");
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(resourceAsStream);
			factory.getConfiguration().addMapper(InboxMapper.class);
			
			SqlSession session=factory.openSession();
			try{
			InboxMapper mapper=session.getMapper(InboxMapper.class);
			List<Inbox> userList=mapper.selectByAddress(key);
			for (Inbox user : userList) {
				
				tx.add(user.toString());
				
				
			}
		
			
			
			}finally{
				session.close();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return tx;
	}
	
	
	
	
	public void putMessage(MailClient mailClient) {
		
		try {
			InputStream resourceAsStream = Resources.getResourceAsStream("Config.xml");
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(resourceAsStream);
			factory.getConfiguration().addMapper(InboxMapper.class);
			
			SqlSession session=factory.openSession();
			try{
			InboxMapper mapper=session.getMapper(InboxMapper.class);
			
			mapper.insertAddrAndText(mailClient.getAddress(), mailClient.getText());
			session.commit();
			}finally{
				session.close();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        
		
	}
}
