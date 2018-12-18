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
        System.out.println("You enter a plain old room, you found a golden key!");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        x.setKey (true);
    }

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
                return "K";
            }
        }
    }

}
