/**
 * Created by jbealle on 9/29/16.
 */
public class Game {
    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void start() {
        board.draw();
    }
}
