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

    //Fill the building with normal rooms
    public void fillWall(){
        for (int x = 0; x < board.length; x++)
        {
            for (int y = 0; y < board[x].length; y++)
            {
                board[x][y] = new Wall(x,y);
            }
        }
    }

    public void generateMaze(){
        int x = (int)(Math.random()*board.length);
        int y = (int)(Math.random()*board.length);

        while(x=0 || x=board.length || y=0 || y=board.length){
            x = (int)(Math.random()*board.length);
            y = (int)(Math.random()*board.length);
        }
        int[][] wallList = new int[board.length][board.length];

        wallList[x+1][y]= 1;
        wallList[x][y+1]=1;
        wallList[x-1][y-1]=1;
        wallList[x][y-1]=1;

        boolean containsWall = true;
        while (containsWall = true){

            
            //start here



            containsWall = false;
            for (int i = 0; i < wallList.length; i++)
            {
                for (int j = 0; j < wallList[i].length; j++)
                {
                    if(wallList[i][j] == 1){
                        containsWall = true;
                    }
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
