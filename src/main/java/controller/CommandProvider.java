package controller;

import controller.impl.GoToLoginationPageCommand;
import controller.impl.GoToIndexPageCommand;
import controller.impl.GoToRegistrationPageCommand;
import controller.impl.LoginationCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put("logination", new LoginationCommand());
        commands.put("registration", new LoginationCommand());

        commands.put("GO_TO_REGISTRATION_PAGE", new GoToRegistrationPageCommand());
        commands.put("GO_TO_LOGINATION_PAGE", new GoToLoginationPageCommand());
        commands.put("GO_TO_INDEX_PAGE", new GoToIndexPageCommand());
    }

    public Command getCommand (String commandName) {
        Command command = commands.get(commandName);
        return command;
    }
}
