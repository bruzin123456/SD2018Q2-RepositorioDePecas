package server.remote;

import server.Server;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

public class PartRepositoryImpl implements PartRepository {

    public PartRepositoryImpl(String name, Server server){
        repositoryName = name;
        this.server = server;
    }

    private String repositoryName;

    private List<PartImpl>partsList = new LinkedList<>();

    private Server server;

    @Override
    public int getPartsCount() {
        return partsList.size();
    }

    @Override
    public String getRepositoryName() {
        return repositoryName;
    }

    @Override
    public PartImpl findPart(int code) {
        return partsList.stream().filter(part -> code == part.getCodigo())
                .findAny()
                .orElse(null);
    }

    @Override
    public void addPart(PartImpl part) {
        partsList.add(part);
    }

    @Override
    public String partListing() {
        StringBuilder sb = new StringBuilder();
        for(PartImpl p : partsList){
            sb.append(p.getCodigo());
            sb.append("\t");
            sb.append(p.getNome());
        }
        return sb.toString();
    }
}
