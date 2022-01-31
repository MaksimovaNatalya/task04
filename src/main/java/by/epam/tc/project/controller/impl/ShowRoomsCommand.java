package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.constant.Constant;
import by.epam.tc.project.entity.Room;
import by.epam.tc.project.service.RoomService;
import by.epam.tc.project.service.ServiceProvider;
import by.epam.tc.project.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowRoomsCommand implements Command {
    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final RoomService ROOM_SERVICE = PROVIDER.getRoomService();
    private final String ALL_ROOMS = "allRooms";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Room> allRooms = ROOM_SERVICE.showAllRooms();
            request.setAttribute(ALL_ROOMS, allRooms);
            RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.Forward.TO_ROOMS_PAGE);
            dispatcher.forward(request, response);
        } catch (ServiceException e) {
            response.sendRedirect(Constant.Redirect.TO_ERROR_PAGE);
        }

    }
}
