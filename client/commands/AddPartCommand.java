package client.commands;

import client.Client;
import command.ICommand;

public abstract class AddPartCommand extends BaseClientCommand {

    @Override
    public String getCommandName() {
        return "addp";
    }

    @Action
    public String getDescription() {
        return "addp <nome> <descricao>";
    }

    @Override
    protected boolean processCommand(Client client, String[] args) {
        if(args.length == 3){
			RepositoryConnection repositoryConnection = client.getRepositoryConnection();
            if(repositoryConnection == null){
                printMessage("Não conectado");
                return false;
            }
            try {
                int codigoNovaPart = repositoryConnection.partRepository.addPart(args[1], args[2]);
                System.out.println("Peça adicionada com sucesso. Código: " + String.valueOf(codigoNovaPart));
            }
            catch (RemoteException e){
                e.printStackTrace();
                printMessage("Erro!!!");
            }
        }
        else {
            printInvalidArgs();
        }
        return false;
    }

    private void addp(String nome, String descricao){

    }
}