import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by jbealle on 9/29/16.
 */
public class GameTest {

    private Board board;
    private Game game;
    private Player player1;

    @Before
    public void setup(){
        board = mock(Board.class);
        player1 = mock(Player.class);
        game = new Game(board, player1);

    }

    @Test
    public void shouldDrawBoardOnStart() throws Exception {
        game.start();
        verify(board).draw();
    }

    @Test
    public void firstPlayerShouldMakeMoveAfterBoardDrawn() throws Exception {
        game.start();
        verify(player1).makeMove();
    }

}
