package client.commands;

import client.Client;
import server.remote.SubPart;

public class AddSubPartsCommand extends BaseClientCommand {

    @Override
    public String getCommandName() {
        return "addsp";
    }

    @Override
    public String getDescription() {
        return "Adiciona as sub partes da lista de criação para a peça atual";
    }

    @Override
    protected boolean processCommand(Client client, String[] args) {
        if(args.length != 1) {
            printInvalidArgs();
            return  false;
        }
        if(client.getRepositoryConnection() == null || client.getRepositoryConnection().part == null){
            printMessage("Nenhuma peça selecionada");
            return false;
        }
        try {
            if(client.getSubPartsStagingList().isEmpty()){
                printMessage("Lista de criação de sub partes vazia...");
                return false;
            }
            client.getRepositoryConnection().part.addSubParts(client.getSubPartsStagingList());
            client.getSubPartsStagingList().clear();
            printMessage("Sub partes adicionadas com sucesso...");
        }
        catch (Exception e){
            printMessage("Aconteceu um erro...");
        }
        return false;
    }
}
