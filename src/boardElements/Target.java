package boardElements;

import java.util.ArrayList;

public interface Target {
	void setTarget(ArrayList<BoardElement> e);
	int getRow();
	int getCol();
}
