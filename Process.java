
public class Process{
    public Command command;
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

    boolean quit(){
        boolean isNull;
        if(command.getSecondaryCommand().equals("NOWHERE")){
            isNull = true;
            return isNull;
        }else{
            isNull = false;
            return isNull;
        }
        
    };

    boolean nowhere(){
        if(command.getSecondaryCommand().equals("NOWHERE")){
 
            return false;
        }else{

            return true;
        }
    }

    public boolean isUnknown(){
        if(command.getMainCommand()==null){
            return true;
        }else{
            return false;
        }
    }
/*
    public Command getCommand(){
        return this.command;
    }
*/



    

  


}