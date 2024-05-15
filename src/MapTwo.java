import enigma.console.TextAttributes;
import enigma.core.Enigma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.*;

public class MapTwo extends Map implements MapTwoInterface{

    public static enigma.console.Console cn = Enigma.getConsole("PERCY'S ADVENTURE" ,120,28,20);;
    private static int[][] numbers;
    private int rows;
    private int cols;
    public static KeyListener klis;
    public static int keypr;   // key pressed?
    public static int rkey;    // key   (for press/release)


    public MapTwo(int rows, int cols) {
        super(rows, cols);
    }

    public void generateRockForMap(int[][] numbers){
        Random rand = new Random();
        int int_random = 4;
        boolean flag=true;
        for(int i = 6; i <15; i++){

            numbers[i][i] = 6;
        }
        for(int i = 0; i <1; i++){

            numbers[19+i][19] = 6;
        }
    }


    public void startCall() throws InterruptedException {

        Board(60,60);
        Door(numbers);
        drawSquare(numbers);
        generateRockForMap(numbers);
        boardDisplay(numbers,60,60);
        Mouse(numbers);
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
        numbers[26][57]=-1;
        numbers[23][58]=-1;
        numbers[26][58]=-1;
        numbers[23][57]=-1;
    }

    public void boardDisplay(int[][] numbers, int rows,int cols) throws InterruptedException {

        cn.getTextWindow().setCursorPosition(0,0);
        TextAttributes cyan = new TextAttributes(Color.cyan,Color.darkGray);
        TextAttributes blue = new TextAttributes(Color.blue);
        String tridentEmoji ="🔱";
        String percy ="\uD83C\uDFC3";
        char ust = '\u23E9'; // Üst kısım
        char dag = '\u26F0'; // Unicode kodu: ⛰
        //cn.getTextWindow().setCursorPosition(0, 8);
        //cn.getTextWindow().output("a" +" ",cyan);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                 if(numbers[i][j] == -1){      //kapı
                    cn.getTextWindow().setCursorPosition(j, i);
                    cn.getTextWindow().output("-");
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
                    cn.getTextWindow().output("#");
                }
                else if(numbers[i][j] == 2){        //bomba
                    cn.getTextWindow().setCursorPosition(j, i);
                    cn.getTextWindow().output("+",blue);
                }
                else if(numbers[i][j] != 6 && numbers[i][j] != 5 &&numbers[i][j] != 1 &&  numbers[i][j] != 0){
                    numbers[i][j] = 0;
                    cn.getTextWindow().setCursorPosition(j, i);
                    cn.getTextWindow().output("9");
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

    public void Mouse(int[][] numbers)throws InterruptedException{
        klis=new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {
                if(keypr==0) {
                    keypr=1;
                    rkey=e.getKeyCode();
                }
            }
            public void keyReleased(KeyEvent e) {}
        };
        Menu.cn.getTextWindow().addKeyListener(klis);

        int plusX = 2,plusY = 2;
        char gulumseme = '\u263A'; // Unicode kodu: ☺
        cn.getTextWindow().setCursorPosition(plusX, plusY);
        System.out.println(gulumseme); // ☺
        Thread.sleep(3);
        int enable=0;

        while(true)
        {
            Menu.cn.getTextWindow().setCursorPosition(plusX,plusY);
            Menu.cn.getTextWindow().output(" ");

            if(keypr==1)
            {
                if(rkey==KeyEvent.VK_UP && plusY>0&& numbers[plusX][plusY-1] == 0) {
                    plusY--;
                }
                else if(rkey==KeyEvent.VK_DOWN && plusY>0 && numbers[plusX][plusY+1] == 0 && plusY!= 26) {
                    plusY++;
                }
                else if(rkey==KeyEvent.VK_RIGHT && plusY>0 && numbers[plusX+1][plusY] == 0 && plusX!= 60) {
                    plusX++;
                }
                else if(rkey==KeyEvent.VK_LEFT && plusY>0&& numbers[plusX-1][plusY] == 0 && numbers[plusX+1][plusY] != -1 &&plusX!= 60) {
                    plusX--;
                }
                else if(rkey==KeyEvent.VK_SPACE && plusY>0 && numbers[plusY][plusX-1] == 0 && plusX!= 60 && plusY!= 26) {
                    numbers[plusY][plusX-1] =2;
                    boardDisplay(numbers,60,60);
                }
                keypr=0;
                rkey = KeyEvent.KEY_LOCATION_STANDARD;
            }
            Menu.cn.getTextWindow().setCursorPosition(plusX,plusY);
            if(enable==0){
                cn.getTextWindow().output(gulumseme);
            }
            Thread.sleep(3);
        }
    }
}

