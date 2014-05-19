package recursia;

public class Fibonachi {

	private static int chislo;
	private static String res;
	public Fibonachi() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chislo=Integer.parseInt(args[0]);
		res="";
		res=Integer.toString(fib(chislo));	
		System.out.println(res+" is the "+chislo+"th Fibonacci number");
			
				
			
	}
	private static int fib (int n) {
		  if (n==1 || n == 2) {
			    return 1;
			  }
			  return fib (n-2) + fib (n-1);
	}}



