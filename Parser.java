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
        if(verify(word1,words)==true) {
            if(verify(word2,directions)==true){
                return new Command(word1, word2);
            }else{
                return new Command(word1, null);
            }       
        }
        else {
            return new Command(null, null); 
        }
    }
    
    boolean verify(String command, String[] array){
        for (int i = 0; i < array.length; i++) {
            if(command.equals(array[i])){
                return true;
            }
        }
        return false;
    }
}
