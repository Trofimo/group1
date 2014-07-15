package MailServer;



import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;






public class MailServer {
	
	
	Map<String, LinkedList<String>> inboxMessage=new LinkedHashMap<String, LinkedList<String>>();
	Map<String, LinkedList<String>> outboxMessage=new LinkedHashMap<String, LinkedList<String>>();
	Map<String, LinkedList<String>> allMessages=new LinkedHashMap<String, LinkedList<String>>();
	BlockingQueue<Runnable>	actions = new LinkedBlockingQueue<>();
	List<MailClient> clients = new LinkedList<>();
	ExecutorService sender = Executors.newCachedThreadPool();
	
	
	
	
	public Map<String, LinkedList<String>> selectAllMessagesForReceivder(){
		
		//iterating over keys only
		for (String key : inboxMessage.keySet()) {
			if (inboxMessage.containsKey(key)){
				allMessages.put(key, inboxMessage.get(key));
				System.out.println(allMessages.get(key));	
			}
		}
		//iterating over keys only
		for (String key1 : outboxMessage.keySet()) {
			if (outboxMessage.containsKey(key1)){
				allMessages.put(key1, outboxMessage.get(key1));
			System.out.println(allMessages.get(key1));		
			}
				}
		
		return allMessages;
	}
	
	public void sortingtoFolder(MailClient client){
		if (client.getAddress()==client.getAddressOfClient()){
			inboxMessage.put(client.getAddress(), client.getText());
		
		}else if (client.getAddress()!=client.getAddressOfClient()){
			outboxMessage.put(client.getAddress(), client.getText());
		}
		selectAllMessagesForReceivder();

			
	}
	
	

}
