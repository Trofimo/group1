package recursia;

public class Factorial {

	private static int chislo;
	private static String res;

	public Factorial() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chislo=Integer.parseInt(args[0]);
		res="";
		res=Integer.toString(calculate(chislo));	
		System.out.println("Факториал "+chislo+" равен "+res);
			
				
			
		
		
		
	}

	private static int calculate(int n) {
		// TODO Auto-generated method stub
		
	   
	        int result = 0;
	        if (n>=0){
	        if (n==1){
	        	return 1;
	        	}
	       
	        result = calculate(n - 1) * n;
	        return result;
	    }
			return result;
	}
	        }


