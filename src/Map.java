import enigma.console.Console;
import enigma.core.Enigma;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Map {
    private enigma.console.Console cn = Enigma.getConsole("-- Welcome The MAZE --",120,28,20);
    private int[][] numbers;
    private int rows;
    private int cols;

    public Map(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }


    public void consoleClear(Console cn) {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 120; j++) {
                cn.getTextWindow().output(j, i, ' ');
            }
            System.out.println();
        }
    }
    public void callMap() throws InterruptedException, IOException {
        consoleClear(cn);
        MapTwo map2= new MapTwo(rows,cols);
        map2.startCall();
    }

    public int getNumber(int row, int col) {
        return numbers[row][col];
    }

    public void setNumber(int row, int col, int number) {

        numbers[row][col] = number;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public enigma.console.Console getCn() {
        return cn;
    }

    public void setCn(enigma.console.Console newCn) {
        cn = newCn;
    }

}
