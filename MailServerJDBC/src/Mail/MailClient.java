package Mail;

import java.util.LinkedList;
import java.util.ListIterator;

public class MailClient {

	private String address1;
	private String textFromScan;
	private boolean isSender;
	
	private MailServer ms=new MailServer();
	public MailClient() {
		
		
	}

	public String getAddressOfClient() {
		
		return null;
	}

	public void set_address(String address1) {
		this.address1 = address1;
		
		
	}

	public void setText(String text) {
		textFromScan=text;
		
		
	}
    public  void printAllMessageForReceivder(String key){
		
		
		LinkedList<String> list = ms.selectAllMessagesForReceivder(key);
		System.out.println("There is " + list.size() +
	            " messages for this address."+key);
		ListIterator<String> itr = list.listIterator();
		while (itr.hasNext()){
		    System.out.println(itr.next());}
		
		}
	public void set_isSender(boolean isSender) {
		this.isSender = isSender;
		
		
	}

	public void sendToServer() {
		ms.putMessage(MailClient.this);
		
	}
	public void receivedFromServer(String addr) {
		printAllMessageForReceivder(addr);
		
	}
	public String getAddress() {
		
		return address1;
	}

	public String getText() {
		
		return textFromScan;
	}



}
