public class Parser {
    private String words[]= {"go", "help", "quit"};
    private String directions[] = {"north", "south", "east", "west"};
    private String word1;
    private String word2;

    public Parser(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
    }

    public Command createCommand(){
     
        if(verify(word1)) {
            if(verifyDir(word2)){
                return new Command(word1, word2);
            }else{
                return new Command(word1, null);
            }  
               
        }
        else {
            return new Command(null, word2); 
        }
    }

    boolean verify(String command){
        boolean exit = false;
        for (int i = 0; i < words.length; i++) {
            if(command == words[0]){
                exit = true;
                break;
            }
        }
        return exit;
    }

    boolean verifyDir(String command){
        boolean exit = false;
        if(command != null){
            for (int i = 0; i < directions.length; i++) {
                if(command == words[0]){
                    exit = true;
                    break;
                }
            }
        }
        
        return exit;
    }


}
