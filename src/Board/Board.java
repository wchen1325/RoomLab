package Board;

import Rooms.KeyRoom;
import Rooms.Room;
import Rooms.WinningRoom;

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
    public void fillRoom(){
        for (int x = 0; x < board.length; x++)
        {
            for (int y = 0; y < board[x].length; y++)
            {
                board[x][y] = new Room(x,y);
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
