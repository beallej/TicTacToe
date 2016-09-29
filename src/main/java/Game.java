/**
 * Created by jbealle on 9/29/16.
 */
public class Game {
    private Board board;
    private Player player1;

    public Game(Board board, Player player1) {
        this.board = board;
        this.player1 = player1;
    }

    public void start() {
        board.draw();
        int location = player1.pickLocation();
        board.redraw(player1, location);

    }
}
