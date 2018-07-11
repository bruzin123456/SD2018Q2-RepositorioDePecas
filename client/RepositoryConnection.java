package client;

import server.remote.Part;
import server.remote.PartRepository;

import java.rmi.registry.Registry;

public class RepositoryConnection {

    public String serverIp;
    public int serverPort;
    public Registry registry;
    public PartRepository partRepository;
    public Part part;


}
