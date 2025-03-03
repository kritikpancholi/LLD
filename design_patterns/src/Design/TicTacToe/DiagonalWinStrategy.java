//package Design.TicTacToe;
//
//public class DiagonalWinStrategy implements  GameChecks{
//
//    @Override
//    public boolean check(int x, int y, Board board) {
//        int a, b , c;
//        if( (x == 2 && y == 0) || (x == 0 && y == 2) || (x==1 && y==1)){
//            a = board.state[2][0];
//            b = board.state[1][1];
//            c = board.state[0][2];
//        }else if(x==y){
//            a = board.state[0][0];
//            b = board.state[1][1];
//            c = board.state[2][2];
//        }else {
//            return false;
//        }
//
//        return a == b && b == c;
//    }
//}
