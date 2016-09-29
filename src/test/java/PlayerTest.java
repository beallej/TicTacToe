import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.nio.Buffer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by jbealle on 9/29/16.
 */
public class PlayerTest {
    private Player player;
    private BufferedReader bufferedReader;
    @Before
    public void setup() {
        bufferedReader = mock(BufferedReader.class);
        player = new Player(bufferedReader);

    }
    @Test
    public void shouldGetInput() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1");
        assertEquals(player.pickLocation(), "1");
    }
}