package Cook;
import java.util.Random;

public class CWWithBlockQueue {

	static String[] menu = { "Steak", "Pasta", "IceCream", "Soup" };

	static class Cook implements Runnable {
		private final BlockingQueue<String> queue;
		Cook(BlockingQueue<String> q){queue = q;}
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
		private final BlockingQueue<String> queue;
		Waiter(BlockingQueue<String> q) { queue = q; }
		@Override
		public void run() {
			while (true) {
				
				consume(queue.poll());	
				
			}
		}
		void consume(Object x) { System.out.println("Waiter: got " + x); }
	}

	public static void main(String[] args) {
		BlockingQueue<String> readyMeal=new BlockingQueue<String>();
		 Cook p = new Cook(readyMeal);
		 Waiter c = new Waiter(readyMeal);
	    
	     new Thread(p).start();
	     new Thread(c).start();
	    
		}

}
