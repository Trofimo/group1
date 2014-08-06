package balans;



public class Balans {

	
	
	static int[] _g;
	static int result=0;
	
	
	public int balans(int[] _a){
		setSize(_a);
		for (int i = 0; i < _a.length; i++) {
			int valueA=_a[i];
			_a[i]=0;
			_g[i]=valueA;
			
			
			
			if (sumL(_g) != sumR(_a))
				continue;
			if ((i==_a.length-1)) {result= -1;}
			else{
			result+= i;}
			
		}
		
		return result;
		
		
	}

	private static void setSize(int[] _a) {
		_g=new int[_a.length];
		
	}

	static private int sumR(int[] a) {
		int s=0;
		for (int i = 0; i < a.length; i++) {
			s=s+a[i];
		}
		return s;
	}
	static private int sumL(int[] g) {
		int s=0;
		for (int i = 0; i < g.length; i++) {
			s=s+g[i];
		}
		return s;
	}
	
	
}