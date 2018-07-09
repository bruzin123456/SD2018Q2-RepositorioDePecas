package client.commands;

import client.Client;
import command.ICommand;

public class UnbindConnection extends BaseClientCommand {

    @Override
    public String getCommandName() {
        return "unbind";
    }

    @Override
    public String getDescription() {
        return "Desconecta da conexão atual se houver";
    }

    @Override
    protected boolean processCommand(Client client, String[] args) {
        client.unbind();
        printMessage("Desconectado!!!");
        return false;
    }
}
