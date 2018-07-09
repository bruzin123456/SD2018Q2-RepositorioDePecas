package client.commands;

import client.Client;
import client.RepositoryConnection;
import command.ICommand;

import java.rmi.RemoteException;

public class ListPartsCommand extends BaseClientCommand {
    @Override
    public String getCommandName() {
        return "listp";
    }

    @Override
    public String getDescription() {
        return "Mostra as peças existentes no repositório";
    }

    @Override
    protected boolean processCommand(Client client, String[] args) {
        if(args.length != 1)
            printInvalidArgs();
        RepositoryConnection repositoryConnection = client.getRepositoryConnection();
        if(repositoryConnection == null){
            printMessage("Não conectado");
            return false;
        }
        try {
            int partsCount = repositoryConnection.partRepository.getPartsCount();
            String partsListing = repositoryConnection.partRepository.partListing();
            printMessage("N de pçs : " + partsCount);
            printMessage("------------------------------");
            printMessage(partsListing);
            printMessage("------------------------------");
        }
        catch (RemoteException e){
            e.printStackTrace();
            printMessage("Erro!!!");
        }
        return false;
    }
}
