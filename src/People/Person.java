package People;

import Rooms.Room;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
	String firstName;
	String familyName;
	int xLoc, yLoc;
	boolean hasKey;


	public int getxLoc() {
		return xLoc;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}

	public Person (String firstName, String familyName, int xLoc, int yLoc, boolean hasKey)
	{
		this.firstName = firstName;
		this.familyName = familyName;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.hasKey = hasKey;
	}

	/**
	 * Checks that the movement chosen is within the valid game map.
	 * @param move the move chosen
	 * @param p person moving
	 * @param map the 2D array of rooms
	 * @return
	 */
	public static boolean validMove(String move, Person p, Room[][] map)
	{
		move = move.toLowerCase().trim();
		switch (move) {
			case "w":
				if (p.getxLoc() > 0)
				{
					if(map[p.getxLoc()-1][p.getyLoc()].isRoom()) {
						map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					}
					map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			case "d":
				if (p.getyLoc()< map[p.getyLoc()].length -1)
				{
					if(map[p.getxLoc()][p.getyLoc() + 1].isRoom()) {
						map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					}
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1)
				{
					if(map[p.getxLoc()+1][p.getyLoc()].isRoom()) {
						map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					}
					map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "a":
				if (p.getyLoc() > 0)
				{
					if(map[p.getxLoc()][p.getyLoc()-1].isRoom()) {
						map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					}
					map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			default:
				break;

		}
		return true;
	}

	//In order to enter the winningRoom and win, a player must first obtain the key
	public void setKey(boolean hasKey){
		this.hasKey = hasKey;
	}

	public boolean getKey(){
		return this.hasKey;
	}


}
