package Rooms;

import Game.Runner;
import People.Person;

public class Wall extends Room{

    public Wall(int x, int y){
        super(x, y);
    }

    public void enterRoom(Person x){
        System.out.println("That's a wall!");
    }

    public String toString(){
            return "▓";
    }

    public boolean isRoom(){
        return false;
    }
}