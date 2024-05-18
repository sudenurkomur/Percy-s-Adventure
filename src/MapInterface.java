import enigma.console.Console;
import java.io.IOException;

public interface MapInterface {
    void consoleClear(Console cn);
    void callMap() throws InterruptedException, IOException;

    int getNumber(int row, int col);
    void setNumber(int row, int col, int number);

    int getRows();
    int getCols();

    Console getCn();
    void setCn(Console newCn);
}
