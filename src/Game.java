

import java.util.ArrayList;

import board.Board;
import boardElements.*;
import utils.*;
import input.*;


public class Game {
    public static void main(String[] args) throws Exception {

		int option = -1;
		int rows = -1;
		int cols = -1;
		int level = 1;

		do {
			option = Utils.displayMenu();
			switch (option) {
				case 1:
					System.out.println("Please, enter the board size: ");
					System.out.print("Heigth (10 - 100): ");
					rows = Input.readInteger(10, 50);
					System.out.print("Width (10 - 100): ");
					cols = Input.readInteger(10, 50);
					launch(rows, cols, level);
					break;
				case 2:
					level = Utils.displaySubmenu();
					break;
				case 3:
					Utils.gameMechanics();
					break;
				default:
					break;
			}
		} while (option != 4);
	}

	public static void launch(int rows, int cols, int level) throws InterruptedException {
		Board board = new Board(rows, cols);
		ArrayList<BoardElement> gameElements = new ArrayList<BoardElement>();

		Obstacle.setObstacles(board, level, gameElements);
		Runner.setRunners(board, level, gameElements);
		Chaser.setChasers(board, level, gameElements);
		
        do {
			Utils.clearConsole();
			board.clearBoard();
			for (BoardElement e : gameElements)
				if (e instanceof Target character)
					character.setTarget(gameElements);
			board.placeElements(gameElements);
			System.out.println(board);
			Movements.moveCharacters(gameElements);
            Thread.sleep(1000);
        } while (true);
    }
}
