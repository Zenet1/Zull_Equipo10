import java.util.Scanner;

public class Game{
    private Scanner reader; 
    private Parser parser; 
    private UI_console view;
    private Process process;
    public Game(){
        //Lectorarchivo Probar = new Lectorarchivo();
        //String[][] Arreglo = Probar.comprobar("Prueba.txt");
       // createRooms2(Arreglo);
       reader = new Scanner(System.in);
    }

    public void play(){
        this.view = new UI_console();
        boolean finished = false;
        while(!finished){
            read();
            Command command = parser.createCommand();
            process = new Process(command);
            finished = execution(process);
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

    public boolean execution(Process process){
        //view.currentRoom();





        return false;
    }

  
}