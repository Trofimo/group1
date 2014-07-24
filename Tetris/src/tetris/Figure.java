package tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Figure {
	
	static final int[][] FIGURE_I = {
		{0,1,0,0},
		{0,1,0,0},
		{0,1,0,0},
		{0,1,0,0},
	};
	
	static final int[][] FIGURE_L = {
		{0,2,0,0},
		{0,2,0,0},
		{0,2,2,0},
		{0,0,0,0},
	};
	
	static final int[][] FIGURE_Z = {
		{0,0,0,0},
		{0,3,3,0},
		{0,0,3,3},
		{0,0,0,0},
	};
	
	static final int[][] FIGURE_T = {
		{0,0,0,0},
		{0,4,4,4},
		{0,0,4,0},
		{0,0,0,0},
	};
	
	static final int[][] FIGURE_O = {
		{0,0,0,0},
		{0,5,5,0},
		{0,5,5,0},
		{0,0,0,0},
	};
	
	int[][] rotate(int [][] data) {
		int m = 4;
        int[][] A = new int[m][m];
        A=data.clone();
        
        for (int k=0; k<m/2; k++) // border -> center
        {
            for (int j=k; j<m-1-k; j++) // left -> right
            {
                
                int tmp         = A[k][j];
                A[k][j]         = A[j][m-1-k];
                A[j][m-1-k]     = A[m-1-k][m-1-j];
                A[m-1-k][m-1-j] = A[m-1-j][k];
                A[m-1-j][k]     = tmp;
            }
        }
        
		return A;
	}
	
	static int[][] flip(int[][] data) {
		// flip by vertical axis
		int[][] newdata = new int[4][4];
		// home work
		return newdata;
	}
	
	static List<int[][]> figureData = new ArrayList<>(19);
	
	static {
		figureData.add(FIGURE_L);
		figureData.add(FIGURE_L);
		figureData.add(FIGURE_L);
		figureData.add(FIGURE_L);
		figureData.add(FIGURE_L);
		figureData.add(FIGURE_L);
		figureData.add(FIGURE_L);
		figureData.add(FIGURE_L);
		
		figureData.add(FIGURE_Z);
		figureData.add(FIGURE_Z);
		figureData.add(FIGURE_Z);
		figureData.add(FIGURE_Z);
		
		figureData.add(FIGURE_T);
		figureData.add(FIGURE_T);
		figureData.add(FIGURE_T);
		figureData.add(FIGURE_T);
		
		figureData.add(FIGURE_I);
		figureData.add(FIGURE_I);
		
		figureData.add(FIGURE_O);
	}
	
	static Random random = new Random();
	
	public int[][] data = new int[4][4];
	
	private Figure() {
	}

	public static Figure randomFigure() {
		Figure figure = new Figure();
		int[][] data = figureData.get(random.nextInt(figureData.size()));
		figure.data = data;
		return figure;
	}

}
