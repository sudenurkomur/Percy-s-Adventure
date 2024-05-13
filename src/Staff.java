public abstract class Staff {

    private String name;
    private int type;
    private int damage;
    private int location_type;
    private Map location_array;
    private Map spawn_locationX;
    private Map spawn_locationY;
    private int speed;
    private int seed;


    public Staff(String name, int type, int damage, int location_type, Map location_array, Map spawn_locationX, Map spawn_locationY, int speed) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.location_type = location_type;
        this.location_array = location_array;
        this.spawn_locationX = spawn_locationX;
        this.spawn_locationY = spawn_locationY;
        this.speed = speed;
        this.seed=seed;
    }

    // Getter ve setter metotları
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

    public int getLocationType() {
        return location_type;
    }

    public void setLocationType(int location_type) {
        this.location_type = location_type;
    }

    public Map getLocationArray() {
        return location_array;
    }

    public void setLocationArray(Map location_array) {
        this.location_array = location_array;
    }

    public Map getSpawnLocationX() {
        return spawn_locationX;
    }

    public void setSpawnLocationX(Map spawn_locationX) {
        this.spawn_locationX = spawn_locationX;
    }

    public Map getSpawnLocationY() {
        return spawn_locationY;
    }

    public void setSpawnLocationY(Map spawn_locationY) {
        this.spawn_locationY = spawn_locationY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }
}
