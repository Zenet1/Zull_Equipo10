public class Room {
    private String roomName;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    public Room(String name) {
        setRoomName(name);
    }

    // methods setter
    public void setRoomName(String name) {
        this.roomName = name;
    }

    public void setNorthExit(Room north) {
        this.northExit = north;
    }

    public void setEastExit(Room east) {
        this.eastExit = east;
    }

    public void setSouthExit(Room south) {
        this.southExit = south;
    }

    public void setWestExit(Room west) {
        this.westExit = west;
    }

    // methods getter
    public String getRoomName() {
        return this.roomName;
    }

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

    public void initializeExits(Room north, Room east, Room south, Room west) {
        if (isNotNullRoom(north)) {
            setNorthExit(north);
        }
        if (isNotNullRoom(east)) {
            setNorthExit(east);
        }
        if (isNotNullRoom(south)) {
            setNorthExit(south);
        }
        if (isNotNullRoom(west)) {
            setNorthExit(west);
        }
    }

    private boolean isNotNullRoom(Room room) {
        return (room != null);
    }
}
