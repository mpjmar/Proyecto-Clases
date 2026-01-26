

import board.Board;
import boardElements.Character;
import utils.*;
import exceptions.*;
import input.*;


public class App {
    public static void main(String[] args) throws Exception {

		int option = -1;
		Board board =;

		do {
			Utils.displayMenu();
			System.out.print("Select an option: ");
			option = Input.readInteger(1, 4);
			switch (option) {
				case 1:
					System.out.println("Please, enter the board size: ");
					System.out.print("Heigth (8 - 20): ");
					int height = Input.readInteger(8, 20);
					System.out.print("Width (8 - 20): ");
					int width = Input.readInteger(8, 20);
					board = new Board(height, width);
					break;
				case 2:
					int level = Utils.displaySubmenu();
					board.setObstacles(height, width, level);
				case 3:
					Utils.displayInstructions();
					break;
			}
		} while (option != 3);
	}
}
