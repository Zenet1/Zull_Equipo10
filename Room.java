public class Room {
    private int exitNorth;
    private int exitSouth;
    private int exitEast;
    private int exitWest;

    public Room(int exits[]) {
        if (exits.length == 5) {
            this.exitNorth = exits[0];
            this.exitSouth = exits[1];
            this.exitEast = exits[2];
            this.exitWest = exits[3];
        }
    }
}
