public class Command {
    private String mainCommand;
    private String secondaryCommand;

    public Command(String firstWord, String secondWord) {
        this.mainCommand = firstWord;
        this.secondaryCommand = secondWord;
    }
    public String getSecondaryCommand() {
        if(secondaryCommand == null){
            return "NOWHERE";
        }else{
            
           return getDirection();
        }
    }

    private String getDirection(){
        return secondaryCommand;
    }

    public String getMainCommand(){
        return mainCommand;
    }



}
