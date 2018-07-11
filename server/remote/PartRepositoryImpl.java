package server.remote;

import server.Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

public class PartRepositoryImpl implements PartRepository {

    public PartRepositoryImpl(String name, Server server){
        repositoryName = name;
        this.server = server;
    }

    private int codGenerator = 666;

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
    public int addPart(String nome, String descricao) {
        try {
            PartImpl nPart = new PartImpl();
            nPart.setNome(nome);
            nPart.setDescricao(descricao);
            nPart.setCodigo(codGenerator);
            server.bindPart(nPart);
            partsList.add(nPart);
            codGenerator++;
            return nPart.getCodigo();
        }
        catch (Exception e){
            System.out.println("Bugo chama o bombeiro");
        }
        return 0;
    }

    @Override
    public String partListing() {
        StringBuilder sb = new StringBuilder();
        for(PartImpl p : partsList){
            sb.append(p.getCodigo());
            sb.append("\t");
            sb.append(p.getNome());
            sb.append("\t");
            sb.append(p.getDescricao());
            sb.append("\n");
        }
        return sb.toString();
    }
}
