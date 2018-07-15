package client.commands;

import client.Client;
import server.remote.SubPart;

import java.util.List;

public class ShowStagingSubPartListCommand extends BaseClientCommand {

    @Override
    public String getCommandName() {
        return "showsp";
    }

    @Override
    public String getDescription() {
        return "Mostra as sub partes na lista de criação de Sub Partes";
    }

    @Override
    protected boolean processCommand(Client client, String[] args) {
        if(args.length != 1) {
            printInvalidArgs();
            return  false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("-------- Sub Partes ---------\n");
        for (SubPart subPart : client.getSubPartsStagingList()){
            try {
                int codigo = subPart.part.getCodigo();
                String nomeRep = subPart.part.getNomeRepositorio();
                sb.append("Código: " + codigo + "\tQuantidade: " + subPart.count + "\tRepositorio: " + nomeRep + "\n");
            }
            catch (Exception e){
                sb.append("Erro de comunicação...");
            }
        }
        sb.append("------------------------------");
        printMessage(sb.toString());
        return false;
    }
}
