public class Command {
    private String mainCommand;
    private String secondaryCommand;

    public Command(String first, String second) {
        this.mainCommand = first;
        this.secondaryCommand = second;
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
