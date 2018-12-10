package Rooms;

import Game.Runner;

public class Wall extends Room{

    public Wall(int x, int y){
        super(x, y);
    }

    public void enterRoom(){
        System.out.println("That's a wall!");
    }

    public String toString(){
        return "█ ";
    }
}