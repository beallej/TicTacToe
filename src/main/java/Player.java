import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by jbealle on 9/29/16.
 */
public class Player {

    private BufferedReader bufferedReader;
    private PrintStream printStream;

    public Player(BufferedReader bufferedReader, PrintStream printStream) {

        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public String pickLocation() {
        printStream.println("Pick a location");
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "1";
    }


}
