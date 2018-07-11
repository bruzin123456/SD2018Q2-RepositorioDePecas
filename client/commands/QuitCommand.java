package client.commands;

import client.Client;
import command.ICommand;

public class QuitCommand extends BaseClientCommand {

    @Override
    public String getCommandName() {
        return "quit";
    }

    @Override
    public String getDescription() {
        return "Encerra a aplicação";
    }

    @Override
    protected boolean processCommand(Client client, String[] args) {
        printMessage("Encerrando...");
        return true;
    }
}
