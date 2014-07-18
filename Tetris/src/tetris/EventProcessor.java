package tetris;

public interface EventProcessor {

	void moveLeft();

	void moveRight();

	void slideDownOneRow();

	void dropdown();

	void rotate();

}