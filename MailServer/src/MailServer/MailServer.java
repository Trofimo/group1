package MailServer;




import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;






public class MailServer {
	
	
	
	Map<String, LinkedList<String>> outboxMessage=new LinkedHashMap<String, LinkedList<String>>();
	
	
	
	
	
	public LinkedList<String> selectAllMessagesForReceivder(String key){
		LinkedList<String> tx = new LinkedList<>();
		tx=outboxMessage.get(key);

        return tx;
				
	}
	
	public void putMessage(MailClient client){
		LinkedList<String> tx = new LinkedList<>();
        tx=outboxMessage.get(client.getAddress());
    	
    	if(tx==null){
    		tx=new LinkedList<String>();
    		outboxMessage.put(client.getAddress(), tx);
    		
    		
    	}
    	tx.add(client.getText());
		
		
		
			
	}
	
	

}
