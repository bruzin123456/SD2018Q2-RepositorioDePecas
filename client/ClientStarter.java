package client;

import client.commands.*;
import command.CommandsManager;
import command.ICommand;
import java.util.Scanner;

public class ClientStarter {

    private static Client client;

    public static void main(String[] args) {
        client  = new Client();
        initializeCommands();
        Scanner s = new Scanner(System.in);
        boolean end = false;
        while(!end){
            String line = s.nextLine();
            String[] cmdArgs = line.split(" ");
            ICommand cmd = client.getCommandsManager().getCommand(cmdArgs[0]);
            if(cmd == null){ // if cmd == null this command doesn't exists
                System.out.println("Esse comando não existe!!!");
                continue;
            }
            //
            end = cmd.executeCommand(client, cmdArgs);
        }
        // Do what need to be done before exiting
        s.close();
    }

    private static void initializeCommands(){
        CommandsManager commandsManager = client.getCommandsManager();
        try {
            commandsManager.addCommand(new TestCommand());
            commandsManager.addCommand(new HelpCommand());
            commandsManager.addCommand(new BindCommand());
            commandsManager.addCommand(new UnbindConnection());
            commandsManager.addCommand(new CurrentCommand());
            commandsManager.addCommand(new ListPartsCommand());
            commandsManager.addCommand(new QuitCommand());
            commandsManager.addCommand(new AddPartCommand());
            commandsManager.addCommand(new SelectPartCommand());
            commandsManager.addCommand(new AddToSubPartStagingListCommand());
            commandsManager.addCommand(new AddSubPartsCommand());
            commandsManager.addCommand(new ShowStagingSubPartListCommand());
            commandsManager.addCommand(new ClearSubPartStagingListCommand());
        }
        catch (Exception e){
            System.out.println("Um comando com esse nome já existe!!");
            System.exit(0);
        }
    }

}
