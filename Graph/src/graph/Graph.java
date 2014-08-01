package graph;

public class Graph {
	static int[][] a = new int[][] { { 1, 1, 1 ,2 },   
		                             { 1, 1, 2 ,2 }, 
		                             { 1, 1, 1, 0 },
			                         { 2, 1, 1, 2 }, 
			                       };

	static String[] g = new String[100];
	private static String[] find(int value){
		
		int m = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {

				if( ((i - 1) >= 0)
					&&((j - 1) >= 0)
					&&((i + 1) < 5)
					&&((j + 1) < 3)
					) {
					if( (a[i][j] == value)&&(
					    (a[i][j] == a[i][j - 1])
					  ||(a[i][j] == a[i][j + 1])
					  ||(a[i][j] == a[i - 1][j])
					  ||(a[i][j] == a[i + 1][j])) 
					  
					  ) 
					{

						g[m] = Integer.toString(i)+Integer.toString(j);
						
						
					}else continue;
				} else if(a[i][j]==value){
					g[m] = Integer.toString(i)+Integer.toString(j);
				}
				m++;
				
			}
		}

		 return g;
	}
	public static void main(String[] args) {
		int value = 2;
		g=find(value).clone();
		for (int k = 0; k < g.length; k++) {
			if(g[k]!=null){
			System.out.println("row: " + g[k]);}
			
		}

	}

}
