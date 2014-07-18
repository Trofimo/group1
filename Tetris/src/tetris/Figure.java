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
		{0,1,0,0},
		{0,1,0,0},
		{0,1,1,0},
		{0,0,0,0},
	};
	static final int[][] FIGURE_Z = {
		{0,0,0,0},
		{0,1,1,0},
		{0,0,1,1},
		{0,0,0,0},
	};
	static final int[][] FIGURE_T = {
		{0,0,0,0},
		{0,1,1,1},
		{0,0,1,0},
		{0,0,0,0},
	};
	static final int[][] FIGURE_O = {
		{0,0,0,0},
		{0,1,1,0},
		{0,1,1,0},
		{0,0,0,0},
	};
	
	static int[][] rotate(int[][] data){
		// rotate 90 degrees counter-clockwise
		int[][] newdata = new int[4][4];
		for(int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				newdata[i][j] = data[3-j][i];
			}				
		}
		return newdata;
	}
	static int[][] flip(int [][] data){
		// flip by vertical axis
		int[][] newdata = new int[4][4];
		for(int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				newdata[i][j] = data[i][3-j];
			}				
		}
		return newdata;
	}

	static List<int[][]> figureData = new ArrayList<int[][]>(19);
	static{
		// TODO fill with real data
		figureData.add(FIGURE_L);
		figureData.add(rotate(FIGURE_L));
		figureData.add(rotate(rotate(FIGURE_L)));
		figureData.add(rotate(rotate(rotate(FIGURE_L))));
		figureData.add(flip(FIGURE_L));
		figureData.add(flip(rotate(FIGURE_L)));
		figureData.add(flip(rotate(rotate(FIGURE_L))));
		figureData.add(flip(rotate(rotate(rotate(FIGURE_L)))));

		figureData.add(FIGURE_Z);
		figureData.add(rotate(FIGURE_Z));
		figureData.add(flip(FIGURE_Z));
		figureData.add(flip(rotate(FIGURE_Z)));

		figureData.add(FIGURE_T);
		figureData.add(rotate(FIGURE_T));
		figureData.add(rotate(rotate(FIGURE_T)));
		figureData.add(rotate(rotate(rotate(FIGURE_T))));
		
		figureData.add(rotate(FIGURE_I));
		figureData.add(FIGURE_I);

		figureData.add(FIGURE_O);

	}
	static Random random = new Random();
	
	public static Figure randomFigure() {
		Figure result = new Figure();
		result.data = figureData.get(random.nextInt(figureData.size()));
		return result;
	}
	
	public int[][] data = new int[4][4];

	private Figure(){
	}
	
}
