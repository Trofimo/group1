package Mail;

import java.util.LinkedList;
import java.util.ListIterator;

public class MailClient {

	private String address1;
	private String textFromScan;
	private boolean isSender;
	
	private Communicator com=new Communicator();
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
    public  void printAllMessageForReceivder(LinkedList<String> list2){
		
		
		LinkedList<String> list = new LinkedList<>();
		list.addAll(list2);
		System.out.println("There is " + list.size() +
	            " messages for this address."+list2);
		ListIterator<String> itr = list.listIterator();
		while (itr.hasNext()){
		    System.out.println(itr.next());}
		
		}
	public void set_isSender(boolean isSender) {
		this.isSender = isSender;
		
		
	}

	
	
	public String getAddress() {
		
		return address1;
	}

	public String getText() {
		
		return textFromScan;
	}



}
