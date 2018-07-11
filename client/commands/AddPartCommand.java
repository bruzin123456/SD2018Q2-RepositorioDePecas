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
<<<<<<< HEAD
        if(args.length >= 3){
=======
        if(args.length == 3){
>>>>>>> e821172299e25a2d372f96aa97d92c00a6c43309
			RepositoryConnection repositoryConnection = client.getRepositoryConnection();
            if(repositoryConnection == null){
                printMessage("Não conectado");
                return false;
            }
            try {
<<<<<<< HEAD
                StringBuilder descricao = new StringBuilder();
                for (int indice = 2; i < args.length; ++indice) {
                    descricao.append(args[indice]);
                    descricao.append(" ");
                }


                int codigoNovaPart = repositoryConnection.partRepository.addPart(args[1], descricao.toString().trim());
=======
                int codigoNovaPart = repositoryConnection.partRepository.addPart(args[1], args[2]);
>>>>>>> e821172299e25a2d372f96aa97d92c00a6c43309
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