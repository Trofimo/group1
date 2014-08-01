package tetris;

public class Field {

	public static final int HEIGHT = 20;
	public static final int WIDTH = 9;
	public int[][] box = new int[HEIGHT][WIDTH];
	
	public boolean hasConflictAt(int row, int col, int[][] data) {
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++) {
				if (data[r][c] == 0) {
					continue;
				}
				int newRow = row + r;
				int newCol = col + c;
				if (newRow < 0 || newCol < 0 ||
						newRow >= Field.HEIGHT || newCol >= Field.WIDTH) {
					return true;
				}
				if (box[newRow][newCol] > 0) {
					return true;
				}
			}
		}
		return false;
	}

	public void paste(int row, int col, int[][] data) {
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++) {
				if (data[r][c] == 0) {
					continue;
				}
				int newRow = row + r;
				int newCol = col + c;
				box[newRow][newCol]  = data[r][c];
			}
		}
		
	}

	public void removeFullRows() {
		int[][] b = new int[box.length][box[0].length];
		int pointer = b.length - 1;
		for (int r = box.length - 1; r >= 0; r--) {
			if (isFull(box[r])) {
				continue;
			}
			b[pointer--] = box[r];
		}
		box = b;
	}

	private boolean isFull(int[] row) {
		for (int i = 0; i < row.length; i++) {
			if (row[i] == 0) {
				return false;
			}
		}
		return true;
	}
	
}
