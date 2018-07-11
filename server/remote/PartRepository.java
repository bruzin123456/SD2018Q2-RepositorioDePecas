package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PartRepository extends Remote {

    String getRepositoryName() throws RemoteException;

    int getPartsCount() throws RemoteException;

    PartImpl findPart(int code) throws RemoteException;

    int addPart(String nome, String descricao) throws RemoteException;

    String partListing() throws RemoteException;

}
