

import board.Board;
import boardElements.Character;
import utils.*;
import exceptions.*;
import input.*;


public class App {
    public static void main(String[] args) throws Exception {

		int option = -1;

		do {
			Utils.displayMenu();
			System.out.print("Select an option: ");
			option = Input.readInteger(1, 3);
			switch (option) {
				case 1:
					System.out.println("Please, enter the board size: ");
					System.out.print("Heigth (8 - 20): ");
					int height = Input.readInteger(8, 20);
					System.out.print("Width (8 - 20): ");
					int width = Input.readInteger(8, 20);
					Board board = new Board(height, width);
					board.setObstacles(height, width);
					break;
				case 2:
					Utils.displayInstructions();
					break;
			}
		} while (option != 3);
	}
}
