import java.awt.Color;

import enigma.console.TextAttributes;
import enigma.core.Enigma;
public class Board {
    public static enigma.console.Console cn = Enigma.getConsole("-- Welcome The MAZE --",120,28,20);
    TextAttributes red = new TextAttributes(Color.RED, Color.black);
    TextAttributes pink = new TextAttributes(Color.YELLOW);
    TextAttributes green = new TextAttributes(Color.MAGENTA);
    TextAttributes blue = new TextAttributes(Color.cyan);
    TextAttributes white = new TextAttributes(Color.white);

    private int[][] numbers;
    private int rows;
    private int cols;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        numbers = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    numbers[i][j] = ' ';
                }
        }
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
    public void display(){

        cn.getTextWindow().setCursorPosition(35,0);
        cn.getTextWindow().output("Board Seed:");
        cn.getTextWindow().setCursorPosition(48,0);
        cn.getTextWindow().output("4523");
        cn.getTextWindow().setCursorPosition(35,1);
        cn.getTextWindow().output("Round:");
        cn.getTextWindow().setCursorPosition(35,2);
        cn.getTextWindow().output("Score:");
        for(int i=0;i<50;i++) {
            cn.getTextWindow().setCursorPosition(35+i,3);
            cn.getTextWindow().output("- ");
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                cn.getTextWindow().setCursorPosition(j,i);
                if(numbers[i][j] == -1 )
                    cn.getTextWindow().output(' ');
                else if(numbers[i][j] == -2)
                    cn.getTextWindow().output('+',red);
                    //else if(numbers[i][j] == -4)
                    //cn.getTextWindow().output('.',red);
                else {
                    if(numbers[i][j]==1)
                        cn.getTextWindow().output(numbers[i][j]+"",pink);
                    if(numbers[i][j]==2)
                        cn.getTextWindow().output(numbers[i][j]+"",green);
                    if(numbers[i][j]==3)
                        cn.getTextWindow().output(numbers[i][j]+"",blue);
                    if(numbers[i][j]==4)
                        cn.getTextWindow().output(numbers[i][j]+"",white);
                }



            }
        }
    }
}
