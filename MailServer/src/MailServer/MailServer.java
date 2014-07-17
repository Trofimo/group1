package MailServer;



import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;






public class MailServer {
	
	
	Map<String, LinkedList<String>> inboxMessage=new LinkedHashMap<String, LinkedList<String>>();
	Map<String, LinkedList<String>> outboxMessage=new LinkedHashMap<String, LinkedList<String>>();
	Map<String, LinkedList<String>> allMessages=new LinkedHashMap<String, LinkedList<String>>();
	BlockingQueue<Runnable>	actions = new LinkedBlockingQueue<>();
	LinkedList<String> tx = new LinkedList<>();
	ExecutorService sender = Executors.newCachedThreadPool();
	
	
	
	
	public void selectAllMessagesForReceivder(String key){
		
		System.out.println("There is in box" + outboxMessage.size() +
                " messages.");


		Set<?> entries = outboxMessage.entrySet();
		Iterator<?> i = entries.iterator();
		while (i.hasNext()) {
		Map.Entry entry = (Map.Entry)i.next();
		System.out.println(entry.getKey() + " : "
		+ entry.getValue());
		}
		System.out.println();
		
				
	}

	public void putMessage(MailClient client){
		
        tx=outboxMessage.get(client.getAddress());
    	
    	if(tx==null){
    		tx=new LinkedList<String>();
    		outboxMessage.put(client.getAddress(), tx);
    		
    		
    	}
    	tx.add(client.getText());
		
		selectAllMessagesForReceivder(client.getAddress());

			
	}
	
	

}
