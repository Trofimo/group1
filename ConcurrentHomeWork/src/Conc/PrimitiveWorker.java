package Conc;

import java.util.LinkedList;
import java.util.Queue;

public class PrimitiveWorker extends Thread{
	
	private static final Runnable POISON_PILL = new Runnable() {
		@Override
		public void run() {
			
		}
	};

	final private Queue<Runnable> _tasks = new LinkedList<>();

	private class WorkerTask extends Thread implements Runnable {
		@Override
		public void run() {
			Runnable task;
			
			while (true) {
				task = _tasks.poll();
			
				if (task == POISON_PILL) {
					break;
				}
				try {
					task.run();
					sleep(1000);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public PrimitiveWorker() {
		new Thread(this.new WorkerTask()).start();
	}

	

	public void execute(Runnable task) {
		
			_tasks.offer(task);
			
			System.out.println("added task");
		
	}
	
	public void shutdown() {
		execute(POISON_PILL);
		interrupt();
	}

}