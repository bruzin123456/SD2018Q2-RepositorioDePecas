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
			addp(args[1], args[2]);
        }
        else {
            printInvalidArgs();
        }
        return false;
    }

    private void addp(String nome, String descricao){

    }
}