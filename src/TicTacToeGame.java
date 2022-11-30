import java.util.Scanner;
public class TicTacToeGame {
    static  char[] board = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
    static char player=' ';

    static int position=0;
    static char input=' ';
    static char prev_player=' ';
    public static void emptyBoard() {
        System.out.println("Empty Board created");
        return;
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
        if(player=='P'){input='x';}
        else {input='o';}
        available=positionAvailability(position);
        if(available==1){board[position]=input;
        }else {
            makeMove();
            return;
        }
        showBoard();
    }
    public static void firstPlay() {
        Scanner sc = new Scanner(System.in);
        double headOrTail = Math.random();
        if (headOrTail > 0.5) {
            System.out.println("Heads: Player chance to start the game");
            player = 'P';
        } else {
            System.out.println("Tails: Computer chance to start the game");
            player = 'C';
        }
    }
    public static void main(String[] args){
        emptyBoard();
        System.out.println("Showing EmptyBoard");
        showBoard();
        firstPlay();
        makeMove();
    }
}

