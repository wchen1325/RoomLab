package Rooms;

import Game.Runner;
import People.Person;

public class WinningRoom extends Room
{

	public WinningRoom(int x, int y) {
		super(x, y);

	}

	/**
	 * Triggers the game ending conditions.
	 * @param x the Person entering
	 */
	@Override
	public void enterRoom(Person x) {
		if (x.getKey()) {
			occupant = x;
			x.setxLoc(this.xLoc);
			x.setyLoc(this.yLoc);
			System.out.println("You found the winning room! Ten points for Gryffindor.");
			Runner.gameOff();
		}
		else{
			occupant = x;
			System.out.println("The door of this room seems to be locked, you need a key!");
		}
	}

	public String toString(){
		return "[w]";
	}
	

}
