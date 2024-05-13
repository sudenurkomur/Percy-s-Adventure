import enigma.console.Console;
import enigma.console.TextAttributes;
import enigma.core.Enigma;
import java.util.Random;
import java.awt.*;

public class MapTwo extends Map implements MapTwoInterface{

    public static enigma.console.Console cn = Enigma.getConsole("PERCY'S ADVENTURE" ,120,28,20);;
    private static int[][] numbers;
    private int rows;
    private int cols;

    public MapTwo(int rows, int cols) {
        super(rows, cols);
    }
    public void generateRockForMap(int[][] numbers){
        Random rand = new Random();
        int int_random = rand.nextInt(5, 15);
        int_random=3;
        for (int i = 0; i <int_random; i++) {
            int int_random_replace_X = rand.nextInt(60);
            int int_random_replace_y = rand.nextInt(60);
            if(numbers[int_random_replace_X][int_random_replace_y] == 0){  //rock için yerleştirme
                numbers[int_random_replace_X][int_random_replace_y] = 6;
            }
            else{
                while(numbers[int_random_replace_X][int_random_replace_y] != 0 ){
                    int_random_replace_X = rand.nextInt(60);
                    int_random_replace_y = rand.nextInt(60);
                    if(numbers[int_random_replace_X][int_random_replace_y] == 0){  //rock için yerleştirme
                        numbers[int_random_replace_X][int_random_replace_y] = 6;
                    }
                }
            }
            cn.getTextWindow().setCursorPosition(50,60);
            System.out.println(int_random_replace_X + "a" + i +" "+ int_random_replace_y);
            //numbers[118][79] = 6;
        }

    }


    public void startCall() {

        Board(60,60);
        Door(numbers);
        drawSquare(numbers);
        generateRockForMap(numbers);
        boardDisplay(numbers,60,60);
    }



    public static void drawSquare(int[][] numbers) {

        String tridentEmoji ="🔱";
        TextAttributes cyan = new TextAttributes(Color.cyan,Color.darkGray);
        cn.getTextWindow().setTitle(String.valueOf("HADES'S HOUSE"));
        cn.getTextWindow().setCursorPosition(0,0);

        for (int i = 0; i < 60; i++) {
            numbers[i][0] = 1;        // Üst kenar
            numbers[i][59] = 1;       // Alt kenar
        }
        for (int i = 0; i < 60; i++) {
            numbers[0][i] = 1;        // Sol kenar
            numbers[59][i] = 1;       // Sağ kenar
        }
    }
    public void Board(int rows, int cols){

        numbers = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                numbers[i][j] = 0;
            }
        }
    }

    public void Door(int[][] numbers){

        numbers[1][2]=-1;
        numbers[1][4]=-1;
        numbers[4][2]=-1;
        numbers[2][2]=5;
        numbers[4][4]=-1;
        numbers[4][6]=-1;
        numbers[1][6]=-1;

    }
    public void boardDisplay(int[][] numbers, int rows,int cols){

        cn.getTextWindow().setCursorPosition(0,0);
        TextAttributes cyan = new TextAttributes(Color.cyan,Color.darkGray);
        String tridentEmoji ="🔱";
        String percy ="\uD83C\uDFC3";
        //cn.getTextWindow().setCursorPosition(0, 8);
        //cn.getTextWindow().output("a" +" ",cyan);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(numbers[i][j] == 0){
                    cn.getTextWindow().setCursorPosition(i,j);
                    cn.getTextWindow().output("k"+ "");
                }
                 else if(numbers[i][j] == -1){      //kapı
                    cn.getTextWindow().setCursorPosition(j, i);
                    cn.getTextWindow().output(tridentEmoji);
                 }
                else if(numbers[i][j] == 1){        //duvar
                    char tilda = '~';
                    cn.getTextWindow().setCursorPosition(j, i);
                    cn.getTextWindow().output(tilda +"",cyan);
                }
                else if(numbers[i][j] == 5){        //karakter
                    cn.getTextWindow().setCursorPosition(j, i);
                    cn.getTextWindow().output(percy);
                }
                else if(numbers[i][j] == 6){        //rock
                    cn.getTextWindow().setCursorPosition(j, i);
                    cn.getTextWindow().output("a");
                }
            }
        }
    }

    public int getNumber(int row, int col, int number) {
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
}

