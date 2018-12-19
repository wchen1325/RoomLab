package Rooms;

import People.Person;

public class Room {
	Person occupant;
	int xLoc,yLoc;

	
	public Room(int x, int y)
	{
		xLoc = x;
		yLoc = y;
	}

	/**
	 * Method controls the results when a person enters this room.
	 * @param x the Person entering
	 */
	public void enterRoom(Person x)
	{
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
	}

	/**
	 * Removes the player from the room.
	 * @param x
	 */
	public void leaveRoom(Person x)
	{
		occupant = null;
	}

	public String toString(){
		if (!(occupant== null)){
			return "P ";
		}
		else {
				return "▒";
		}
	}

	//This is a room that the player can go into
	public boolean isRoom(){
		return true;
	}

}
