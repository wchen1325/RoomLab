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
        generateMaze();
        createAllSpecialRooms();
    }

    public Board (Room[][] Board, int Easy){
        this.board= Board;
        mapNotReveal= new boolean[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
            mapNotReveal[i][j]=true;
            }
        }
        generateMaze();
        createAllSpecialRooms();
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
        //4 = SpecialRoom
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


            if(cellUnmarked>0 && availablePaths(x,y,2,3) == 0){
                for ( int i = 0; i < wallList.length; i++)
                {
                    for ( int j = 0; j < wallList.length; j++)
                    {
                        if(wallList[i][j] == 3 && availablePaths(i,j,2,3)>0){
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

    public int availablePaths(int x, int y, int z,int cellType){
        int availablePaths = 4;
        if ((y == 1) || wallList[x][y-z]==cellType) {
            availablePaths--;
        }
        if ((y == wallList.length - 2) || wallList[x][y+z]==cellType) {
            availablePaths--;
        }
        if ((x == 1) || wallList[x-z][y]==cellType) {
            availablePaths--;
        }
        if ((x == wallList.length - 2) ||  wallList[x+z][y]==cellType) {
            availablePaths--;
        }
        return availablePaths;
    }

    public int[] locatePosition(){
        wallList[1][1]=4;
        int count = 0;
        for (int i = 1; i < board.length-1; i++) {
            for (int j = 1; j < board.length-1; j++) {
                if(availablePaths(i, j, 1,0)==1 && !(wallList[i][j] == 4) &&wallList[i][j]==3){
                    count++;
                }
            }
        }
        int random = (int)((count*Math.random()));

        int x = 0;
        int y = 0;
        for (int i = 1; i < board.length-1; i++) {
            for (int j = 1; j < board[i].length-1; j++) {
                if (availablePaths(i, j, 1,0) == 1 && random ==0 && !(wallList[i][j] == 4)&&wallList[i][j]==3) {
                    x = i;
                    y = j;
                }
                else if(availablePaths(i, j, 1,0) == 1 && !(wallList[i][j] == 4)&&wallList[i][j]==3){
                    random--;
                }
            }
        }
        int values[]=new int[2];
        values[0]=x;
        values[1]=y;
        return values;
    }

    public void createRoom(int[] position,Room specialRoom){
        board[position[0]][position[1]] = specialRoom;
        wallList[position[0]][position[1]]= 4;
    }

    public void createAllSpecialRooms(){
        int position[] = locatePosition();
        int x = position[0];
        int y = position[1];
        createRoom(position, new KeyRoom(x,y));

        int tempPosition[] = locatePosition();
        position[0] = tempPosition[0];
        position[1] = tempPosition[1];
        x = position[0];
        y = position[1];
        createRoom(position, new WinningRoom(x,y));
    }
}
