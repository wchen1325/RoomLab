package Rooms;

import Game.Runner;
import People.Person;

public class KeyRoom extends Room{

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
        return "[K]";
    }

}
