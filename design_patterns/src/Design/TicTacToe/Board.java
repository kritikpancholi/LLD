package Design.TicTacToe;

public class Board {

    public PlayingSymbol[][] state ;
    public int size;


    public Board(int size){
        this.size = size;
        this.state = new PlayingSymbol[size][size];
    }

    public boolean markPosition(int row, int column, PlayingSymbol playingSymbol) {

        if(row >= size || column >= size || row < 0 || column < 0 || state[row][column] != null) {
            return false;
        }
        state[row][column] = playingSymbol;
        return true;
    }

    public void printBoard(){
        for(int i = 0;i<size;i++){
            for(int j = 0 ;j<size;j++){
                if(state[i][j] == null){
                    System.out.print("   " + " | ");
                }else {
                System.out.print(state[i][j].symbol + " | ");
                }
            }
            System.out.println();
        }
    }

//    CheckMoveStrategy checkMoveStrategy = new CheckMoveStrategy();
//    GameChecks columnWinCheck = new ColumnWinCheckStrategy();
//    GameChecks diagonalWinCheck = new DiagonalWinStrategy();
//    GameChecks rowWinCheck = new RowWinCheckStrategy();

}
