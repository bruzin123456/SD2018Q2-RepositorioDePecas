package client.commands;

import client.Client;
import client.RepositoryConnection;

import java.rmi.RemoteException;

public class SelectPartCommand extends BaseClientCommand {

    @Override
    public String getCommandName() {
        return "selectp";
    }

    public String getDescription() {
        return "seleciona a peça com o codigo <Codigo>";
    }

    @Override
    protected boolean processCommand(Client client, String[] args) {
        if(args.length != 2) {
            printInvalidArgs();
            return false;
        }
        try{
            int codigo = Integer.parseInt(args[1]);
            client.selectPart(codigo);
        }
        catch (Exception e){
            printMessage("Erro!!!");
        }
        return false;
    }

}
