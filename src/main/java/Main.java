/**
 * Created by jbealle on 9/29/16.
 */
public class Main {

    public static void main(String[] args) {
        Board board = new Board(System.out);
        Game game = new Game(board);
        game.start();
    }
}
