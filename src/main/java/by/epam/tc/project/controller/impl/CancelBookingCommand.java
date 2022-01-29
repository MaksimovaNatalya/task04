package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.service.RequestService;
import by.epam.tc.project.service.RoomService;
import by.epam.tc.project.service.ServiceProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CancelBookingCommand implements Command {
    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final RequestService REQUEST_SERVICE = PROVIDER.getRequestService();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
