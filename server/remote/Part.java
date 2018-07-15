package server.remote;



import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Part extends Remote
{
    int getCodigo() throws RemoteException;

    String getNome() throws RemoteException;

    String getNomeRepositorio() throws RemoteException;

    String getDescricao() throws RemoteException;

    List<SubPart> getSubParts() throws RemoteException;

    void addSubParts(List<SubPart> sParts) throws RemoteException;
}