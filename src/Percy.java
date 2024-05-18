import enigma.console.Console;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Percy extends Person {
    private KeyListener klis;
    private int keypr;   // key pressed?
    private int rkey;    // key (for press/release)

    public Percy(int startX, int startY, int[][] map, Console cn) {
        super(startX, startY, map, cn);
        initKeyListener();
    }

    private void initKeyListener() {
        klis = new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {
                if (keypr == 0) {
                    keypr = 1;
                    rkey = e.getKeyCode();
                }
            }
            public void keyReleased(KeyEvent e) {}
        };
        cn.getTextWindow().addKeyListener(klis);
    }

    public void moveUp() {
        if (y > 0 && map[y - 1][x] == 0) {
            y--;
        }
    }

    public void moveDown() {
        if (y < map.length - 1 && map[y + 1][x] == 0) {
            y++;
        }
    }

    public void moveLeft() {
        if (x > 0 && map[y][x - 1] == 0) {
            x--;
        }
    }

    public void moveRight() {
        if (x < map[0].length - 1 && map[y][x + 1] == 0) {
            x++;
        }
    }

    public void dropBomb() {
        if (map[y][x] == 0) {
            map[y][x] = 2; // Assume 2 represents a bomb
        }
    }

    public void processInput() {
        if (keypr == 1) {
            switch (rkey) {
                case KeyEvent.VK_UP:
                    moveUp();
                    break;
                case KeyEvent.VK_DOWN:
                    moveDown();
                    break;
                case KeyEvent.VK_LEFT:
                    moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    moveRight();
                    break;
                case KeyEvent.VK_SPACE:
                    dropBomb();
                    break;
            }
            keypr = 0;
            rkey = KeyEvent.KEY_LOCATION_UNKNOWN;
        }
    }

    public void display() {
        cn.getTextWindow().setCursorPosition(x, y);
        cn.getTextWindow().output('\u263A'); // Smiley face for Percy
    }
}
