import enigma.console.Console;
import enigma.console.TextAttributes;
import enigma.core.Enigma;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class GameStory {
    public static Console cn= Enigma.getConsole("PERCY'S ADVENTURE" ,120,28,20);;

    public static KeyListener klis;
    public static int keypr;   // key pressed?
    public static int rkey;    // key   (for press/release)
    public GameStory() throws InterruptedException{

        consoleClear();
        drawSquare();
        Mouse();

    }
    public void consoleClear() {
        for (int i = 0; i < 28; i++) {
            for (int j = 0; j < 120; j++) {
                cn.getTextWindow().output(j, i, ' ');
            }
            System.out.println();
        }
    }
    public static void drawSquare() {

        String tridentEmoji ="🔱";
        TextAttributes cyan = new TextAttributes(Color.cyan,Color.darkGray);
        cn.getTextWindow().setTitle(String.valueOf("GAME STORY"));
        cn.getTextWindow().setCursorPosition(48,1);
        cn.getTextWindow().output(tridentEmoji + " GAME STORY " + tridentEmoji,cyan);
        System.out.println();

        int counter=0;
        for(int i=0;i<74;i=i+2){
            cn.getTextWindow().setCursorPosition(19+i,3);
            char tilda = '~';
            cn.getTextWindow().output(tilda +" ",cyan);

        }

        for(int i=0;i<20;i++){
            cn.getTextWindow().setCursorPosition(19,3+i);
            char tilda = '~';
            cn.getTextWindow().output(tilda +" ",cyan);
            counter++;
        }

        for(int i=0;i<74;i=i+2){
            cn.getTextWindow().setCursorPosition(19+i,3+counter);
            char tilda = '~';
            cn.getTextWindow().output(tilda +" ",cyan);

        }

        for(int i=0;i<20;i++){
            cn.getTextWindow().setCursorPosition(91,4+i);
            char tilda = '~';
            cn.getTextWindow().output(tilda +" ",cyan);

        }
    }

    public static void characterInt(int choose) throws InterruptedException {

        if(choose == 0){
            cn.getTextWindow().setCursorPosition(29,7);
            cn.getTextWindow().output("Percy is the demigod son of Poseidon.");
            cn.getTextWindow().setCursorPosition(30,8);
            cn.getTextWindow().output("Hp: He can die");
            cn.getTextWindow().setCursorPosition(30,9);
            cn.getTextWindow().output("Weapen: ");
            cn.getTextWindow().setCursorPosition(39,9);
            cn.getTextWindow().output("Water Ball");

        }

        if(choose == 1){
            cn.getTextWindow().setCursorPosition(29,11);
            cn.getTextWindow().output("Medusa was cursed because she fell in love with Poseidon.");
            cn.getTextWindow().setCursorPosition(30,12);
            cn.getTextWindow().output("Hp: She can die");
            cn.getTextWindow().setCursorPosition(30,13);
            cn.getTextWindow().output("Weapen: ");
            cn.getTextWindow().setCursorPosition(39,13);
            cn.getTextWindow().output("Snake Venom");

        }

        if(choose == 2){
            cn.getTextWindow().setCursorPosition(29,15);
            cn.getTextWindow().output("Kerberos, a three-headed dog, guarding Hades' underworld gate.");
            cn.getTextWindow().setCursorPosition(30,16);
            cn.getTextWindow().output("Hp: It can die");
            cn.getTextWindow().setCursorPosition(30,17);
            cn.getTextWindow().output("Weapen: ");
            cn.getTextWindow().setCursorPosition(39,17);
            cn.getTextWindow().output("Fire Ball");

        }

        if(choose == 3){
            cn.getTextWindow().setCursorPosition(30, 19);
            String word = "Escape from enemies and save the world. LET'S START! ";
            for (int i = 0; i < word.length(); i++) {
                Thread.sleep(80);
                cn.getTextWindow().output(word.charAt(i));
            }
            String mermanEmoji = "\uD83E\uDDDC\u200D";
            cn.getTextWindow().output(mermanEmoji);
            Thread.sleep(800);
        }


    }

    public static void Mouse()throws InterruptedException{

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
        cn.getTextWindow().addKeyListener(klis);

        int plusX = 25,plusY = 7;
        char emoji = '\u26AA'; // ⚪ Unicode karakteri
        cn.getTextWindow().output(plusX, plusY, emoji);
        Thread.sleep(3);
        int enable=0;

        while(true)
        {
            cn.getTextWindow().setCursorPosition(plusX,plusY);
            cn.getTextWindow().output(" ");

            if(keypr==1)
            {
                if(rkey==KeyEvent.VK_UP && plusY>0) {
                    if((plusY-7) % 2 == 0) {
                        if (plusY > 7) plusY = plusY - 4;
                    }
                }
                else if(rkey==KeyEvent.VK_DOWN && plusY>0) {
                    if((plusY-7) % 2 == 0) {
                        if (plusY <19) {
                            plusY = plusY + 4;
                        }

                    }
                }
                else if(rkey==KeyEvent.VK_ENTER && plusY>0) {

                    if (plusY == 7) {
                        playBackgroundMusic("/Users/sudenurkomur/Downloads/mouse.wav");
                        characterInt(0);
                    }
                    if (plusY == 11) {
                        playBackgroundMusic("/Users/sudenurkomur/Downloads/mouse.wav");
                        characterInt(1);
                    }
                    if (plusY == 15) {
                        playBackgroundMusic("/Users/sudenurkomur/Downloads/mouse.wav");
                        characterInt(2);
                    }
                    if (plusY ==19){
                        playBackgroundMusic("/Users/sudenurkomur/Downloads/mouse.wav");
                        characterInt(3);
                        enable=1;
                        Thread.sleep(70);
                        Map map=new Map(120,80);
                        map.callMap();
                    }

                }
                keypr=0;
                rkey = KeyEvent.KEY_LOCATION_STANDARD;
            }
            cn.getTextWindow().setCursorPosition(plusX,plusY);
            if(enable==0){
                cn.getTextWindow().output(emoji);
            }
            Thread.sleep(3);
        }
    }
    public static void playBackgroundMusic(String musicLocation) {
        try {
            File musicPath = new File(musicLocation);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.addLineListener(event -> {
                    if (LineEvent.Type.STOP.equals(event.getType())) {
                        clip.close();
                    }
                });
                // JOptionPane.showMessageDialog(null, "Press OK to stop playing");
            } else {
                System.out.println("Can't find file");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
