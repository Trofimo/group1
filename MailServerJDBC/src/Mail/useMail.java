package Mail;

import java.util.LinkedList;
import java.util.Scanner;


public class useMail {
	
	
	static MailClient c1 = new MailClient();
	
	
	static class Communicator {
		
		
		

		

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
			int f=0;
			while (true) {
			System.out.println("Press 1 for sending or 2 for receive:");
			
			f=sc.nextInt();
			if(f==1){
             sendMessageToServer();}
			else{receiveMessage();}

			}
			
			
		}
		
	}
		
		
	
	
	public static void main(String[] args) {
		
        Communicator cm=new Communicator();
		cm.go();
		
	}




	public static void receiveMessage() {
		Scanner sc= new Scanner(System.in);
	    String addr="";
	    String textFromScan="";
	    
	    
	    	System.out.println("Enter your address:");
	    	
	    	addr=sc.nextLine();
	    	c1.set_address(addr);
	    	
	    	
	
	        c1.receivedFromServer(addr);
		
	}	
	
}
