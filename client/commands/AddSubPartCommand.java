package client.commands;

import client.Client;
import command.ICommand;

public class AddSubPartCommand extends BaseClientCommand {

    @Override
    public String getCommandName() {
        return "addsubp";
    }

    @Override
    public String getDescription() {
        return "Adiciona sub parts <Codigo> <Quant>";
    }

    @Override
    protected boolean processCommand(Client client, String[] args) {
        if(args.length != 3) {
            printInvalidArgs();
            return  false;
        }
        if(client.getRepositoryConnection() == null || client.getRepositoryConnection().part == null){
            printMessage("Nenhuma peça selecionada");
            return false;
        }
        try {
            client.getRepositoryConnection().part.addSubPart(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        }
        catch (Exception e){
            printMessage("Aconteceu um erro...");
        }
        return false;
    }
}
