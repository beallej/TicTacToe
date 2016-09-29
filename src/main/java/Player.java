import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by jbealle on 9/29/16.
 */
public class Player {

    private BufferedReader bufferedReader;

    public Player(BufferedReader bufferedReader) {

        this.bufferedReader = bufferedReader;
    }

    public String pickLocation() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "1";
    }


}
