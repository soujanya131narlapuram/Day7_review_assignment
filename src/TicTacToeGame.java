import java.util.Random;
import java.util.Scanner;
public class TicTacToeGame {
    static  char[] board = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
    static int player=0;

    static int position=0;
    static char input=' ';
    public static void emptyBoard() {
        System.out.println("Empty Board created");
        return;
    }
    public static void playerSelection(){
        System.out.println("Enter 1 for Player1 and 2 for player2");
        Scanner sc=new Scanner(System.in);
        player=sc.nextInt();
        System.out.println("Inputting x for player1 and o for player2");
        if(player==1){input='x';}
        else {input='o';}
    }
    public static void showBoard(){
        System.out.println(" _ _ _");
        for (int i = 1; i <=9; i++){
            if (i % 3 == 0) {
                System.out.println("|"+board[i]+"|");
            }else {
                System.out.print("|"+board[i]);
            }
        }
    }

    public static int positionAvailability(int pos){
        if(board[pos]=='x' || board[pos]=='o'){
            System.out.println("position is filled, choose the position again");
            return 0;
        }else{ return 1;}
    }

    public static void makeMove(){
        int available;
        System.out.println("Player " + player + ": enter the position (1-9):");
        Scanner sc = new Scanner(System.in);
        position = sc.nextInt();
        available=positionAvailability(position);
        if(available==1){board[position]=input;
        }else {
            makeMove();
            return;
        }
        showBoard();
    }
    public static void main(String[] args){
        emptyBoard();
        System.out.println("Showing EmptyBoard");
        showBoard();
        for(int turn=0;turn<9;turn++){
            playerSelection();
            makeMove();
        }
    }
}

