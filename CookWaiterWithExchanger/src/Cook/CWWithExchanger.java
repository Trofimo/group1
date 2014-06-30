package Cook;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class CWWithExchanger {
	static String[] menu = { "Steak", "Pasta", "IceCream", "Soup" };
	static String food;
	public static class Waiter implements Runnable {

		public static Exchanger<String> exchanger = new Exchanger<String>();

		

		public void run() {

			while (true)

				try {

					food = exchanger.exchange(food);

					System.out.println("Waiter got: " + food);

				} catch (InterruptedException e) {

					e.printStackTrace();

				}

		}
		
	}
		public static class Cook implements Runnable {

			static public final int count = 0;

			public static final Exchanger<String> exchanger = Waiter.exchanger;

			

			public void run() {

				while (true)

					try {

						food = exchanger.exchange(produce());

						

					} catch (InterruptedException e) {

						e.printStackTrace();

					}

			}
			private String produce() {
				Random random = new Random();
				String item = menu[random.nextInt(menu.length)];
				System.out.println("Cook: " + item);
				return item;
				}
		}
		public static void main(String[] args) {
			

			new Thread(new Cook()).start();
			new Thread(new Waiter()).start();
		}
		
	
}