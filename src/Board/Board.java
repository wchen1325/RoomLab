package Board;

import People.Person;
import Rooms.KeyRoom;
import Rooms.Room;
import Rooms.WinningRoom;
import Rooms.Wall;

public class Board {
    private Room[][] board;
    private int wallList[][];
    private boolean mapNotReveal[][];

    public Board (Room[][] board){
        this.board= board;
        mapNotReveal= new boolean[board.length][board.length];
    }

    public String toString(Person player1) {
        mapReveal(player1);
        String str = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(mapNotReveal[i][j]==false){
                    str = str + "  ";
                }
                else {
                    str = str + board[i][j];
                }
            }
            str = str + "\n";
        }
        return str;
    }

    public void mapReveal(Person p){
        mapNotReveal[p.getxLoc()][p.getyLoc()]= true;
        mapNotReveal[p.getxLoc()+1][p.getyLoc()]= true;
        mapNotReveal[p.getxLoc()-1][p.getyLoc()]= true;
        mapNotReveal[p.getxLoc()][p.getyLoc()+1]= true;
        mapNotReveal[p.getxLoc()][p.getyLoc()-1]= true;
        mapNotReveal[p.getxLoc()+1][p.getyLoc()+1]= true;
        mapNotReveal [p.getxLoc()-1][p.getyLoc()-1]= true;
        mapNotReveal[p.getxLoc()+1][p.getyLoc()-1]= true;
        mapNotReveal[p.getxLoc()-1][p.getyLoc()+1]= true;
    }

    public void generateMaze(){
        wallList = new int[board.length][board.length];

        //3 == Cell marked
        //2 == Cell not marked
        //1 == walls that turn into cells
        //0 == walls

        for (int i = 1; i <= wallList.length - 2; i = i = i+2){
            for (int j = 1; j <= wallList.length - 2; j = j+2){
                wallList[i][j] = 2;
            }
        }

        wallList[1][1] = 3;
        int x = 1;
        int y = 1;

        //[0] top, [1] down, [2] left, [3] right
        //0 = not exist, 1 = exist
        int cellUnmarked = 1;
        while(cellUnmarked>0) {
            int[] directions = {1, 1, 1, 1};
            if (y == 1) {
                directions[2] = 0;
            }
            if (y == wallList.length - 2) {
                directions[3] = 0;
            }
            if (x == 1) {
                directions[0] = 0;
            }
            if (x == wallList.length - 2) {
                directions[1] = 0;
            }

            int random = (int)(Math.random()* 4);
            if(directions[random]== 1){
                if (random == 0 && wallList[x-2][y]==2){
                    wallList[x-2][y]=3;
                    wallList[x-1][y]=1;
                    x=x-2;
                }
                if (random == 1 && wallList[x+2][y]==2){
                    wallList[x+2][y]=3;
                    wallList[x+1][y]=1;
                    x=x+2;
                }
                if (random == 2 && wallList[x][y-2]==2){
                    wallList[x][y-2]=3;
                    wallList[x][y-1]=1;
                    y=y-2;
                }
                if (random == 3 && wallList[x][y+2]==2){
                    wallList[x][y+2]=3;
                    wallList[x][y+1]=1;
                    y=y+2;
                }
            }

            cellUnmarked = 0;
            for ( int i = 0; i < wallList.length; i++)
            {
                for ( int j = 0; j < wallList.length; j++)
                {
                    if(wallList[i][j] == 2){
                        cellUnmarked++;
                    }
                }
            }


            if(cellUnmarked>0 && availablePaths(x,y) == 0){
                for ( int i = 0; i < wallList.length; i++)
                {
                    for ( int j = 0; j < wallList.length; j++)
                    {
                        if(wallList[i][j] == 3 && availablePaths(i,j)>0){
                            x = i;
                            y = j;
                        }
                    }
                }
            }


        }


        //build the board base on the wallList
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if(wallList[i][j] == 0) {
                    board[i][j] = new Wall(i, j);
                }
                else{
                    board[i][j] = new Room(i, j);
                }
            }
        }

    }

    public int availablePaths(int x, int y){
        int availablePaths = 4;
        if ((y == 1) || wallList[x][y-2]==3) {
            availablePaths--;
        }
        if ((y == wallList.length - 2) || wallList[x][y+2]==3) {
            availablePaths--;
        }
        if ((x == 1) || wallList[x-2][y]==3) {
            availablePaths--;
        }
        if ((x == wallList.length - 2) ||  wallList[x+2][y]==3) {
            availablePaths--;
        }
        return availablePaths;
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
