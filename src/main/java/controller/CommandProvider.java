package controller;

import controller.impl.LoginationCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put("logination", new LoginationCommand());
        commands.put("registration", new LoginationCommand());
    }

    public Command getCommand (String commandName) {
        Command command = commands.get(commandName);
        return command;
    }
}
