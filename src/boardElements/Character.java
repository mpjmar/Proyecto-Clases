package boardElements;

import utils.Utils;

public abstract class Character extends BoardElement {
	
	private String type;
	private int life;
	private int speed;
	private String chaser = "C";
	private String runner = "R";

	public Character(int row, int col, String type) {
		super(row, col);
		this.life = Utils.generateRandom(10, 20);
		this.speed = Utils.generateRandom(1, 5);
		this.type = type;
		setSymbol(type.equals("chaser") ? chaser : runner);
	}

	public int getLife() {
		return this.life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void sumLife(int life) {
		this.life += life;
	}
}
