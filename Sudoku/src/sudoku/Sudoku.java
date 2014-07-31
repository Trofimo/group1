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
	private Boolean isWinForRow(int r) {
		Set<Integer> s=new HashSet<>();
		
		
		
			
				for (int c = 0; c < array.length; c++) {
					s.add(array[r][c]);	
				}
			
			if(s.size()!=array.length){result =false;}
			else{result =true;}
		return result;
	}
	private Boolean isWinForCol(int c) {
		
		Set<Integer> s=new HashSet<>();
		
			for (int r = 0; r < array.length; r++) {
				
					s.add(array[r][c]);
				
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
		
		return isWinForCol(0);
	}



	public Boolean RectColTwo() {
		
		return isWinForCol(1);
	}



	public Boolean RectColThree() {
		
		return isWinForCol(2);
	}
	public Boolean RectColFour() {
		
		return isWinForCol(3);
	}
	public Boolean RectColFive() {
		
		return isWinForCol(4);
	}
	public Boolean RectColSix() {
		
		return isWinForCol(5);
	}
	public Boolean RectColSeven() {
		
		return isWinForCol(6);
	}
	public Boolean RectColEight() {
		
		return isWinForCol(7);
	}
	public Boolean RectColNine() {
		
		return isWinForCol(8);
	}



	public Boolean RectRowOne() {
		
		
		return isWinForRow(0);
	}



	public Boolean RectRowTwo() {
		
		return isWinForRow(1);
	}



	public Boolean RectRowThree() {
		
		
		return isWinForRow(2);
	}
	public Boolean RectRowFour() {
		
		
		return isWinForRow(3);
	}
	public Boolean RectRowFive() {
		
		
		return isWinForRow(4);
	}
	public Boolean RectRowSix() {
		
		
		return isWinForRow(5);
	}
	public Boolean RectRowSeven() {
		
		
		return isWinForRow(6);
	}
	public Boolean RectRowEight() {
		
		
		return isWinForRow(7);
	}
	public Boolean RectRowNine() {
		
		
		return isWinForRow(8);
	}
}
