//package Design.TicTacToe;
//
//public class RowWinCheckStrategy implements  GameChecks{
//
//    @Override
//    public boolean check(int x, int y, Board board) {
//
//
//        for(int i = 0;i<3;i++){
//            if(board.state[x][i] == -1 || board.state[x][i] != board.state[x][y]){
//                return false;
//            }
//        }
//        return true;
//    }
//}
