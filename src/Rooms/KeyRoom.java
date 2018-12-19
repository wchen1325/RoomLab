package Rooms;

import Game.Runner;
import People.Person;

public class KeyRoom extends Room{
    private int keyTaken = 0;
    public KeyRoom (int x, int y){
        super(x, y);
    }

    @Override
    public void enterRoom(Person x){
        System.out.println("YOU HAVE OBTAINED A GOLDEN KEY!");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        x.setKey (true);
    }

    //returns "K" when key not taken, "P" when player is in this location, and "▒"(normal room) when key is taken.
    public String toString(){
        if (!(occupant== null)){
            keyTaken++;
            return "P ";
        }
        else {
            if(keyTaken>0) {
                return "▒";
            }
            else{
                return "K ";
            }
        }
    }

}
