package MailServer;

import java.util.Scanner;


public class Message {
	
	
	static MailClient c1 = new MailClient("You");
	static MailServer sr1=new MailServer();
	static class Communicator {
		
		
		public static void receivedMessageFromServer() {
			sr1.selectAllMessagesForReceivder();
		}

	    public static void sendMessageToServer() {
	    	System.out.println("Enter your address:");
			String address1="";
			Scanner sc= new Scanner(System.in);
			address1=sc.nextLine();
			c1.set_address(address1);
//			System.out.println("Enter address2: ");
//			String address2="";
//			address2=sc.nextLine();
//			c1.set_address(address2);
			System.out.println("Enter any text");
			String textFromScan="";
			textFromScan=sc.nextLine();
			System.out.println("your address is: "+address1+" text is "+textFromScan);
			c1.setText(textFromScan);
			c1.set_isSender(true);
			c1.sendToServer();
		}
		
		public void go() {
			while(true){
				sendMessageToServer();
				receivedMessageFromServer();
			}
			
		}
		
	}
		
		
	
	
	public static void main(String[] args) {
		
        Communicator cm=new Communicator();
		cm.go();
		
	}	
	
}
