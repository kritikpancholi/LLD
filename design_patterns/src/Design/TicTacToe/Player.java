package Design.TicTacToe;

public class Player {

    PlayingSymbol playingSymbol;
    String name;

    public Player(PlayingSymbol playingSymbol,String name){
        this.playingSymbol = playingSymbol;
        this.name = name;
    }

    public PlayingSymbol getPlayingSymbol() {
        return playingSymbol;
    }
}
