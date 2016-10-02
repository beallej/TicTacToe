/**
 * Created by jbealle on 9/29/16.
 */
public class Game {
    private Board board;
    private Player player1;
    private Player player2;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        board.draw();
        Player currentPlayer = player1;
        Player nextPlayer = player2;
        while(!board.isFull()) {
            currentPlayer.makeMove();
            Player temp = currentPlayer;
            currentPlayer = nextPlayer;
            nextPlayer = temp;
        }

    }


}
