package graph;

import java.util.LinkedList;

public class Graph {

	int[][] a ;

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
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Pair) {
				Pair other = (Pair) obj;
				return (other._x == _x && other._y == _y); 
			}
			return super.equals(obj);
		}

	}

	LinkedList<Pair> coord = new LinkedList<>();
	LinkedList<Pair> queue = new LinkedList<>();

	private boolean[][] b;

	static int value = 0;

	private void find(int[][] m, int row, int col) {

		

		if (b[row][col] != true) {

			if (value == m[row][col]) {
				coord.add(new Pair(row, col));
				b[row][col] = true;

			}
			if ((row) != m.length - 1) {
				if (m[row][col] == m[row + 1][col]) {
					queue.add(new Pair(row + 1, col));
				}
			}
			if (row != 0) {
				if (m[row][col] == m[row - 1][col]) {
					queue.add(new Pair(row - 1, col));
				}
			}
			if (col != 0) {
				if (m[row][col] == m[row][col - 1]) {
					queue.add(new Pair(row, col - 1));
				}
			}
			if ((col) != m.length - 1) {
				if (m[row][col] == m[row][col + 1]) {
					queue.add(new Pair(row, col + 1));
				}
			}

		}
		queue.removeFirst();


	}

	public LinkedList<Pair> findAll(int[][] m, int valuex, int valuey) {
		value = m[valuex][valuey];
		
		coord.clear();

		queue.add(new Pair(valuex, valuey));
		b = new boolean[m.length][m.length];

		
		
		// для каждого направления:
		int x = 0;
		int y = 0;
		while (!queue.isEmpty()) {
			x = queue.peek().get_x();
			y = queue.peek().get_y();

			find(m, x, y);

		}
		return coord;
	}

}
