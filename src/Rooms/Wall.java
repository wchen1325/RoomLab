package Rooms;

import Game.Runner;
import People.Person;

public class Wall extends Room{

    public Wall(int x, int y){
        super(x, y);
    }

    //overrides methods from Room
    //Does not change player location because its a wall, only a line is printed to notify the player.
    public void enterRoom(Person x){
        System.out.println("That's a wall!");
    }

    public String toString(){
            return "▓";
    }

    //player cannot be in this position
    public boolean isRoom(){
        return false;
    }
}