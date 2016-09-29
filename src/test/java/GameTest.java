import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    public void firstPlayerShouldBeAskedForLocationAfterBoardDrawn() throws Exception {
        game.start();
        verify(player1).pickLocation();
    }

    @Test
    public void gameShouldRedrawBoardAfterPlayerPicksLocation() throws Exception {
        when(player1.pickLocation()).thenReturn("1");
        game.start();
        verify(board).redraw(player1, "1");
    }

}
