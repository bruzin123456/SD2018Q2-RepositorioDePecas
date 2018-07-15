package server;

import server.remote.Part;
import server.remote.PartImpl;
import server.remote.PartRepository;
import server.remote.PartRepositoryImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public Server(String repositoryName, int port){
        this.port = port;
        this.repositoryName = repositoryName;
    }

    private PartRepositoryImpl partRepository;
    private int port;
    private String repositoryName;

    private Registry registry;

    public void init(){
        partRepository = new PartRepositoryImpl(repositoryName, this);
        try {
            PartRepository repositoryStub = (PartRepository) UnicastRemoteObject.exportObject(partRepository, port);
            registry = LocateRegistry.createRegistry(port);
            registry.bind("repository", repositoryStub);
            System.out.println("Servido iniciado");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public  Part bindPart(PartImpl part) throws RemoteException, AlreadyBoundException {
        Part partStub = (Part) UnicastRemoteObject.exportObject(part, port);
        registry.bind(String.valueOf(part.getCodigo()), partStub);
        return partStub;

    }
}
