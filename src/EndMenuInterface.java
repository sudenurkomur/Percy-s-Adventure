import enigma.console.Console;

import java.awt.event.KeyListener;
import java.io.IOException;

public interface EndMenuInterface {
    void callEnd(int enable, String name) throws InterruptedException, IOException;
    void consoleClear(Console cn);
    void printMenuTitle();
    void printMenuTitle(int menu);
    void printMenuTitle(String name);
    void printMenuItems();
    void drawSquare();
    void Mouse() throws InterruptedException, IOException;

    Console getCn();
    void setCn(Console newCn);
    KeyListener getKlis();
    void setKlis(KeyListener newKlis);
    int getKeypr();
    void setKeypr(int newKeypr);
    int getRkey();
    void setRkey(int newRkey);
}
