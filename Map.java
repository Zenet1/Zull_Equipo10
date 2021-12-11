import java.util.ArrayList;

public class Map {
    private ArrayList<Room> rooms;

    public Map() {
        rooms = new ArrayList();
        initializeMap();
    }

    private void initializeMap() {
        ReadFile reader = new ReadFile();
        String[][] arrayRooms = new String[15][4];
        arrayRooms = reader.getArrayRooms("Prueba.txt");
        initializeRooms(arrayRooms);
    }

    private void initializeRooms(String[][] arrayRooms) {
        for (int i = 0; i < arrayRooms.length; i++) {
            Room actualRoom = new Room(arrayRooms[i][0]);
            Room north = new Room("null");
            Room south = new Room("null");
            Room east = new Room("null");
            Room west = new Room("null");
            if (!isEqualToNull(arrayRooms[i][1])) {
                north.setRoomName(arrayRooms[i][1]);
            }
            if (!isEqualToNull(arrayRooms[i][2])) {
                south.setRoomName(arrayRooms[i][2]);
            }
            if (!isEqualToNull(arrayRooms[i][3])) {
                east.setRoomName(arrayRooms[i][3]);
            }
            if (!isEqualToNull(arrayRooms[i][4])) {
                west.setRoomName(arrayRooms[i][4]);
            }
            actualRoom.initializeExits(north, east, south, west);
            rooms.add(actualRoom);
        }
    }

    private boolean isEqualToNull(String name) {
        return (name.equals("null"));
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }
}
