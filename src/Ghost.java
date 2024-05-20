public class Ghost extends Staff {

    // Constructor
    public Ghost(String name, int type, int damage, int location_type, Map location_array, Map spawn_locationX, Map spawn_locationY, int speed) {
        super(name, type, damage, location_type, location_array, spawn_locationX, spawn_locationY, speed);
    }

    @Override
    public void act() {
        // The tree releases fragrant blossoms
        System.out.println("The tree releases fragrant blossoms.");
    }
}


