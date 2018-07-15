package client.commands;

import client.Client;
import server.remote.SubPart;

public class ClearSubPartStagingListCommand extends BaseClientCommand {
    @Override
    public String getCommandName() {
        return "clearsp";
    }

    @Override
    public String getDescription() {
        return "Limpa as sub partes na lista de criação de Sub Partes";
    }

    @Override
    protected boolean processCommand(Client client, String[] args) {
        if(args.length != 1) {
            printInvalidArgs();
            return  false;
        }
        client.getSubPartsStagingList().clear();
        printMessage("Lista Limpa...");
        return false;
    }
}
