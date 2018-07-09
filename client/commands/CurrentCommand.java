package client.commands;

import client.Client;
import client.RepositoryConnection;
import command.ICommand;

import java.rmi.RemoteException;

public class CurrentCommand extends BaseClientCommand {

    @Override
    public String getCommandName() {
        return "current";
    }

    @Override
    public String getDescription() {
        return "Mostra a conexão atual se houver";
    }

    @Override
    protected boolean processCommand(Client client, String[] args) {
        if(args.length != 1)
            printInvalidArgs();
        RepositoryConnection repositoryConnection = client.getRepositoryConnection();
        if(repositoryConnection == null){
            printMessage("Não conectado!!");
        }
        else {
            try {
                printMessage("host: " + repositoryConnection.serverIp + ":" + repositoryConnection.serverPort + "\n" +
                        "Nome Rep: " + repositoryConnection.partRepository.getRepositoryName());
            }
            catch (RemoteException e){
                printMessage("Conexão falhou ( O servidor foi desligado ?)... Unbinding a conexão atual");
                client.unbind();
            }
        }
        return false;
    }
}
