package balans;

public class Balans {

	
	
	int result = 0;
	
	static private int sum(int[] a) {
		int s = 0;
		for (int i = 0; i < a.length; i++) {
			s = s + a[i];
		}
		return s;
	}

	public int balans(int[] _a) {
	    int[] _g = new int[_a.length];
		for (int i = 0; i < _a.length; i++) {
			int valueA = _a[i];
			_a[i] = 0;
			_g[i] = valueA;

			if (sum(_g) == sum(_a)) {
				result += i;
				return result;
			}
			if ((sum(_g) != sum(_a)) && (i==_a.length-1)){
				result += -1;
			}
		}

		return result;

	}


}