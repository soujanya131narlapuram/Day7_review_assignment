import java.util.Scanner;
public class TicTacToeGame {
    static  char[] board = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
    static int player=0;
    public static void emptyBoard() {
        System.out.println("Empty Board created");
        return;
    }
    public static void playerSelection(){
        System.out.println("Enter 1 for Player1 and 2 for player2");
        Scanner sc=new Scanner(System.in);
        player=sc.nextInt();
        System.out.println("Inputting x for player1 and o for player2");
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
    public static void main(String[] args){
        emptyBoard();
        playerSelection();
        System.out.println("Showing EmptyBoard");
        showBoard();
    }
}

