//package Design.TicTacToe;
//
//public class ColumnWinCheckStrategy implements GameChecks {
//
//    @Override
//    public  boolean check(int x, int y, Board board){
//        for(int i = 0;i<3;i++){
//            if(board.state[i][y] == null || board.state[i][y] != board.state[x][y] ){
//                return false;
//            }
//        }
//        return true;
//    }
//}
