package command;


import java.util.Collection;
import java.util.HashMap;

public class CommandsManager {

    private  HashMap<String, ICommand> commands = new HashMap<>();

    public void addCommand(ICommand cmd) throws Exception{
        if(cmd == null || commands.containsKey(cmd.getCommandName())){
            // Programming error force program exit
            throw new Exception("Comando ja existe");
        }
        commands.put(cmd.getCommandName(), cmd);
    }

    public  ICommand getCommand(String cmdName){
        return commands.get(cmdName);
    }

    public Collection<ICommand> getAvailableCommands(){
        return commands.values();
    }


}

