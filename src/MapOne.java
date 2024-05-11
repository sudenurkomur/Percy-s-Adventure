import enigma.console.TextAttributes;
import enigma.core.Enigma;

import java.awt.*;

public class MapOne implements MapOneInterface {
    // MapOne sınıfının işlevleri buraya eklenecek

    public static enigma.console.Console cn;
    public static void read() {
        cn = Enigma.getConsole("PERCY'S ADVENTURE" ,120,28,30);
        String tridentEmoji ="🔱";
        TextAttributes cyan = new TextAttributes(Color.cyan,Color.darkGray);
        cn.getTextWindow().setCursorPosition(30,1);
        cn.getTextWindow().output(tridentEmoji + " SUDEE " + tridentEmoji,cyan);



    }
}
