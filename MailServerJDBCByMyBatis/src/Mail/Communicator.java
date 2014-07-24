package Mail;

import java.util.LinkedList;
import java.util.Scanner;

class Communicator {
	
	static MailClient c1 = new MailClient();
	static MailServer ms = new MailServer();

	

    static void sendMessageToServer() {
    	  Scanner sc= new Scanner(System.in);
    	    String addr="";
    	    String textFromScan="";
    	   
    	    
    	    	System.out.println("Enter your address:");
    	    	
    	    	addr=sc.nextLine();
    	    	c1.set_address(addr);
    	    	
    	    	System.out.println("Enter any text");
    	    	
    	    	textFromScan=sc.nextLine();
    	    	c1.setText(textFromScan);
    	    	ms.putMessage(c1);
		        
	}
    static void receiveMessage() {
		Scanner sc= new Scanner(System.in);
	    String addr="";
	    System.out.println("Enter your address:");
	    addr=sc.nextLine();
	    
	    LinkedList<String> list = ms.selectAllMessagesForReceivder(addr);
		c1.printAllMessageForReceivder(list);
	}	
	public void go() {
		Scanner sc= new Scanner(System.in);
		int f=0;
		while (true) {
		System.out.println("Press 1 for sending or 2 for receive:");
		
		f=sc.nextInt();
		if(f==1){
         sendMessageToServer();
         }
		else{receiveMessage();
		}

		}
		
		
	}

	
	
	
	
	
	
	
}