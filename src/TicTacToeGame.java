import java.util.Random;
import java.util.Scanner;


public class TicTacToeGame {
    static  char[] board = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
    static int turn_count=0;
    static  int position=1;
    static char prev_player = ' ';
    static char player=' ';
    static boolean stop_condition=true;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the tic tac toy Game ");
            showBoard();
            firstPlay();
            while (stop_condition) {
                makeMove();
            }
            System.out.println("Do you want to play another game?enter (y/n)");
            char new_game=sc.next().charAt(0);
            if(new_game=='y'){
                for(int i=0;i<board.length;i++){
                    board[i]=' ';
                }
                turn_count=0;prev_player=' ';player=' ';stop_condition=true;
            }else {break;}
        }
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
    public static void firstPlay(){
        Scanner sc = new Scanner(System.in);
        double headOrTail = Math.random();
        if (headOrTail > 0.5) {
            System.out.println("Player chance to start the game");
            prev_player='o';
        } else {
            System.out.println("Its Computer chance to start the game");
            prev_player='x';
        }
    }
    public static int positionAvailability(int pos){
        if(board[pos]=='x' || board[pos]=='o'){
            System.out.println("position is filled, choose the position again");
            return 0;
        }else{ return 1;}
    }
    public static char checkWinner() {
        for (int possible_ways = 0; possible_ways < 8; possible_ways++) {
            String line = null;
            switch (possible_ways) {
                case 0:
                    line = "" + board[1] + board[2] + board[3];
                    break;
                case 1:
                    line = "" + board[4] + board[5] + board[6];
                    break;
                case 2:
                    line = "" + board[7] + board[8] + board[9];
                    break;
                case 3:
                    line = "" + board[1] + board[4] + board[7];
                    break;
                case 4:
                    line = "" + board[2] + board[5] + board[8];
                    break;
                case 5:
                    line = "" + board[3] + board[6] + board[9];
                    break;
                case 6:
                    line = "" + board[1] + board[5] + board[9];
                    break;
                case 7:
                    line = "" + board[3] + board[5] + board[7];
                    break;
            }
            if (line.equals("xxx")) {
                System.out.println("Player with letter X has won");
                showBoard();
                return 'x';
            } else if (line.equals("ooo")) {
                System.out.println("Player with letter O has won");
                showBoard();
                return 'o';
            }
        }
        return 't';
    }

    public static int findComputerPosition(){
        int pos;
        Random random = new Random();
        while(true) {
            pos = random.nextInt(9) + 1;
            if (board[pos] == 'x' || board[pos] == 'o') {
                //pass
            } else {
                // checking the best position for computer
                if (board[2] == 'o' && board[3] == 'o' && board[1] != 'x' || board[4] == 'o' && board[7] == 'o' && board[1] != 'x'
                        || board[5] == 'o' && board[9] == 'o' && board[1] != 'x') {
                    return 1;
                } else if (board[1] == 'o' && board[3] == 'o' && board[2] != 'x' || board[5] == 'o' && board[8] == 'o' && board[2] != 'x') {
                    return 2;
                } else if (board[1] == 'o' && board[2] == 'o' && board[3] != 'x' || board[5] == 'o' && board[7] == 'o' && board[3] != 'x'
                        || board[6] == 'o' && board[9] == 'o' && board[3] != 'x') {
                    return 3;
                } else if (board[1] == 'o' && board[7] == 'o' && board[4] != 'x' || board[5] == 'o' && board[6] == 'o' && board[4] != 'x') {
                    return 4;
                } else if (board[4] == 'o' && board[6] == 'o' && board[5] != 'x' || board[2] == 'o' && board[8] == 'o' && board[5] != 'x'
                        || board[1] == 'o' && board[9] == 'o' && board[5] != 'x' || board[3] == 'o' && board[7] == 'o' && board[5] != 'x') {
                    return 5;
                } else if (board[3] == 'o' && board[9] == 'o' && board[6] != 'x' || board[4] == 'o' && board[5] == 'o' && board[6] != 'x') {
                    return 6;
                } else if (board[1] == 'o' && board[4] == 'o' && board[7] != 'x' || board[8] == 'o' && board[9] == 'o' && board[7] != 'x'
                        || board[5] == 'o' && board[3] == 'o' && board[7] != 'x') {
                    return 7;
                } else if (board[7] == 'o' && board[9] == 'o' && board[8] != 'x' || board[2] == 'o' && board[5] == 'o' && board[8] != 'x') {
                    return 8;
                } else if (board[7] == 'o' && board[8] == 'o' && board[9] != 'x' || board[3] == 'o' && board[6] == 'o' && board[9] != 'x'
                        || board[1] == 'o' && board[5] == 'o' && board[9] != 'x') {
                    return 9;
                }
                //These moves are to block the player
                else if (board[2] == 'x' && board[3] == 'x' && board[1] != 'o' || board[4] == 'x' && board[7] == 'x' && board[1] != 'o'
                        || board[5] == 'x' && board[9] == 'x' && board[1] != 'o') {
                    return 1;
                } else if (board[1] == 'x' && board[3] == 'x' && board[2] != 'o' || board[5] == 'x' && board[8] != 'x' && board[2] != 'o') {
                    return 2;
                } else if (board[1] == 'x' && board[2] == 'x' && board[3] != 'o' || board[5] == 'x' && board[7] == 'x' && board[3] != 'o'
                        || board[6] == 'x' && board[9] == 'x' && board[3] != 'o') {
                    return 3;
                } else if (board[1] == 'x' && board[7] == 'x' && board[4] != 'o' || board[5] == 'x' && board[6] == 'x' && board[4] != 'o') {
                    return 4;
                } else if (board[4] == 'x' && board[6] == 'x' && board[5] != 'o' || board[2] == 'x' && board[8] == 'x' && board[5] != 'o'
                        || board[1] == 'x' && board[9] == 'x' && board[5] != 'o' || board[3] == 'x' && board[7] == 'x' && board[5] != 'o') {
                    return 5;
                } else if (board[3] == 'x' && board[9] == 'x' && board[6] != 'o' || board[4] == 'x' && board[5] == 'x' && board[6] != 'o') {
                    return 6;
                } else if (board[1] == 'x' && board[4] == 'x' && board[7] != 'o' || board[8] == 'x' && board[9] == 'x' && board[7] != 'o'
                        || board[5] == 'x' && board[3] == 'x' && board[5] != 'o') {
                    return 7;
                } else if (board[7] == 'x' && board[9] == 'x' && board[8] != 'o' || board[2] == 'x' && board[5] == 'x' && board[8] != 'o') {
                    return 8;
                } else if (board[7] == 'x' && board[8] == 'x' && board[9] != 'o' || board[3] == 'x' && board[6] == 'x' && board[9] != 'o'
                        || board[1] == 'x' && board[5] == 'x' && board[9] != 'o') {
                    return 9;
                } else {
                    return pos;
                }

            }
        }
    }
    public static void makeMove(){
        int available;
        boolean iterator=true;
        Random rand=new Random();
        if(prev_player=='x'){
            position=findComputerPosition();
            while(iterator) {
                System.out.println("Computer selected Position=" + position);
                if (positionAvailability(position) == 0) {
                    position = rand.nextInt(9) + 1;
                } else {
                    iterator = false;
                }
            }
        }else {
            char dummy='x';
            System.out.println("Player " + dummy + ": enter the position (1-9):");
            Scanner sc = new Scanner(System.in);
            position = sc.nextInt();
        }
        available=positionAvailability(position);
        if(available==1){
            if(prev_player=='x'){player='o';}
            else {player='x';}
            board[position]=player;
            turn_count++;
            prev_player=player;
            char result=' ';
            if (turn_count >= 5) {
                result = checkWinner();
                if (result == 'x' || result == 'o') {
                    stop_condition=false;
                    return;
                }
            }
            if (turn_count == 9 && result == 't') {
                System.out.println("Game has been tied");
                stop_condition=false;
            }

        }else {return;}
        showBoard();
    }
}