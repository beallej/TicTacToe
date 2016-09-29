/**
 * Created by jbealle on 9/29/16.
 */
public class Main {

    public static void main(String[] args) {
        Board board = new Board(System.out);
        Player player1 = new Player();
        Game game = new Game(board, player1);
        game.start();
    }
}
