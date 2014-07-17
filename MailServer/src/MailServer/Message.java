package MailServer;

import java.util.LinkedList;
import java.util.Scanner;


public class Message {
	
	
	static MailClient c1 = new MailClient("You");
	static MailServer sr1=new MailServer();
	static LinkedList<String> lstAddr=new LinkedList<>();
	static class Communicator {
		
		
		

		public static void receivedMessageFromServer() {
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter address");
			String addr="";
			addr=sc.nextLine();
			c1.receivedFromServer(addr);
		}

	    public static void sendMessageToServer() {
	    	  Scanner sc= new Scanner(System.in);
	    	    String addr="";
	    	    String textFromScan="";
	    	    LinkedList<String> tx=new LinkedList<>();
	    	    
	    	    	System.out.println("Enter your address:");
	    	    	
	    	    	addr=sc.nextLine();
	    	    	c1.set_address(addr);
	    	    	
	    	    	System.out.println("Enter any text");
	    	    	
	    	    	textFromScan=sc.nextLine();
	    	    	c1.setText(textFromScan);
			
			        c1.sendToServer();
		}
		
		public void go() {
			Scanner sc= new Scanner(System.in);
			int flag=0;
			
			while (true) {
				
//				System.out.println("Press 1 for send or 2 for received:");
//				flag = sc.nextInt();
//				if (flag == 1) {
					
					sendMessageToServer();
//				} else if (flag == 2) {
//					
//					receivedMessageFromServer();
//				}
			}
			
			
		}
		
	}
		
		
	
	
	public static void main(String[] args) {
		
        Communicator cm=new Communicator();
		cm.go();
		
	}	
	
}
