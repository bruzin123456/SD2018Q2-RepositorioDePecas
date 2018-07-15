package client.commands;

import client.Client;
import server.remote.Part;
import server.remote.SubPart;

public class AddToSubPartStagingListCommand extends BaseClientCommand {

    @Override
    public String getCommandName() {
        return "stagesp";
    }

    @Override
    public String getDescription() {
        return "Adiciona a peça selecionada à lista de criação de sub partes <Quant>";
    }

    @Override
    protected boolean processCommand(Client client, String[] args) {
        if(args.length != 2) {
            printInvalidArgs();
            return  false;
        }
        if(client.getRepositoryConnection() == null || client.getRepositoryConnection().part == null){
            printMessage("Nenhuma peça selecionada");
            return false;
        }
        try {
            Part currentPart = client.getRepositoryConnection().part;
            SubPart existingEntry = null;
            for(SubPart sp : client.getSubPartsStagingList()){
                try {
                    if (sp.part.getCodigo() == currentPart.getCodigo() && sp.part.getNomeRepositorio().equals(currentPart.getNomeRepositorio())) {
                        existingEntry = sp;
                        break;
                    }
                }
                catch (Exception e){
                    //
                }
            }
            if(existingEntry == null) {
                client.getSubPartsStagingList().add(new SubPart(client.getRepositoryConnection().part, Integer.parseInt(args[1])));
            }
            else {
                existingEntry.count += Integer.parseInt(args[1]);
            }
            printMessage("Okey!!!");
        }
        catch (Exception e){
            printMessage("Aconteceu um erro...");
        }
        return false;
    }
}
