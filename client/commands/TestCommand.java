package client.commands;

public class TestCommand extends BaseClientCommand {

    @Override
    public String getCommandName() {
        return "test";
    }

    @Override
    public String getDescription() {
        return "Esse está aqui so para teste";
    }
}
