package balans;

public class Balans {

	static int[] _g;
	static int result = 0;

	public int balans(int[] _a) {
		_g = new int[_a.length];
		quicksort(_a,0,_a.length-1);
		for (int i = 0; i < _a.length; i++) {
			int valueA = _a[i];
			_a[i] = 0;
			_g[i] = valueA;

			if (sumL(_g) != sumR(_a))
				continue;
			if ((i == _a.length - 1)) {
				result = -1;
			} else {
				result += i;
			}

		}

		return result;

	}

	
	private int partition (int[] array, int start, int end) 
	   {
	       int marker = start;
	       for ( int i = start; i <= end; i++ ) 
	       {
	           if ( array[i] <= array[end] ) 
	           {
	               int temp = array[marker]; // swap
	               array[marker] = array[i];
	               array[i] = temp;
	               marker += 1;
	           }
	       }
	       return marker - 1;
	   }
	 
	  private void quicksort (int[] array, int start, int end)
	   {
	       if ( start >= end ) 
	       {
	           return;
	       }
	       int pivot = partition (array, start, end);
	       quicksort (array, start, pivot-1);
	       quicksort (array, pivot+1, end);
	   }
	

	static private int sumR(int[] a) {
		int s = 0;
		for (int i = 0; i < a.length; i++) {
			s = s + a[i];
		}
		return s;
	}

	static private int sumL(int[] g) {
		int s = 0;
		for (int i = 0; i < g.length; i++) {
			s = s + g[i];
		}
		return s;
	}

}