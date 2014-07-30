package sudoku;


import java.util.HashSet;
import java.util.Set;



public class Sudoku {
	int[][] array=new int[9][9];
	static Boolean result = false;

	
	private Boolean isWinForSmallRect(int rmin,int rmax,int cmin,int cmax) {
		
		
  		Set<Integer> s=new HashSet<>();
		
       
       for (int r = rmin; r < rmax; r++) {
			for (int c = cmin; c < cmax; c++) {
				s.add(array[r][c]);	
				

					
					
				}
			}
		
			if(s.size()!=array.length){result =false;}
			else{result =true;}
			
		return result;
	}
	private Boolean isWinForRow(int rmin,int rmax) {
		Set<Integer> s=new HashSet<>();
		
		
		
			for (int r = rmin; r < rmax;) {
				for (int c = 0; c < array.length; c++) {
					s.add(array[r][c]);	
				}
			}
			if(s.size()!=array.length){result =false;}
			else{result =true;}
		return result;
	}
	private Boolean isWinForCol(int cmin,int cmax) {
		
		Set<Integer> s=new HashSet<>();
		
			for (int r = 0; r < array.length; r++) {
				for (int c = cmin; c < cmax;) {
					if(s.size()!=array.length){result =false;}
					else{result =true;}
				}
			}
			if(s.size()!=array.length){result =false;}
			else{result =true;}
		return result;
	}
	
	
	public   Boolean smallRectOne() {
		
		
		return isWinForSmallRect(0,3,0,3);
	
	}
	public Boolean smallRectTwo() {
		
		return isWinForSmallRect(0,3,3,6);
	
	}



	public Boolean smallRectThree() {

		return isWinForSmallRect(0,3,6,9);
		
	}



	public Boolean smallRectFour() {

		return isWinForSmallRect(3,6,0,3);
		
		
	}



	public Boolean smallRectFive() {
		return isWinForSmallRect(3,6,3,6);
		
	}



	public Boolean smallRectSix() {
		return isWinForSmallRect(3,6,6,9);
		
	}



	public Boolean smallRectSeven() {
		return isWinForSmallRect(6,9,0,3);
		
	}



	public Boolean smallRectEight() {

		return isWinForSmallRect(6,9,3,6);
		
	}



	public Boolean smallRectNine() {
		return isWinForSmallRect(6,9,6,9);
		
	}


	public Boolean RectColOne() {
		
		return isWinForCol(0,3);
	}



	public Boolean RectColTwo() {
		
		return isWinForCol(3,6);
	}



	public Boolean RectColThree() {
		
		return isWinForCol(6,9);
	}



	public Boolean RectRowOne() {
		
		
		return isWinForRow(0,3);
	}



	public Object RectRowTwo() {
		
		return isWinForRow(3,6);
	}



	public Object RectRowThree() {
		
		
		return isWinForRow(6,9);
	}
}
