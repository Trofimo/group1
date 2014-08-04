package graph;



import java.util.LinkedList;


public class Graph {
	
	int[][] a;
		

	boolean[][]b;
	static LinkedList<String> g =new LinkedList<>();
	public  LinkedList<String> findUp(int i,int j){
		g.clear();
		g.add(Integer.toString(i)+Integer.toString(j));
		
		while((i)!=0){
				if(b[i][j]!=true){
				
				if
					
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
		
		g.clear();
		g.add(Integer.toString(i)+Integer.toString(j));
		
		while((i+1)!=a.length){
				if(b[i][j]!=true){
				
				if( 
						    
						  
						  
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
		g.clear();
		g.add(Integer.toString(i)+Integer.toString(j));
		
		while((j)!=0){
				if(b[i][j]!=true){
				
					if
						    
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
		
		g.clear();
		g.add(Integer.toString(i)+Integer.toString(j));
		
		while((j+1)!=a.length){
				if(b[i][j]!=true){

					if
					    
					(a[i][j] == a[i][j + 1]){

						g.add(Integer.toString(i)+Integer.toString(j+1));
							
						b[i][j]=true;
							
						
						
				j++;
				
				}
				
				}
		}
		 return g;
	}
	


	
}
