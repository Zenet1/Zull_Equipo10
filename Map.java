import java.util.ArrayList;

public class Map {
    private ArrayList<Room> rooms;

    public Map() {
        rooms = new ArrayList();
        initializeRooms();
    }

    private void initializeRooms() {
        ReadFile reader = new ReadFile();
        String[][] arrayRooms = new String[15][4];
        arrayRooms = reader.getArrayRooms("Prueba.txt");
        setRooms(arrayRooms);
    }

    public void setRooms(String[][] arrayRooms) {
        for (int i = 0; i < arrayRooms.length; i++) {
            Room actualRoom = new Room(arrayRooms[i][0]);
            Room north = new Room("null");
            Room south = new Room("null");
            Room east = new Room("null");
            Room west = new Room("null");
            if (!arrayRooms[i][1].equals("null")) {
                north.setRoomName(arrayRooms[i][1]);
                // Room north = new Room(arrayRooms[i][1]);
            }
            if (!arrayRooms[i][2].equals("null")) {
                south.setRoomName(arrayRooms[i][2]);
                // Room south = new Room(arrayRooms[i][2]);
            }
            if (!arrayRooms[i][3].equals("null")) {
                east.setRoomName(arrayRooms[i][3]);
                // Room east = new Room(arrayRooms[i][3]);
            }
            if (!arrayRooms[i][4].equals("null")) {
                west.setRoomName(arrayRooms[i][4]);
                // Room west = new Room(arrayRooms[i][4]);
            }
            actualRoom.initializeExits(north, east, south, west);
            rooms.add(actualRoom);
        }
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }
}
