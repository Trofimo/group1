//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Scanner;
//
////http://kvodo.ru/search-width.html
//public class Example{
//
// 
//static boolean[][] visited;
//static int[][] graph;
//static int[][]a;
//LinkedList<Integer>
////_______________________________________
//public static void DFS(int x,int y)
//{
//	queue
//	int x1=x+1;
//	System.out.println(x1);
//	int y1=y+1;
//	System.out.println(y1);
//	int x2=x-1;
//	System.out.println(x2);
//	int y2=y-1;
//	System.out.println(y2);
//	
//	visited[x][y]=true;
//	
//			if (
//						(a[r][c]==a[x][y]) 
//					&& ((x==r)||(x==(r+1))||(x==(r-1))) 
//					&& ((y==c)||(y==(c+1))||(y==(c-1)) 
//					&&(!visited[r][c]))){
//				
//				
//				DFS(r,c);
//				
//			}
//	
//}
////_______________________________________
//
//
//public static void main(String[] args) {
//	
//	a=new int[][]{
//			{2,2,3,5,5},
//			{2,0,0,5,5},
//			{1,2,3,4,2},
//			{1,0,0,4,5},
//			{1,5,3,4,2},
//		};
//	
//	visited=new boolean[a.length][a.length];
//	
//	
//	System.out.println(" Enter coord>> ");
//	
//	int x=0;
//	int y=0;
//	Scanner scanner = new Scanner(System.in);
//	x=scanner.nextInt();
//	y=scanner.nextInt();
//	madeGraph(x,y);
//	System.out.println(x);
//	System.out.println(y);
//	DFS(x,y);
//	
//	
//}
//private static void madeGraph(int x,int y) {
//	
//	graph=new int[a.length][a.length];
//	for (int i=0; i<a.length-1; i++)
//	{
//		
//		for (int j=0; j<a.length-1; j++){
//			visited[i][j]=false;
//			if((a[i][j]==a[x][y]))
//			{graph[i][j]=1;}else{graph[i][j]=0;}
//			 System.out.println(" "+graph[i][j]);
//		}
//	}
//	
//}
//
//
//}




import java.util.LinkedList;



public class Example {

	static int[][] a = new int[][] { { 2, 3, 3 }, 
									 { 1, 1, 2 }, 
									 { 3, 3, 2 }, 
									 { 3, 3, 2 }, 
									 
									};

	static public class Pair {
		private int _x;
		private int _y;

		public Pair(int x, int y) {
			this.set_x(x);
			this.set_y(y);

		}

		public int get_x() {
			return _x;
		}

		public int get_y() {
			return _y;
		}

		public void set_x(int _x) {
			this._x = _x;
		}

		public void set_y(int _y) {
			this._y = _y;
		}

		@Override
		public String toString() {
			return _x + "," + _y;
		}

	}

	LinkedList<Pair> coord = new LinkedList<>();
	LinkedList<Pair> queue = new LinkedList<>();
	
	private boolean[][] b;

	static int value = 0;
	
	public void find(int[][] m, int row, int col) {
		
		
		int x=0;
		int y=0;
		
		if (b[row][col] != true) {

			if (value== m[row][col]) {
				coord.add(new Pair(row, col));
				b[row][col] = true;

			}
			if((row)!=m.length-1){
			if(m[row][col]==m[row+1][col]){
				queue.add(new Pair(row+1, col));
			}}
			if(row!=0){
			if(m[row][col]==m[row-1][col]){
				queue.add(new Pair(row-1, col));
				}}
			if(col!=0){
			if(m[row][col]==m[row][col-1]){
			queue.add(new Pair(row, col-1));}}
			if((col)!=m.length-1){
			if(m[row][col]==m[row][col+1]){
				queue.add(new Pair(row, col+1));
			}}
			
		   }
		queue.removeFirst();
					// для каждого направления:
					if(!queue.isEmpty()){
						x=queue.peek().get_x();
						y=queue.peek().get_y();
					
				       find(m,x,y);
				       
				       
					}	

		

	}

	private LinkedList<Pair> findAll(int[][] m, int valuex,int valuey) {
		value=m[valuex][valuey];
		
		queue.add(new Pair(valuex, valuey));
		b = new boolean[m.length][m.length];
		
		find(m,valuex,valuey);
		return coord;
	}
	public static void main(String[] args) {
		Example gr=new Example();
		System.out.println(gr.findAll(a,0,0).toString());
	}
}
