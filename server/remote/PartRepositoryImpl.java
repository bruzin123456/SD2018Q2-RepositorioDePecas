package server.remote;

import server.Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PartRepositoryImpl implements PartRepository {

    public PartRepositoryImpl(String name, Server server){
        repositoryName = name;
        Random r = new Random();
        codGenerator = random_int(0, 99999);
        this.server = server;
    }

    private int codGenerator = 666;

    private String repositoryName;

    private List<Part>partsList = new LinkedList<>();

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
    public Part findPart(int code) {
        try {
            for(Part part : partsList){
                if(part.getCodigo() == code)
                    return part;
            }
        }
        catch (Exception e){
        }
        return  null;
    }

    @Override
    public int addPart(String nome, String descricao) {
        try {
            PartImpl nPart = new PartImpl();
            nPart.setNome(nome);
            nPart.setDescricao(descricao);
            nPart.setCodigo(codGenerator);
            nPart.setRepository(this);
            partsList.add(server.bindPart(nPart));
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
        for(Part p : partsList){
            try {
                sb.append(p.getCodigo());
                sb.append("\t");
                sb.append(p.getNome());
                sb.append("\t");
                sb.append(p.getDescricao());
                sb.append("\n");
            }
            catch (Exception e){
                sb.append("Erro de comunicação \n");
            }
        }
        return sb.toString();
    }

    public int random_int(int Min, int Max)
    {
        return (int) (Math.random()*(Max-Min))+Min;
    }
}
