package client;

import command.CommandsManager;
import server.remote.PartRepository;
import java.rmi.registry.LocateRegistry;

public class Client {

    private CommandsManager commandsManager = new CommandsManager();
    private RepositoryConnection repositoryConnection; //if is connected is != than null

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

    public  CommandsManager getCommandsManager() {
        return commandsManager;
    }

    public RepositoryConnection getRepositoryConnection() {
        return repositoryConnection;
    }
}
