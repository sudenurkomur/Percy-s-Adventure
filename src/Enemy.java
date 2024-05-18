public abstract class Enemy {
    private String name;
    private int type;
    private int damage;
    private int locationX;
    private int locationY;

    public Enemy(String name, int type, int damage, int locationX, int locationY) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public abstract void act(); // Her düşmanın davranışını tanımlayacak yöntem

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }
}
