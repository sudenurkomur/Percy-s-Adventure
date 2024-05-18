import enigma.console.Console;

public abstract class Person {
    protected int x;
    protected int y;
    protected int[][] map;
    protected Console cn;

    public Person(int startX, int startY, int[][] map, Console cn) {
        this.x = startX;
        this.y = startY;
        this.map = map;
        this.cn = cn;
    }

    // Abstract methods to be implemented by subclasses
    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void moveLeft();
    public abstract void moveRight();
    public abstract void dropBomb();

    // Getters and Setters for x and y
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Getter for map
    public int[][] getMap() {
        return map;
    }

    // Setter for map
    public void setMap(int[][] map) {
        this.map = map;
    }

    // Getter for cn
    public Console getCn() {
        return cn;
    }

    // Setter for cn
    public void setCn(Console cn) {
        this.cn = cn;
    }
}

