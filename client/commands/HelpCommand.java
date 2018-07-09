package client.commands;

import client.Client;
import command.ICommand;

public class HelpCommand extends BaseClientCommand {

    @Override
    public String getCommandName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Mostra os comandos disponíveis";
    }

    @Override
    protected boolean processCommand(Client client, String[] args) {
        if(args.length != 1)
            printInvalidArgs();
        printMessage("-- Lista de comandos --");
        for( ICommand cmd : client.getCommandsManager().getAvailableCommands()){
            printMessage(cmd.getCommandName() + "\t" + ((BaseClientCommand)cmd).getDescription());
        }
        printMessage("-----------------------");

        return false;
    }
}
