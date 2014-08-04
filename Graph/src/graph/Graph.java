package graph;



import java.util.Deque;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;


public class Graph {
	
	static int[][] a;
		

	static boolean[][]b;
	static LinkedList<Integer> x =new LinkedList<>();
	static LinkedList<Integer> y=new LinkedList<>();
	static LinkedHashMap<LinkedList<Integer>,LinkedList<Integer>>  loop=new LinkedHashMap<>();
	static LinkedHashMap<LinkedList<Integer>,LinkedList<Integer>> result=new LinkedHashMap<>();
	
	public LinkedHashMap<LinkedList<Integer>,LinkedList<Integer>> findAll(int row,int col){
		//берем из очереди след элемент
		
				//вызываем рекурсию след проверяемого элемента
				
					while(!loop.isEmpty()){
						int[][] nextt = loop.pop();
						findAll(nextt);
					}
		if(b[row][col]==false){
		
		//для каждого направления:
		findUp(row,col);
		findDown(row,col);
		findLeft(row,col);
		findRight(row,col);
		}			
		
		
		
		return result;
		
		
	}
	private static  LinkedList<String> findUp(int i,int j){
		x.clear();y.clear();
		
		//по пути считываем значения и сравниваем их с тек координатой
		while((i)!=0){
		
				if
					
					(
						    
						  (a[i][j] == a[i - 1][j])) 
						  
						   
						{

							
							x.add(i-1);
							y.add(j);
							//записываем в очередь те координаты, значения которых совпадают
							loop.put(x, y);
							//помечаем как true
							b[i][j]=true;
							
							
						}i--;
				
				}
		
		 return g;
	}
	private static  LinkedList<String> findDown(int i,int j){
		
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
	private static  LinkedList<String> findLeft(int i,int j){
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
private static  LinkedList<String> findRight(int i,int j){
		
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
