package Board;

import Rooms.KeyRoom;
import Rooms.Room;
import Rooms.WinningRoom;
import Rooms.Wall;

public class Board {
    private Room[][] board;

    public Board (Room[][] board){
        this.board= board;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                str = str + board[i][j];
            }
            str = str + "\n";
        }
        return str;
    }

    /*public void print(){
        String str = "";

        for ( int i = 0; i < board.length;i++){
            for(int j = 0; j<board[i].length; j++){
                str += board[i][j].toString();
            }
            str += "\n";
        }
        System.out.println(str);
    }*/


    public void generateMaze(){
        int x = (int)(Math.random()*board.length);
        int y = (int)(Math.random()*board.length);

        while(x==0 || x==board.length || y==0 || y==board.length){
            x = (int)(Math.random()*board.length);
            y = (int)(Math.random()*board.length);
        }
        int[][] wallList = new int[board.length][board.length];

        //3 == Cell part of the maze
        //2 == on wallList visited twice, true wall
        //1 == on wallList visited once
        //0 == not on wallList;

        wallList[x][y] = 3;
        wallList[x+1][y]= 1;
        wallList[x][y+1]=1;
        wallList[x-1][y]=1;
        wallList[x][y-1]=1;
        int wallCount = 1;

        while (wallCount > 0){
            int randomWall = (int)(Math.random()*wallCount);

            for (int i = 0; i < wallList.length; i++){
                for (int j = 0; j < wallList[i].length;j++){
                    if (wallList[i][j] == 1){
                        if(randomWall == 0){
                            wallList[i][j] = 3;
                            if(i < wallList.length-1) {
                                wallList[i+1][j]++;
                            }
                            if(j < wallList.length-1) {
                                wallList[i][j+1]++;
                            }
                            if(i > 1) {
                                wallList[i-1][j]++;
                            }
                            if(j > 1) {
                                wallList[i][j-1]++;
                            }
                        }
                        else{
                            randomWall--;
                        }

                    }
                }
            }

            //check if there are still walls in the list
            wallCount = 0;
            for ( int i = 0; i < wallList.length; i++)
            {
                for ( int j = 0; j < wallList[i].length; j++)
                {
                    if(wallList[i][j] == 1){
                        wallCount++;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[x].length; j++)
            {
                if(wallList[i][j] == 2) {
                    board[i][j] = new Wall(i, j);
                }
                else{
                    board[i][j] = new Room(i, j);
                }
            }
        }



    }


    public void createSpecialRooms(){
        int x = (int)(Math.random()*board.length);
        int y = (int)(Math.random()*board.length);
        board[x][y] = new WinningRoom(x, y);

        int x2 = (int) (Math.random() * board.length);
        int y2 = (int) (Math.random() * board.length);

        while(x == x2 && y ==y2) {
            x2 = (int) (Math.random() * board.length);
            y2 = (int) (Math.random() * board.length);
        }

        board[x2][y2] = new KeyRoom(x2, y2);
    }
}
