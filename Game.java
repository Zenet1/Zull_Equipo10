import java.util.Scanner;

public class Game{
    private Scanner reader; 
    private Parser parser; 
    private UI_console view;
    private Process process;
    private Room currentRoom;
    public Game(){
        //Lectorarchivo Probar = new Lectorarchivo();
        //String[][] Arreglo = Probar.comprobar("Prueba.txt");
       // createRooms2(Arreglo);
       reader = new Scanner(System.in);
       play();
    }

    public void play(){
        //gocurrentRoom
        this.view = new UI_console(currentRoom);
        boolean finished = false;
        while(!finished){
            view.printInCommand();
            read();
            Command command = parser.createCommand();
            this.process = new Process(command);
            finished = execution();
        }
    }

    public void read(){
        String inputLine;   
        String word1 = null;
        String word2 = null;
        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();  
            }
        }
        this.parser = new Parser(word1, word2);
    }

    public boolean execution(){

        if(!process.isUnknown()){
            switch (process.cases(process.command)) {
            case 1:
                if(!process.nowhere()){
                    view.printWhere();
                }else{
                    Room nextRoom = goRoom();
                    if(nextRoom!=null){
                        view.printNoDoor();
                    }else{
                        currentRoom = nextRoom;
                        view.printCurrent(currentRoom);
                    }
                }
                break;
            case 2:
                view.printHelp();
                break;
            case 3:
               
                if(!process.quit()){
                    view.printQuitFalse();
                }else{
                    view.printQuit();
                    return true;
                }
              
                break;
            default:
                break;
            }
        }else{
            view.printInvalid();       
        }
 
        view.printCurrent(currentRoom);
        return false;
    }

    public Room goRoom(){
        String direction = process.command.getSecondaryCommand();
 
        if(direction.equals("north")) {
           // nextRoom = currentRoom.northExit;
        }
        if(direction.equals("east")) {
           // nextRoom = currentRoom.eastExit;
        }
        if(direction.equals("south")) {
           // nextRoom = currentRoom.southExit;
        }
        if(direction.equals("west")) {
           // nextRoom = currentRoom.westExit;
        }

        return null;
    }

  
}