import enigma.console.Console;
import enigma.console.TextAttributes;

import java.awt.*;

public class MapTwo implements MapTwoInterface {

    public static enigma.console.Console cn;
    public static void consoleClear(Console cn) {
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 120; j++) {
                cn.getTextWindow().output(j, i, ' ');
            }
            System.out.println();
        }
    }

    public static void drawSquare() {

        String tridentEmoji ="🔱";
        TextAttributes cyan = new TextAttributes(Color.cyan,Color.darkGray);
        cn.getTextWindow().setTitle(String.valueOf(""));
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
}