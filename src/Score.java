import enigma.core.Enigma;
import java.io.FileNotFoundException;

public class Score {

    private static enigma.console.Console cn = Enigma.getConsole("HIGH SCORE", 120, 28, 20);

    public Score() throws FileNotFoundException {
        // Constructor logic (if any) can be added here
    }

    public int calculateScore(int sum, int points) {
        sum = sum + points;
        return sum;
    }

    // Getter for 'cn'
    public static enigma.console.Console getCn() {
        return cn;
    }

    // Setter for 'cn'
    public static void setCn(enigma.console.Console newCn) {
        cn = newCn;
    }
}


