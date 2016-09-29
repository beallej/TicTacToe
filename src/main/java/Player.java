import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by jbealle on 9/29/16.
 */
public class Player {

    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Board board;

    public Player(BufferedReader bufferedReader, PrintStream printStream, Board board) {

        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
        this.board = board;
    }

    public String pickLocation() {
        printStream.println("Pick a location");
        String locationChosen = "";
        while (!board.locationIsValid(locationChosen)){
            try {
                locationChosen = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return locationChosen;
    }


}
