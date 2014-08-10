package balans;

public class Balans {

	private int sum(int[]a){
		int s=0;
		for (int i = 0; i < a.length; i++) {
			s=s+a[i];
			
		}
		return s;
	}
	public int balans(int[]_a){
		int Sa=sum(_a);
		int Sg=0;
		int result=0;
		
		for (int i = 0; i < _a.length; i++) {
			Sa=Sa-_a[i];
			Sg=Sg+_a[i];
			if(Sa==Sg){
				result+=i;
				return result;
			}
			if((Sa!=Sg)&&(i==_a.length-1)){
				result+=-1;
			}
		}
		return result;
	}
}