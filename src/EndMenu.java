import enigma.console.Console;
import enigma.console.TextAttributes;
import enigma.core.Enigma;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EndMenu {

    public static enigma.console.Console cn= Enigma.getConsole("PERCY'S ADVENTURE" ,120,28,20);
    public static KeyListener klis;
    public static int keypr;   // key pressed?
    public static int rkey;    // key   (for press/release)

    public void callEnd (int enable, String name) throws InterruptedException, IOException {
        consoleClear(cn);
        if(enable==1){
            printMenuTitle(); //loser
        }
        else if(enable==2){
            printMenuTitle(name); //winner
        }
        else if(enable==3){
            printMenuTitle(3); //start from map
        }
        printMenuItems();
        drawSquare();
        Mouse();
        Thread.sleep(5000);
        printMenuTitle(3);
    }

    public void consoleClear(Console cn) {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 120; j++) {
                cn.getTextWindow().output(j, i, ' ');
            }
            System.out.println();
        }
    }

    public void printMenuTitle() {
        String tridentEmoji ="🔱";
        TextAttributes cyan = new TextAttributes(Color.cyan,Color.darkGray);
        cn.getTextWindow().setTitle(String.valueOf("PERCY'S ADVENTURE"));
        cn.getTextWindow().setCursorPosition(32,1);
        cn.getTextWindow().output(tridentEmoji + " LOSE IT " + tridentEmoji,cyan);
        System.out.println();
    }

    public void printMenuTitle(int menu) {
        String tridentEmoji ="🔱";
        TextAttributes cyan = new TextAttributes(Color.cyan,Color.darkGray);
        cn.getTextWindow().setTitle(String.valueOf("PERCY'S ADVENTURE"));
        cn.getTextWindow().setCursorPosition(30,1);
        cn.getTextWindow().output(tridentEmoji + " PERCY'S ADVENTURE " + tridentEmoji,cyan);
        System.out.println();
    }

    public void printMenuTitle(String name) {
        String tridentEmoji ="🔱";
        TextAttributes cyan = new TextAttributes(Color.cyan,Color.darkGray);
        cn.getTextWindow().setTitle(String.valueOf("PERCY'S ADVENTURE"));
        cn.getTextWindow().setCursorPosition(34,1);
        cn.getTextWindow().output(tridentEmoji + " WINNER "+ tridentEmoji,cyan);
        System.out.println();
    }

    public void printMenuItems() {

        TextAttributes cyan = new TextAttributes(Color.cyan,Color.darkGray);
        cn.getTextWindow().setTitle(String.valueOf("PERCY'S ADVENTURE"));
        cn.getTextWindow().setCursorPosition(30,7);
        cn.getTextWindow().output("DO YOU WANT TO PLAY?" ,cyan);
        System.out.println();

        cn.getTextWindow().setTitle(String.valueOf("PERCY'S ADVENTURE"));
        cn.getTextWindow().setCursorPosition(38,15);
        cn.getTextWindow().output("YES" ,cyan);
        System.out.println();


        cn.getTextWindow().setTitle(String.valueOf("PERCY'S ADVENTURE"));
        cn.getTextWindow().setCursorPosition(38,19);
        cn.getTextWindow().output("NO" ,cyan);
        System.out.println();
    }
    public void drawSquare() {

        int counter=0;
        for(int i=0;i<44;i=i+2){
            TextAttributes cyan = new TextAttributes(Color.WHITE,Color.WHITE);
            cn.getTextWindow().setCursorPosition(19+i,3);
            char tilda = '~';
            cn.getTextWindow().output(tilda +" ",cyan);
        }

        for(int i=0;i<20;i++){
            TextAttributes cyan = new TextAttributes(Color.WHITE,Color.WHITE);
            cn.getTextWindow().setCursorPosition(19,3+i);
            char tilda = '~';
            cn.getTextWindow().output(tilda +" ",cyan);
            counter++;
        }

        for(int i=0;i<42;i++){
            TextAttributes cyan = new TextAttributes(Color.WHITE,Color.WHITE);
            cn.getTextWindow().setCursorPosition(19+i,3+counter);
            char tilda = '~';
            cn.getTextWindow().output(tilda +" ",cyan);
        }

        for(int i=0;i<20;i++){
            TextAttributes cyan = new TextAttributes(Color.WHITE,Color.WHITE);
            cn.getTextWindow().setCursorPosition(61,4+i);
            char tilda = '~';
            cn.getTextWindow().output(tilda +" ",cyan);

        }
    }
    public void Mouse() throws InterruptedException, IOException {
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

        int plusX = 25,plusY = 15;
        char emoji = '\u26AA'; // ⚪ Unicode karakteri
        Menu.cn.getTextWindow().output(plusX, plusY, emoji);
        Thread.sleep(3);
        int enable=0;

        while(true)
        {
            Menu.cn.getTextWindow().setCursorPosition(plusX,plusY);
            Menu.cn.getTextWindow().output(" ");

            if(keypr==1)
            {
                if(rkey==KeyEvent.VK_UP && plusY>0) {
                    if((plusY-7) % 2 == 0) {
                        if (plusY > 7) plusY = plusY - 4;
                    }
                }
                else if(rkey==KeyEvent.VK_DOWN && plusY>0) {
                    if((plusY-7) % 2 == 0) {
                        if (plusY < 19) plusY = plusY + 4;
                    }
                }
                else if(rkey==KeyEvent.VK_ENTER && plusY>0) {

                    if (plusY ==15){
                        enable=1;
                        Map map=new Map(60,60);
                        map.callMap();
                    }

                    else if (plusY ==19){
                        enable=1;
                        System.exit(0);
                    }
                }
                keypr=0;
                rkey = KeyEvent.KEY_LOCATION_STANDARD;
            }
            Menu.cn.getTextWindow().setCursorPosition(plusX,plusY);
            if(enable==0){
                Menu.cn.getTextWindow().output(emoji);
            }
            Thread.sleep(3);
        }
    }
}
