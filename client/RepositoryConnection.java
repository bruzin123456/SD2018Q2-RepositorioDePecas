package client;

import server.remote.PartRepository;

import java.rmi.registry.Registry;

public class RepositoryConnection {

    public String serverIp;
    public int serverPort;
    public Registry registry;
    public PartRepository partRepository;


}
