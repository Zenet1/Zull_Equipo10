import java.util.ArrayList;

public class Room {
    public String roomName;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;

    public Room(String name) {
        setName(name);
    }

    public Room(String name, Room north, Room east, Room south, Room west) {
        setName(name);
        setNorthExit(north);
        setEastExit(east);
        setSouthExit(south);
        setWestExit(west);
    }

    public void initializeExits(Room north, Room east, Room south, Room west) {
        setNorthExit(north);
        setEastExit(east);
        setSouthExit(south);
        setWestExit(west);
    }

    // methods setter
    public void setName(String name) {
        this.roomName = name;
    }

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

    public String getRoomName() {
        return this.roomName;
    }

    public void printExits() {
        System.out.println("-Room's name: " + getRoomName() + "-\n");
        String north, south, east, west;
        if (getNorthExit() != null) {
            north = getNorthExit().getRoomName();
        } else {
            north = "null";
        }
        if (getSouthExit() != null) {
            south = getSouthExit().getRoomName();
        } else {
            south = "null";
        }
        if (getEastExit() != null) {
            east = getEastExit().getRoomName();
        } else {
            east = "null";
        }
        if (getWestExit() != null) {
            west = getWestExit().getRoomName();
        } else {
            west = "null";
        }
        System.out.println("North Exit: " + north + "\n");
        System.out.println("South Exit: " + south + "\n");
        System.out.println("East Exit: " + east + "\n");
        System.out.println("West Exit: " + west + "\n");

    }
}
