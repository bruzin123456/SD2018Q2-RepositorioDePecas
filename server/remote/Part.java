package server.remote;

import javafx.util.Pair;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Part extends Remote
{
    int getCodigo() throws RemoteException;

    String getNome() throws RemoteException;

    String getDescricao() throws RemoteException;

    List<Pair<PartImpl, Integer>> getSubParts() throws RemoteException;
}