package Board;

import Rooms.Room;

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

    public void print(){
        String str = "";

        for ( int i = 0; i < board.length;i++){
            for(int j = 0; j<board[i].length; j++){
                str += board[i][j].toString();
            }
            str += "\n";
        }
        System.out.println(str);
    }
}
