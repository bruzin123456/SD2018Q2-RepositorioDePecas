package client.commands;

import client.Client;
import client.RepositoryConnection;
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
                        try {
                            printMessage("Código: " + sp.part.getCodigo() + "\tQuantidade: " + sp.count + "\tRepositorio: " + sp.part.getNomeRepositorio());
                        }
                        catch (RemoteException e){
                            printMessage("Erro de comunicação (o servidor da peça foi desligado ?)...");
                        }
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
