
public class Process{
    private Command command;
    public Process(Command command) {
        this.command = command;
    }

    int cases(Command command){
  
        if (command.getMainCommand().equals("go")){
            return 1;
        }
        else if (command.getMainCommand().equals("help")){
            return 2 ;
        }   
        else if (command.getMainCommand().equals("quit")){
            return 3;
        }
        return 0;
    }

    boolean quit(Command command){
        boolean yesNull;
        if(command.getSecondaryCommand().equals("NOWHERE")){
            yesNull = true;
            return yesNull;
        }else{
            yesNull = false;
            return yesNull;
        }
        
    };

    boolean nowhere(Command command){
        if(command.getSecondaryCommand().equals("NOWHERE")){
 
            return false;
        }else{

            return true;
        }
    }

    public boolean isUnknown(Command command){
        if(command.getMainCommand()==null){
            return true;
        }else{
            return false;
        }
    }




    

  


}