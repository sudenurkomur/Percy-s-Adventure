public class Statue extends Staff {


    public Statue(String name, int type, int damage, int location_type, Map location_array, Map spawn_locationX, Map spawn_locationY, int speed) {
        super(name, type, damage, location_type, location_array, spawn_locationX, spawn_locationY, speed);
    }

    //strategy pattern
    @Override
    public void act() {
        // The statue emits a mystical glow
        System.out.println("The statue emits a mystical glow.");
    }


    // Method to get the current position of the statue
    public String getCurrentPosition() {
        return "Statue is at position X: " + this.spawn_locationX + " Y: " + this.spawn_locationY;
    }
}

