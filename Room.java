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
        setNorthExit(north);
        setEastExit(east);
        setSouthExit(south);
        setWestExit(west);
    }

    // methods setter
    public void setNorthExit(Room north) {
        if (north != null)
            this.northExit = north;
    }

    public void setEastExit(Room east) {
        if (east != null)
            this.eastExit = east;
    }

    public void setSouthExit(Room south) {
        if (south != null)
            this.southExit = south;
    }

    public void setWestExit(Room west) {
        if (west != null)
            this.westExit = west;
    }

    // methods getter
    public Room getNorthExit() {
        return this.northExit;
    }

    public Room getEastExit() {
        return this.eastExit;
    }

    public Room getSouthExit() {
        return this.southExit;
    }

    public Room getWestExit() {
        return this.westExit;
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
        System.out.println("-Room's name: " + getRoomName() + "-\n");
        System.out.println("North Exit: " + getNorthExit() + "\n");
        System.out.println("South Exit: " + getSouthExit() + "\n");
        System.out.println("East Exit: " + getEastExit() + "\n");
        System.out.println("West Exit: " + getWestExit() + "\n");

    }
}
