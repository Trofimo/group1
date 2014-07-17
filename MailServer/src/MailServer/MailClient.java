package MailServer;

import java.util.LinkedList;

public class MailClient {

	private String address1;
	private String textFromScan;
	private boolean isSender;
	private String name;
	private MailServer ms=new MailServer();
	public MailClient(String name) {
		this.name = name;
		
	}

	public String getAddressOfClient() {
		// TODO Auto-generated method stub
		return null;
	}

	public void set_address(String address1) {
		this.address1 = address1;
		
		
	}

	public void setText(String text) {
		textFromScan=text;
		
		
	}

	public void set_isSender(boolean isSender) {
		this.isSender = isSender;
		
		
	}

	public void sendToServer() {
		ms.putMessage(MailClient.this);
		
	}
	public void receivedFromServer(String addr) {
		ms.selectAllMessagesForReceivder(addr);
		
	}
	public String getAddress() {
		
		return address1;
	}

	public String getText() {
		
		return textFromScan;
	}

}
