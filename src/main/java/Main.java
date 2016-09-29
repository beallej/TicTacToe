import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by jbealle on 9/29/16.
 */
public class Main {

    public static void main(String[] args) {
        Board board = new Board(System.out);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Player player1 = new Player(reader, System.out, board);
        Player player2 = new Player(reader, System.out, board);
        Game game = new Game(board, player1, player2);
        game.start();
    }
}
