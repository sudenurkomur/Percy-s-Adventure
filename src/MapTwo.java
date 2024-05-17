import enigma.console.TextAttributes;
import enigma.core.Enigma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
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

        for(int i = 6; i <15; i++){

            numbers[i][i] = 6;
        }
        for(int i = 0; i <1; i++){

            numbers[19+i][19] = 6;
        }
    }


    public void startCall() throws InterruptedException, IOException {

        Board(60,60);
        Door(numbers);
        drawSquare(numbers);
        generateRockForMap(numbers);
        generateStatueForMap(numbers);
        generateTreeForMap(numbers);
        generateGhostForMap(numbers);
        enemyFollow(numbers);
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
    public void generateStatueForMap(int[][] numbers){
        for(int i = 6; i <15; i++){

            numbers[i][45] = 3;
        }
        for(int i = 0; i <9; i++){

            numbers[5][29+i] = 3;
        }
        for(int i = 0; i <9; i++){

            numbers[7][29+i] = 3;
        }
        for(int i = 0; i <9; i++){

            numbers[9][29+i] = 3;
        }
    }

    public void generateGhostForMap(int[][] numbers){

            numbers[3][3] = 7;
            numbers[20][50] = 7;
            numbers[23][45] = 7;

    }

    public void enemyFollow(int[][] numbers){

        numbers[20][55] = 8;
        numbers[22][53] = 10;

    }

    public void generateTreeForMap(int[][] numbers){

        for(int i = 0; i <20; i=i+2){

            numbers[23][5+i] = 4;
        }
        for(int i = 0; i <20; i=i+2){

            numbers[25][5+i] = 4;
        }
        for(int i = 0; i <20; i=i+2){

            numbers[21][5+i] = 4;
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
        TextAttributes red = new TextAttributes(Color.red);
        TextAttributes green = new TextAttributes(Color.green);
        TextAttributes yellow = new TextAttributes(Color.yellow);
        String medusaEmoji = "\uD83E\uDD87";
        String ghostEmoji = "\uD83D\uDC7B";
        String percy ="\uD83C\uDFC3";
        String kerberosEmoji = "\uD83D\uDC09";
        char ust = '\u23E9'; // Üst kısım
        char dag = '\u26F0'; // Unicode kodu: ⛰
        char heartEmoji = '\u2764';
        cn.getTextWindow().setCursorPosition(70, 8);
        System.out.print("Score: ");
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
                 else if(numbers[i][j] == 3){        //statue
                     cn.getTextWindow().setCursorPosition(j, i);
                     cn.getTextWindow().output(heartEmoji,red);
                 }
                 else if(numbers[i][j] == 7){        //ghost
                     cn.getTextWindow().setCursorPosition(j, i);
                     cn.getTextWindow().output(ghostEmoji,yellow);
                 }
                else if(numbers[i][j] == 5){        //karakter
                    cn.getTextWindow().setCursorPosition(j, i);
                    cn.getTextWindow().output(percy);
                }
                else if(numbers[i][j] == 6){        //rock
                    cn.getTextWindow().setCursorPosition(j, i);
                    cn.getTextWindow().output(dag);
                }
                 else if(numbers[i][j] == 4){        //tree
                     cn.getTextWindow().setCursorPosition(j, i);
                     cn.getTextWindow().output("#",green);
                 }
                else if(numbers[i][j] == 2){        //bomba
                    cn.getTextWindow().setCursorPosition(j, i);
                    cn.getTextWindow().output("+",blue);
                }
                 else if(numbers[i][j] == 8){        //kerberos
                     cn.getTextWindow().setCursorPosition(j, i);
                     cn.getTextWindow().output(medusaEmoji);
                 }
                 else if(numbers[i][j] == 10){        //medusa
                     cn.getTextWindow().setCursorPosition(j, i);
                     cn.getTextWindow().output(kerberosEmoji);
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

    public void Mouse(int[][] numbers) throws InterruptedException, IOException {

        int score=0;
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
        int counter=0;
        while(true)
        {
            Menu.cn.getTextWindow().setCursorPosition(plusX,plusY);
            Menu.cn.getTextWindow().output(" ");

            if(keypr==1)
            {
                counter++;
                if(rkey==KeyEvent.VK_UP && plusY>0&& numbers[plusY-1][plusX] == 0 ) {
                    plusY--;
                    Score scr =new Score();
                    cn.getTextWindow().setCursorPosition(70, 8);
                    score=scr.calculateScore(score,5);
                    System.out.print("Score: " + score);
                    if(counter % 3==0){
                        Medusa mds=new Medusa();
                        mds.generateRandomMedusa(numbers);
                        boardDisplay(numbers,60,60);
                        cn.getTextWindow().setCursorPosition(70, 8);
                        score=scr.calculateScore(score,0);
                        System.out.print("Score: " + score);
                    }
                }
                else if(rkey==KeyEvent.VK_DOWN && plusY>0 && numbers[plusY+1][plusX] == 0 && plusY!= 26 ) {
                    plusY++;
                    Score scr =new Score();
                    cn.getTextWindow().setCursorPosition(70, 8);
                    score=scr.calculateScore(score,3);
                    System.out.print("Score: " + score);
                    if(counter % 5==0){
                    Kerberos mds=new Kerberos();
                    mds.generateRandomKerberos(numbers);
                        cn.getTextWindow().setCursorPosition(70, 8);
                        score=scr.calculateScore(score,0);
                        System.out.print("Score: " + score);
                    }
                }
                else if(rkey==KeyEvent.VK_RIGHT && plusY>0 && numbers[plusY][plusX+1] == 0 && plusX!= 60 && numbers[plusY][plusX+1] != -1 ) {
                    plusX++;
                    Score scr =new Score();
                    cn.getTextWindow().setCursorPosition(70, 8);
                    score=scr.calculateScore(score,3);
                    System.out.print("Score: " + score);
                    if(counter % 5==0){
                        Medusa mds=new Medusa();
                        mds.generateRandomMedusa(numbers);
                        cn.getTextWindow().setCursorPosition(70, 8);
                        score=scr.calculateScore(score,0);
                        System.out.print("Score: " + score);
                    }
                }
                else if(rkey==KeyEvent.VK_LEFT && plusY>0&& numbers[plusY][plusX-1] == 0 && numbers[plusX+1][plusY] != -1 &&plusX!= 60 ) {
                    plusX--;
                    Score scr =new Score();
                    cn.getTextWindow().setCursorPosition(70, 8);
                    score=scr.calculateScore(score,5);
                    System.out.print("Score: " +score);
                    if(counter % 3==0){
                        Kerberos mds=new Kerberos();
                        mds.generateRandomKerberos(numbers);
                        cn.getTextWindow().setCursorPosition(70, 8);
                        score=scr.calculateScore(score,0);
                        System.out.print("Score: " +score);
                    }
                }
                else if(rkey==KeyEvent.VK_SPACE && plusY>0 && numbers[plusY][plusX-1] == 0 && plusX!= 60 && plusY!= 27  && numbers[plusY][plusX+1] != -1) {
                    numbers[plusY][plusX-1] =2;
                    Score scr =new Score();
                    cn.getTextWindow().setCursorPosition(70, 8);
                    score=scr.calculateScore(score,10);
                    System.out.print("Score: " +score);
                    boardDisplay(numbers,60,60);
                }
                else if((plusY==25 || plusY==26) && (plusX== 58 || plusX== 57)) {
                    Score scr =new Score();
                    cn.getTextWindow().setCursorPosition(70, 8);
                    score=scr.calculateScore(score,100);
                    System.out.print("Score: " +score);
                    consoleClear(cn);
                    ScoreTable scoreTable =new ScoreTable(1,score);
                }
                boardDisplay(numbers,60,60);
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

