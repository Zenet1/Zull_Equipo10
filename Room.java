import java.util.ArrayList;

public class Room {
    public String roomName;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;

    public Room(String roomName) {
        this.roomName = roomName;
    }

    public void initializeExits(Room north, Room east, Room south, Room west) {
        if (north != null)
            northExit = north;
        if (east != null)
            eastExit = east;
        if (south != null)
            southExit = south;
        if (west != null)
            westExit = west;
    }

    /*
     * Previous function "initializeExits" that implements the ArrayList object,
     * handling the exits as String objects.
     * 
     * Function replaced by the actual function called for the same name.
     * In process to determining which implementation will be more convenient.
     * public void initializeExits(String name, ArrayList<String> exits) {
     * this.roomName = name;
     * if (exits.size() == 4) {
     * this.northExit = exits.get(0);
     * this.southExit = exits.get(1);
     * this.eastExit = exits.get(2);
     * this.westExit = exits.get(3);
     * }
     * }
     */

    public String getRoomName() {
        return this.roomName;
    }

    public void printExits() {
        System.out.println("-Nombre del cuarto: " + this.roomName + "-\n");
        System.out.println("North Exit: " + this.northExit + "\n");
        System.out.println("South Exit: " + this.southExit + "\n");
        System.out.println("East Exit: " + this.eastExit + "\n");
        System.out.println("West Exit: " + this.westExit + "\n");

    }
}
