public class UI_console {

    public UI_console(Room currentRoom) {
        printWelcome();
        printCurrent(currentRoom);

    }

    public void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
    }

    public void printCurrent(Room currentRoom) {
        System.out.println("You are in " + currentRoom.getRoomName() + "-\n");
        System.out.print("Exits: \n");
        String north, south, east, west;
        if (currentRoom.getNorthExit() != null) {
            north = currentRoom.getNorthExit().getRoomName();
            System.out.println("North Exit: " + north + "\n");
        } else {
            north = "null";
        }
        if (currentRoom.getSouthExit() != null) {
            south = currentRoom.getSouthExit().getRoomName();
            System.out.println("South Exit: " + south + "\n");
        } else {
            south = "null";
        }
        if (currentRoom.getEastExit() != null) {
            east = currentRoom.getEastExit().getRoomName();
            System.out.println("East Exit: " + east + "\n");
        } else {
            east = "null";
        }
        if (currentRoom.getWestExit() != null) {
            west = currentRoom.getWestExit().getRoomName();
            System.out.println("West Exit: " + west + "\n");
        } else {
            west = "null";
        }

    }

    public void printWhere() {
        System.out.println("Go where?");
    }

    public void printNoDoor() {
        System.out.println("There is no door!");
    }

    public void printInvalid() {
        System.out.println("I don't know what you mean...");
    }

    public void printInCommand() {
        System.out.print("> ");
    }

    public void printQuitFalse() {
        System.out.println("Quit what?");
    }

    public void printQuit() {
        System.out.println("Thank you for playing.  Good bye.");
    }

    public void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("go quit help");
    }

}