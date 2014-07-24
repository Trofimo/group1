package tetris;

public interface EventProcessor {

	void moveLeft();

	void moveRight();

	void rotate();

	void dropDown();

	void slideDownOneRow();

}