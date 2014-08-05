package graph;


import java.util.LinkedList;




public class Graph {

	
	 
	  static public class Pair{
	        private int _x;
			private int _y;
			
			public Pair(int x,int y) {
				this._x = x;
				this._y = y;
				
			}
			public String getPair(){
				
				
				return Integer.toString(_x)+Integer.toString(_y);}
			
	       
	      
	    }
	 
	
	
	
	LinkedList<String> coord = new LinkedList<>();
	
	private boolean[][] b ;

	static int value = 0;

	public  LinkedList<String> findAll(int[][] m,int row, int col) {
		value = m[row][col];
		setSize(m);
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {

				// для каждого направления:
				find(m,i, j);

			}
		}

		return coord;

	}


	private void setSize(int[][] m) {
		b=new boolean[m.length][m.length] ;
		
	}
	

	private  void find( int[][] m,int r, int c) {

		
		
		
		if (b[r][c] != true) {

			if

			(value == m[r][c])

			{
				
				coord.add(new Pair(r,c).getPair());


				b[r][c] = true;

			}

		}

	}
	

}
