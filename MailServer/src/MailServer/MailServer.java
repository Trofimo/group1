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
	Map<String, LinkedList<String>> allMessages=new LinkedHashMap<String, LinkedList<String>>();
	BlockingQueue<Runnable>	actions = new LinkedBlockingQueue<>();
	LinkedList<String> tx = new LinkedList<>();
	ExecutorService sender = Executors.newCachedThreadPool();
	
	
	
	
	public LinkedList<String> selectAllMessagesForReceivder(String key){
		tx=outboxMessage.get(key);

        return tx;
				
	}
	public void printAllMessageForReceivder(String key){
		System.out.println("There is " + tx.size() +
	            " messages for this address."+key);
		LinkedList<String> list = selectAllMessagesForReceivder(key);
		ListIterator<String> itr = list.listIterator();
		while (itr.hasNext()){
		    System.out.println(itr.next());}
		
		}
	public void putMessage(MailClient client){
		
        tx=outboxMessage.get(client.getAddress());
    	
    	if(tx==null){
    		tx=new LinkedList<String>();
    		outboxMessage.put(client.getAddress(), tx);
    		
    		
    	}
    	tx.add(client.getText());
		
		
		printAllMessageForReceivder(client.getAddress());
			
	}
	
	

}
