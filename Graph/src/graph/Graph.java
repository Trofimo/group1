package graph;

import java.util.LinkedList;



public class Graph {

	int[][] a ; 

	boolean[][] b = new boolean[3][3];
	LinkedList<Integer> coordX = new LinkedList<>();
	LinkedList<Integer> coordY = new LinkedList<>();

	static int value = 0;

	public  LinkedList<Integer> findAllX(int row, int col) {
		value = a[row][col];
		//coordX.clear();
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {

				// для каждого направления:
				find(i, j);

			}
		}

		return coordX;

	}
	public  LinkedList<Integer> findAllY(int row, int col) {
		value = a[row][col];
		//coordY.clear();
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				
				// для каждого направления:
				find(i, j);
				
			}
		}
		
		return coordY;
		
	}

	private  void find(int r, int c) {

		if (b[r][c] != true) {

			if

			(value == a[r][c])

			{
				coordX.add(r);
				coordY.add(c);

				b[r][c] = true;

			}

		}

	}
	

}
