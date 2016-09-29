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

    @Before
    public void setup(){
        board = mock(Board.class);
        game = new Game(board);
    }

    @Test
    public void shouldDrawBoardOnStart() throws Exception {
        game.start();
        verify(board).draw();
    }

}
