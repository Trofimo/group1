package graph;


import java.util.LinkedList;

public class Graph {
	
	int[][] a;
		

	static boolean[][]b=new boolean[][]{
		{false,false,false,false},
		{false,false,false,false},
		{false,false,false,false},
		{false,false,false,false},
		};
	static LinkedList<String> g =new LinkedList<>();
	public  LinkedList<String> findUp(int i,int j){
		
		
		while(i!=0){
				if(b[i][j]!=true){
				
					if( i == 0){
						g.add(Integer.toString(i)+Integer.toString(j));
						b[i][j]=true;
					}
					else if
					
					(
						    
						  (a[i][j] == a[i - 1][j])) 
						  
						   
						{

							
							g.add(Integer.toString(i-1)+Integer.toString(j));
							b[i][j]=true;
							
							
						}i--;
				}
				}
					
		 return g;
	}
	public  LinkedList<String> findDown(int i,int j){
		
		
		while(i!=a.length-1){
				if(b[i][j]!=true){
				
					if( i==a.length-1){
						
						    g.add(Integer.toString(i)+Integer.toString(j));
							
							b[i][j]=true;
							
							
						
					}
					else if( 
						    
						  
						  
						  (a[i][j] == a[i + 1][j])) 
						  
						  
						{
						    g.add(Integer.toString(i+1)+Integer.toString(j));
							
							b[i][j]=true;
							
							
						}i++;
				
				}
				
				}
		 return g;
	}
	public  LinkedList<String> findLeft(int i,int j){
		
		
		while(j!=0){
				if(b[i][j]!=true){
				
					if(j==0){
						g.add(Integer.toString(i)+Integer.toString(j));
						
					    b[i][j]=true;
					    }
					else if
						    
						  (a[i][j] == a[i][j - 1])
						  
						 
						{
						    g.add(Integer.toString(i)+Integer.toString(j-1));
							
							b[i][j]=true;
							
							
						}j--;
				}
				
				
	}
		
		 return g;
	}
	public  LinkedList<String> findRight(int i,int j){
		
		
		while(j!=a.length-1){
				if(b[i][j]!=true){
				
					if(j==a.length-1){
						g.add(Integer.toString(i)+Integer.toString(j));
						
						b[i][j]=true;
					}
					else if
						    
						  (a[i][j] == a[i][j + 1])
						  
						  
						{
						g.add(Integer.toString(i)+Integer.toString(j+1));
							
							b[i][j]=true;
							
							
						}j++;
				}
					
				
		}	
			

		 return g;
	}
	
//	public static void main(String[] args) {
//		
//		LinkedList<String>Up=findUp(3,1);
//		for (Iterator<String> iterator = Up.iterator(); iterator.hasNext();) {
//			
//			String string = (String) iterator.next();
//			System.out.println(string);
//		}
//		
//		LinkedList<String>Down=findDown(0,0);
//		for (Iterator<String> iterator = Down.iterator(); iterator.hasNext();) {
//			
//			String string = (String) iterator.next();
//			System.out.println(string);
//		}
//		LinkedList<String>Left=findLeft(2,0);
//		for (Iterator<String> iterator = Left.iterator(); iterator.hasNext();) {
//			
//			String string = (String) iterator.next();
//			System.out.println(string);
//		}
//		LinkedList<String>Right=findRight(2,0);
//		for (Iterator<String> iterator = Right.iterator(); iterator.hasNext();) {
//			
//			String string = (String) iterator.next();
//			System.out.println(string);
//		}

	//}
}
