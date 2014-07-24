package tetris;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tetris {

	public static void main(String[] args) {
		
		
		JFrame frame = new JFrame("Tetris");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// setup graphics
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 700));
		
		
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
		
		Kernel kernel = new JavaKernel(panel);
		
		Model model = new Model();
		View view = new View(kernel);
		final Controller controller = new Controller(model, view);
		
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					controller.moveLeft();
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					controller.moveRight();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					controller.dropDown(true);
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					controller.rotate(true);
				}
				if (e.getKeyCode() == KeyEvent.VK_UP ) {
					controller.pause();
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER ) {
					controller.resume();
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					controller.menu();
				}
			}
			
		});
		
		ScheduledExecutorService service = 
				Executors.newSingleThreadScheduledExecutor();
		
		service.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				controller.slideDownOneRow();
			}
		}, 500, 200, TimeUnit.MILLISECONDS);
	}
	
}
