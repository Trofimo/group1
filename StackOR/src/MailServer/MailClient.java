package MailServer;

import java.util.LinkedList;

public class MailClient {

	private String _name;
	
	private String _address;
	private LinkedList<String> _text=new LinkedList<>();
	
	private String _addressofClient;
	private boolean _isSender=false;
	private MailServer ms=new MailServer();
	

	public MailClient(String name) {
		_name = name;
		
	}


	public String getName() {
		return _name;
	}
	
	


	

	public String getAddress() {
		
		return get_address();
	}

	public LinkedList<String> getText() {
		
		return _text;
	}
    public void setText(String text) {
		if(_text.isEmpty()){
    	_text.addFirst(text);} else{
    		_text.add(text);
    	}
		
	}
	public String getAddressOfClient() {
		
		return _addressofClient;
	}

	public boolean statusOfMessage() {
		
		return false;
	}


	

	public boolean get_isSender() {
		return _isSender;
	}


	public void set_isSender(boolean _isSender) {
		this._isSender = _isSender;
	}


	public String get_address() {
		return _address;
	}


	public void set_address(String _address) {
		this._address = _address;
	}


	


	public void sendToServer() {
		ms.sortingtoFolder(MailClient.this);
		
	}

}
