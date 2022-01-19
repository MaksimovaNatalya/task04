package by.epam.tc.project.controller;

import by.epam.tc.project.controller.impl.AuthorizationCommand;
import by.epam.tc.project.controller.impl.gotocommand.GoToIndexPageCommand;
import by.epam.tc.project.controller.impl.gotocommand.GoToLoginationPageCommand;
import by.epam.tc.project.controller.impl.gotocommand.GoToMainPageCommand;
import by.epam.tc.project.controller.impl.gotocommand.GoToRegistrationPageCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put("logination", new AuthorizationCommand());
        commands.put("registration", new AuthorizationCommand());

        commands.put("GO_TO_REGISTRATION_PAGE", new GoToRegistrationPageCommand());
        commands.put("GO_TO_LOGINATION_PAGE", new GoToLoginationPageCommand());
        commands.put("GO_TO_INDEX_PAGE", new GoToIndexPageCommand());
        commands.put("GO_TO_MAIN_PAGE", new GoToMainPageCommand());
        commands.put("GO_TO_BOOKING_PAGE", new GoToBookingPageCommand());
    }

    public Command getCommand(String commandName) {
        Command command = commands.get(commandName);
        return command;
    }
}
