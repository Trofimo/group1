package Mediator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class DemoTreeMap
{
  public static void main (String args[])
   {
    
    TreeMap<String, LinkedList<String>> tm = new TreeMap<String, LinkedList<String>>(); 
    Scanner sc= new Scanner(System.in);
    String addr="";
    String textFromScan="";
    LinkedList<String> tx=new LinkedList<>();
    for (int i = 0; i < 3; i++) {
    	System.out.println("Enter your address:");
    	
    	addr=sc.nextLine();
    	System.out.println("Enter any text");
    	
    	textFromScan=sc.nextLine();
    	
    	tx=tm.get(addr);
    	
    	if(tx==null){
    		tx=new LinkedList<String>();
    		tm.put(addr, tx);
    		
    		
    	}
    	tx.add(textFromScan);
    	
	}
    
    
    
   
    System.out.println("There is in box" + tm.size() +
                                         " messages.");
    
      
    Set<?> entries = tm.entrySet();
    Iterator<?> i = entries.iterator();
    while (i.hasNext()) {
      Map.Entry entry = (Map.Entry)i.next();
      System.out.println(entry.getKey() + " : "
        + entry.getValue());
     }
    System.out.println();
    }
 }
