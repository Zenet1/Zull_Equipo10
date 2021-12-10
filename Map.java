import java.util.ArrayList;

public class Map {
    private ArrayList<Room> rooms;
    private Room currentRoom;

    public Map() {
        rooms = new ArrayList();
        initializeRooms();
    }

    private void initializeRooms() {
        Lectorarchivo lector = new Lectorarchivo();
        String[][] arrayRooms = new String[15][4];
        arrayRooms = lector.comprobar("Prueba.txt");
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
                north.setName(arrayRooms[i][1]);
                // Room north = new Room(arrayRooms[i][1]);
            }
            if (!arrayRooms[i][2].equals("null")) {
                south.setName(arrayRooms[i][2]);
                // Room south = new Room(arrayRooms[i][2]);
            }
            if (!arrayRooms[i][3].equals("null")) {
                east.setName(arrayRooms[i][3]);
                // Room east = new Room(arrayRooms[i][3]);
            }
            if (!arrayRooms[i][4].equals("null")) {
                west.setName(arrayRooms[i][4]);
                // Room west = new Room(arrayRooms[i][4]);
            }
            actualRoom.initializeExits(north, east, south, west);
            rooms.add(actualRoom);
        }
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    public void printAllExits() {
        for (int i = 0; i < rooms.size(); i++) {
            rooms.get(i).printExits();
        }
    }
}
