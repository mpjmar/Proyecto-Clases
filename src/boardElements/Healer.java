package boardElements;

public class Healer extends BoardElement {
	
	private int life;

	public Healer(int row, int col, int life) {
		super(row, col);
		this.life = life;
	}
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
}
