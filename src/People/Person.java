package People;

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

	public void setKey(boolean hasKey){
		this.hasKey = hasKey;
	}

	public boolean getKey(){
		return this.hasKey;
	}


}
