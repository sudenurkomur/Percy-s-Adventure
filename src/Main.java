import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import enigma.console.TextAttributes;
import java.awt.Color;

public class Main {

    public static enigma.console.Console cn = Enigma.getConsole("Mouse and Keyboard");

    public static void main(String[] args) {

        cn.getTextWindow().setCursorPosition(1,0);
        cn.getTextWindow().output("-- WELCOME TO THE MAZE GAME --");
        System.out.println();

        //start the game

    }
}

// işlemleri map map gerçekleştireceğiz
//enigmayı hallet
//map field çevir