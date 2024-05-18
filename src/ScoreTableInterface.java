import enigma.console.Console;
import java.io.IOException;

public interface ScoreTableInterface {
    void consoleClear(Console cn);
    void Sort(int end, int score) throws IOException, InterruptedException;
    void drawSquare();
}
