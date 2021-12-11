package Src;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Scanner reader;
    private UI_console view;
    private Process process;
    private Room currentRoom;
    private ArrayList<Room> rooms;

    public Game(Map map) {
        rooms = map.getRooms();
        currentRoom = rooms.get(1);
        System.out.println(currentRoom.getRoomName());
        reader = new Scanner(System.in);
        play();
    }

    public void play() {
        this.view = new UI_console(currentRoom);
        boolean finished = false;

        while (!finished) {
            view.printInCommand();
            Parser parser = read();
            Command command = parser.createCommand();
            this.process = new Process(command);
            finished = execution();
        }
    }

    public Parser read() {
        String inputLine;
        String word1 = null;
        String word2 = null;
        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }
        return new Parser(word1, word2);
    }

    public boolean execution() {

        if (process.isUnknown()) {
            view.printInvalid();
            return false;
        }
        switch (process.commandCases()) {
            case 1:
                goCase();
                break;
            case 2:
                view.printHelp();
                break;
            case 3:
                // si se ingreso "quit" correctamente, retorna true
                return quitCase();
            default:
                // En caso de que se llegue a colar un comando invalido
                view.printInvalid();
                break;
        }

        view.printCurrent(currentRoom);
        return false;
    }

    private void goCase() {
        if (!process.nowhere()) {
            view.printWhere();
            return;
        }
        Room nextRoom = goRoom();
        if (nextRoom == null) {
            view.printNoDoor();
            return;
        }

        for (Room room : rooms) {
            if (nextRoom.getRoomName().equals(room.getRoomName())) {
                currentRoom = room;
                break;
            }
        }

    }

    private boolean quitCase() {
        if (!process.quit()) {
            view.printQuitFalse();
            return false;
        } else {
            view.printQuit();
            return true;
        }
    }

    public Room goRoom() {
        String direction = process.getCommand().getSecondaryCommand();

        if (direction.equals("north"))
            return currentRoom.getNorthExit();

        if (direction.equals("east"))
            return currentRoom.getEastExit();

        if (direction.equals("south"))
            return currentRoom.getSouthExit();

        if (direction.equals("west"))
            return currentRoom.getWestExit();

        return null;
    }

}