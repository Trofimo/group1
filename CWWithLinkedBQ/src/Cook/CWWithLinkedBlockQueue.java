package Cook;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class CWWithLinkedBlockQueue {

	static String[] menu = { "Steak", "Pasta", "IceCream", "Soup" };

	static class Cook implements Runnable {
		private final LinkedBlockingQueue<String> queue;
		Cook(LinkedBlockingQueue<String> readyMeal){queue = readyMeal;}
		@Override
		public void run() {
			
			while (true) {
				
				queue.offer((String) produce());
				
			}		
				
		}
		Object produce() {
			Random random = new Random();
			String item = menu[random.nextInt(menu.length)];
			System.out.println("Cook: " + item);
			return item;
			}
	}

	static class Waiter implements Runnable {
		private final LinkedBlockingQueue<String> queue;
		Waiter(LinkedBlockingQueue<String> readyMeal) { queue = readyMeal; }
		@Override
		public void run() {
			while (true) {
				
				consume(queue.poll());	
				
			}
		}
		void consume(Object x) { System.out.println("Waiter: got " + x); }
	}

	public static void main(String[] args) {
		LinkedBlockingQueue<String> readyMeal=new LinkedBlockingQueue<>();
		 Cook p = new Cook(readyMeal);
		 Waiter c = new Waiter(readyMeal);
	    
	     new Thread(p).start();
	     new Thread(c).start();
	    
		}

}
