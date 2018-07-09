package client.commands;

import client.Client;
import command.ICommand;

public abstract class BaseClientCommand implements ICommand {

    public abstract String getDescription();


    @Override
    public final boolean executeCommand(Object client, String[] args) {
        //If we need to have something in common between all command
        return processCommand((Client)client, args);
    }

    protected boolean processCommand(Client client, String[] args){ //
        String message ="";
        for (String s : args){
            message += s + " ";
        }
        printMessage("--- Ainda nao implementado ---");
        printMessage(message);
        printMessage("------------------------------");
        return false;
    }

    protected void printMessage(String message){
        System.out.println(message);
    }

    protected void printInvalidArgs(){
        printMessage("Argumentos Invalidos!");
    }
}
