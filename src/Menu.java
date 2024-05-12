import enigma.console.Console;
import enigma.core.Enigma;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import enigma.console.TextAttributes;
import javax.sound.sampled.*;


public class Menu {
    public static enigma.console.Console cn= Enigma.getConsole("PERCY'S ADVENTURE" ,120,28,20);
    public static KeyListener klis;
    public static int keypr;   // key pressed?
    public static int rkey;    // key   (for press/release)


    public Menu() throws InterruptedException{

        consoleClear();
        printMenuTitle();
        printMenuItems();
        drawSquare();
        playBackgroundMusic("/Users/sudenurkomur/Downloads/music.wav" );
        Mouse();

    }

    public static void consoleClear(){
        for (int i = 0; i < 28; i++) {
            for (int j = 0; j < 120; j++) {
                cn.getTextWindow().output(j, i, ' ');
            }
            System.out.println();
        }
    }
    public static void printMenuTitle() {
        String tridentEmoji ="🔱";
        TextAttributes cyan = new TextAttributes(Color.cyan,Color.darkGray);
        cn.getTextWindow().setTitle(String.valueOf("PERCY'S ADVENTURE"));
        cn.getTextWindow().setCursorPosition(30,1);
        cn.getTextWindow().output(tridentEmoji + " PERCY'S ADVENTURE " + tridentEmoji,cyan);
        System.out.println();
    }

    public static void printMenuItems() {

        TextAttributes cyan = new TextAttributes(Color.cyan,Color.darkGray);
        cn.getTextWindow().setTitle(String.valueOf("PERCY'S ADVENTURE"));
        cn.getTextWindow().setCursorPosition(38,7);
        cn.getTextWindow().output("START" ,cyan);
        System.out.println();

        cn.getTextWindow().setTitle(String.valueOf("PERCY'S ADVENTURE"));
        cn.getTextWindow().setCursorPosition(34,15);
        cn.getTextWindow().output("STORY OF PERCY" ,cyan);
        System.out.println();

        cn.getTextWindow().setTitle(String.valueOf("PERCY'S ADVENTURE"));
        cn.getTextWindow().setCursorPosition(36,11);
        cn.getTextWindow().output("HIGH SCORE" ,cyan);
        System.out.println();

        cn.getTextWindow().setTitle(String.valueOf("PERCY'S ADVENTURE"));
        cn.getTextWindow().setCursorPosition(39,19);
        cn.getTextWindow().output("QUİT" ,cyan);
        System.out.println();
    }
    public static void drawSquare() {

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
    public static void playBackgroundMusic(String musicLocation)
    {

        try
        {
            File musicPath = new File(musicLocation);

            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.addLineListener(event ->
                {
                    if(LineEvent.Type.STOP.equals(event.getType()))
                    {
                        clip.close();
                    }
                });
                //JOptionPane.showMessageDialog(null, "Press OK to stop playing");
            } else
            {
                System.out.println("Can't find file");
            }
        }

        catch(Exception ex)
        {
            ex.printStackTrace();
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
        Menu.cn.getTextWindow().addKeyListener(klis);

        int plusX = 25,plusY = 7;
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

                    if (plusY ==7){
                        enable=1;
                        MapOne map1 =new MapOne();
                        map1.MapOne(cn);
                    }

                    else if (plusY ==15){
                        enable=1;
                        GameStory gameStory =new GameStory();
                        new GameStory();

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