package client.commands;

import client.Client;
import client.RepositoryConnection;
import command.ICommand;
import server.remote.SubPart;

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
        if(args.length != 1) {
            printInvalidArgs();
            return false;
        }
        RepositoryConnection repositoryConnection = client.getRepositoryConnection();
        if(repositoryConnection == null){
            printMessage("Não conectado!!");
        }
        else {
            try {
                printMessage("host: " + repositoryConnection.serverIp + ":" + repositoryConnection.serverPort + "\n" +
                        "Nome Rep: " + repositoryConnection.partRepository.getRepositoryName()) ;
                if(repositoryConnection.part == null)
                    printMessage("Nenhuma parte selecionada.");
                else {
                    printMessage("------------------- Part -------------------");
                    printMessage("Nome: " + repositoryConnection.part.getNome());
                    printMessage("Descrição: " + repositoryConnection.part.getDescricao());
                    printMessage("---Sub Parts---");
                    for(SubPart sp : repositoryConnection.part.getSubParts()){
                        printMessage("Código: " + sp.codigoPart + "\tQuantidade: " + sp.count);
                    }
                    printMessage("---------------------------------------------");

                }
            }
            catch (RemoteException e){
                printMessage("Conexão falhou ( O servidor foi desligado ?)... Unbinding a conexão atual");
                client.unbind();
            }
        }
        return false;
    }
}
