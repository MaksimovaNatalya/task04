package by.epam.tc.project.controller;

import by.epam.tc.project.controller.impl.*;
import by.epam.tc.project.controller.impl.gotocommand.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put("logination", new AuthorizationCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("showRooms", new ShowRoomsCommand());
        commands.put("findRooms", new FindRoomCommand());
        commands.put("logOut", new LogOutCommand());
        commands.put("changeLanguage", new ChangeLanguageCommand());
        commands.put("changeAccountInfo", new ChangeAccountInfoCommand());
    //    commands.put("cancelBooking", new CancelBookingCommand());
        commands.put("bookRoom", new BookRoomCommand());
        commands.put("showAllRequests", new ShowAllRequestsCommand());
        commands.put("approveRequest", new ApproveRequestCommand());

        commands.put("GO_TO_REGISTRATION_PAGE", new GoToRegistrationPageCommand());
        commands.put("GO_TO_AUTHORIZATION_PAGE", new GoToAuthorizationPageCommand());
        commands.put("GO_TO_INDEX_PAGE", new GoToIndexPageCommand());
        commands.put("GO_TO_MAIN_PAGE", new GoToMainPageCommand());
        commands.put("GO_TO_REQUEST_PAGE", new GoToRequestPageCommand());
        commands.put("GO_TO_ACCOUNT_PAGE", new GoToAccountPageCommand());
        commands.put("GO_TO_ROOMS_PAGE", new GoToRoomsPageCommand());
        commands.put("GO_TO_AVAILABLE_ROOMS_PAGE", new GoToAvailableRoomsPageCommand());
        commands.put("GO_TO_MY_BOOKINGS_PAGE", new GoToMyBookingsPageCommand());
        commands.put("GO_TO_ALL_REQUESTS_PAGE", new GoToAllRequestsPageCommand());
    }

    public Command getCommand(String commandName) {
        Command command = commands.get(commandName);
        return command;
    }
}
