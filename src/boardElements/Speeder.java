package boardElements;

public class Speeder extends BoardElement {

	int amount;

	public Speeder(int row, int col, int amount) {
		super(row, col);
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
