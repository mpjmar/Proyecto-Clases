

import board.Board;
import utils.*;
import input.*;


public class App {
    public static void main(String[] args) throws Exception {

		int option = -1;
		int rows = -1;
		int cols = -1;
		int level = 1;
		Board board = new Board(0, 0);

		do {
			option = Utils.displayMenu();
			switch (option) {
				case 1:
					System.out.println("Please, enter the board size: ");
					System.out.print("Heigth (8 - 20): ");
					rows = Input.readInteger(8, 20);
					System.out.print("Width (8 - 20): ");
					cols = Input.readInteger(8, 20);
					board = new Board(rows, cols);
					board.setObstacles(rows, cols, level);
					System.out.println(board);
					break;
				case 2:
					level = Utils.displaySubmenu();
					break;
				case 3:
					Utils.displayInstructions();
					break;
				default:
					break;
			}
		} while (option != 4);
	}
}
