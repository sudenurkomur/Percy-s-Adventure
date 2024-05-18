import enigma.console.Console;
import java.awt.event.KeyListener;
import java.io.IOException;

public interface MapTwoInterface {
    void generateRockForMap(int[][] numbers);
    void startCall() throws InterruptedException, IOException;
    static void drawSquare(int[][] numbers) { }
    void Board(int rows, int cols);
    void generateStatueForMap(int[][] numbers);
    void generateGhostForMap(int[][] numbers);
    void enemyFollow(int[][] numbers);
    void generateTreeForMap(int[][] numbers);
    void Door(int[][] numbers);
    void boardDisplay(int[][] numbers, int rows, int cols) throws InterruptedException;
    void Mouse(int[][] numbers) throws InterruptedException, IOException;

    // Getter and Setter methods
    Console getCn();
    void setCn(Console newCn);
    int[][] getNumbers();
    void setNumbers(int[][] numbers);
    int getRows();
    void setRows(int rows);
    int getCols();
    void setCols(int cols);
    KeyListener getKlis();
    void setKlis(KeyListener klis);
    int getKeypr();
    void setKeypr(int keypr);
    int getRkey();
    void setRkey(int rkey);
}

