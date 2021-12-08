import java.util.ArrayList;

public class Map {
    private ArrayList<Room> rooms;

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
        Room actualRoom = new Room();
        ArrayList<String> exits = new ArrayList();
        String name;
        for (int i = 0; i < arrayRooms.length; i++) {
            for (int j = 0; j < 4; j++) {
                exits.add(arrayRooms[i][j]);
            }
            name = arrayRooms[i][0];
            actualRoom.initializeExits(name, exits);
            exits.clear();
            rooms.add(actualRoom);
        }
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }
}
