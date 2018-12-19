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
	//Can only win when player has the key, or he would only be there with nothing happening.
	public void enterRoom(Person x) {
		if (x.getKey()) {
			occupant = x;
			x.setxLoc(this.xLoc);
			x.setyLoc(this.yLoc);
			System.out.println("CONGRATULATIONS! YOU WIN!");
			Runner.gameOff();
		}
		else{
			occupant = x;
			x.setxLoc(this.xLoc);
			x.setyLoc(this.yLoc);
			System.out.println("The door of this room seems to be locked, you need a key!");
		}
	}

	public String toString(){
		if (!(occupant== null)){
			return "P ";
		}
		else {
			return "W ";
		}
	}
	

}
