package tetris;

public interface EventProcessor {

	void moveLeft();

	void moveRight();

	void rotate(boolean b);

	void dropDown(boolean b);

	void slideDownOneRow();

}