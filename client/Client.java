package client;

import command.CommandsManager;
import server.remote.PartRepository;
import server.remote.SubPart;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.LinkedList;
import java.util.List;

public class Client {

    private CommandsManager commandsManager = new CommandsManager();
    private RepositoryConnection repositoryConnection; //if is connected is != than null
    private List<SubPart> subPartsStagingList = new LinkedList<>();

    public boolean bind(String host, int port){
        try {
            repositoryConnection = new RepositoryConnection();
            repositoryConnection.serverIp = host;
            repositoryConnection.serverPort = port;
            repositoryConnection.registry = LocateRegistry.getRegistry(host, port);
            repositoryConnection.partRepository = (PartRepository) repositoryConnection.registry.lookup("repository");
            // Apenas chamada de teste da conexão
            repositoryConnection.partRepository.getPartsCount();

        }
        catch (Exception e){
            repositoryConnection = null;
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void unbind(){
        repositoryConnection = null;
    }

    public void selectPart(int codigo) throws RemoteException, NotBoundException {
        if(repositoryConnection == null)
            return;
        repositoryConnection.part = repositoryConnection.partRepository.findPart(codigo);
        if(repositoryConnection.part == null){
            System.out.println("Peça invalida");
        }
    }

    public  CommandsManager getCommandsManager() {
        return commandsManager;
    }

    public RepositoryConnection getRepositoryConnection() {
        return repositoryConnection;
    }

    public List<SubPart> getSubPartsStagingList() {
        return subPartsStagingList;
    }
}
