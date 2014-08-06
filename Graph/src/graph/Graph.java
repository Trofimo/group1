package graph;



import java.util.Collection;
import java.util.LinkedList;




public class Graph {

	
	 
	  static public class Pair{
	        private int _x;
			private int _y;
			
			public Pair(int x,int y) {
				this.set_x(x);
				this.set_y(y);
				
			}
			public Collection<? extends Pair> getPair(){
				
				
				return coord;
				}

			public void set_x(int _x) {
				this._x = _x;
			}

			public void set_y(int _y) {
				this._y = _y;
			}
			
	       
	      
	    }
	 
	
	
	
	static LinkedList<Pair> coord = new LinkedList<>();
	
	private boolean[][] b ;

	static int value = 0;

	public  LinkedList<Pair> findAll(int[][] m,int row, int col) {
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
				Pair p = new Pair(r,c);
				
				
				coord.addAll(p.getPair());


				b[r][c] = true;

			}

		}

	}
	

}
