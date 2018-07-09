package command;

public interface ICommand {

    //Return command name
    public String getCommandName();

    //Execute command and tells main process if should end application
    public boolean executeCommand(Object obj, String[] args);

}
