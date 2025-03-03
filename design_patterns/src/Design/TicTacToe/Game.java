package Design.TicTacToe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {

        public Board board;
        public Player player1;
        public Player player2;

        public void initializeGame(){
            player1 = new Player(new PlayerSymbolO(), "Kritik");
            player2 = new Player(new PlayingSymbolX(), "Raj");
            board = new Board(3);
        }

        public void startGame(){

            Queue<Player> queue = new LinkedList<>();
            queue.add(player1);
            queue.add(player2);

            while(true){
                Player currentPlayer = queue.peek();

                System.out.println("Player turn " + currentPlayer.name + " symbol = " + currentPlayer.playingSymbol.symbol);

                Scanner inputScanner = new Scanner(System.in);
                String s = inputScanner.nextLine();

                String[] values = s.split(",");
                int inputRow = Integer.valueOf(values[0]);
                int inputColumn = Integer.valueOf(values[1]);

                boolean markMove = board.markPosition(inputRow, inputColumn, currentPlayer.getPlayingSymbol());
                if(!markMove){
                    System.out.println("incorrect input or place already taken");
                    continue;
                }
                board.printBoard();
                if(isThereWinner(inputRow, inputColumn, currentPlayer.playingSymbol)){
                    System.out.println("Player = " + currentPlayer.name + "won");
                    break;
                }

                queue.remove();
                queue.add(currentPlayer);


            }


        }


    public boolean isThereWinner(int row, int column, PlayingSymbol pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<board.size;i++) {

            if(board.state[row][i] == null || board.state[row][i].symbol != pieceType.symbol) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<board.size;i++) {

            if(board.state[i][column] == null || board.state[i][column].symbol != pieceType.symbol) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<board.size;i++,j++) {
            if (board.state[i][j] == null || board.state[i][j].symbol != pieceType.symbol) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=board.size-1; i<board.size;i++,j--) {
            if (board.state[i][j] == null || board.state[i][j].symbol != pieceType.symbol) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }



}
