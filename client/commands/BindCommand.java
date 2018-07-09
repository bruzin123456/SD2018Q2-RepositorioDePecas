package client.commands;

import client.Client;
import command.ICommand;

public class BindCommand extends BaseClientCommand {

    @Override
    public String getCommandName() {
        return "bind";
    }

    @Override
    public String getDescription() {
        return "<Porta>  ou <Ip> <Porta>";
    }

    @Override
    protected boolean processCommand(Client client, String[] args) {
        int port = 0;
        if(args.length == 2){
            try {
                port = Integer.parseInt(args[1]);
                bind("localhost", port, client);
            }
            catch (NumberFormatException e){
                printInvalidArgs();
            }
        }
        else if ( args.length == 3){
            try {
                port = Integer.parseInt(args[2]);
                bind(args[1], port,client);
            }
            catch (NumberFormatException e){
                printInvalidArgs();
            }
        }
        else {
            printInvalidArgs();
        }
        return false;
    }

    private void bind(String ip, int port, Client client){
        System.out.println("coectando a: " + ip + ":"+port);
        boolean success =client.bind(ip, port);
        if(success) {
            System.out.println("conectado!!!");
        }
        else {
            System.out.println("conexão falhou!!!");

        }
    }
}
