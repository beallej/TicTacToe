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
    private Player player2;

    @Before
    public void setup(){
        board = mock(Board.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        game = new Game(board, player1, player2);


    }

    @Test
    public void shouldDrawBoardOnStart() throws Exception {
        game.start();
        verify(board).draw();
    }

    @Test
    public void firstPlayerShouldBeAskedToMakeMoveAfterBoardDrawn() throws Exception {
        game.start();
        verify(player1).makeMove();
    }


    @Test
    public void player2ShouldMakeMoveAfterPlayer1(){
        game.start();
        verify(player2).makeMove();
    }

}
