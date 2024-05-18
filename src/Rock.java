import java.util.Random;

public class Rock extends Staff {

    private int maxrockNumber;

    public Rock(String name, int type, int damage, int location_type, Map location_array, Map spawn_locationX, Map spawn_locationY, int speed,int maxrockNumber,int seed) {
        super(name, type, damage, location_type, location_array, spawn_locationX, spawn_locationY, speed);
        this.maxrockNumber = maxrockNumber;
    }

    // Getter ve setter metotları
    public int getMaxrockNumber() {
        return maxrockNumber;
    }

    public void setMaxrockNumber(int maxrockNumber) {
        this.maxrockNumber = maxrockNumber;
    }

    public void randomPlace(int seed) {
        Random rnd =new Random();
        int i=0;
        while(i!=seed ){
            int randomNumberX = rnd.nextInt(120);
            int randomNumberY = rnd.nextInt(100);
            i++;
        }
    }

    @Override
    public void act() {

    }
}

