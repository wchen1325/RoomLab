package Game;

import People.Person;
import Rooms.KeyRoom;
import Rooms.Room;
import Rooms.WinningRoom;
import Board.Board;

import java.util.Scanner;

public class Runner {
	

	private static boolean gameOn = true;
	
	public static void main(String[] args)
	{
		System.out.println("▒▒▒▒▒▒▒█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█\n" +
				"▒▒▒▒▒▒▒█░▒▒▒▒▒▒▒▓▒▒▓▒▒▒▒▒▒▒░█\n" +
				"▒▒▒▒▒▒▒█░▒▒▓▒▒▒▒▒▒▒▒▒▄▄▒▓▒▒░█░▄▄\n" +
				"▒▒▄▀▀▄▄█░▒▒▒▒▒▒▓▒▒▒▒█░░▀▄▄▄▄▄▀░░█\n" +
				"▒▒█░░░░█░▒▒▒▒▒▒▒▒▒▒▒█░░░░░░░░░░░█\n" +
				"▒▒▒▀▀▄▄█░▒▒▒▒▓▒▒▒▓▒█░░░█▒░░░░█▒░░█\n" +
				"▒▒▒▒▒▒▒█░▒▓▒▒▒▒▓▒▒▒█░░░░░░░▀░░░░░█\n" +
				"▒▒▒▒▒▄▄█░▒▒▒▓▒▒▒▒▒▒▒█░░█▄▄█▄▄█░░█\n" +
				"▒▒▒▒█░░░█▄▄▄▄▄▄▄▄▄▄█░█▄▄▄▄▄▄▄▄▄█\n" +
				"▒▒▒▒█▄▄█░░█▄▄█░░░░░░█▄▄█░░█▄▄█\n" +
				"HARD MODE?[Y/N]");
		//input scanner
		Scanner in = new Scanner(System.in);

		//Choose easy or hard mode for two different board to be created.
		//can replace the numbers. but only odd numbers should be inputted.
		int easy = 11;
		Room[][] building = new Room[easy][easy];
		Board floor1 = new Board(building, easy);

		if(in.nextLine().equals("Y")){
			building = new Room[21][21];
			floor1 = new Board(building);
		}


		 //Setup player 1
		Person player1 = new Person("FirstName", "FamilyName", 0,0, false);
		building[1][1].enterRoom(player1);

		while(gameOn)
		{
			System.out.println(floor1.toString(player1));
			System.out.println("Where would you like to move? (Choose W, S, A, D)");
			String move = in.nextLine();
			if(Person.validMove(move, player1, building))
			{
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
				
			}
			else {
				System.out.println("Please choose a valid move.");
			}
			
			
		}
		in.close();
	}

	public static void gameOff()
	{
		gameOn = false;
	}
	


}
