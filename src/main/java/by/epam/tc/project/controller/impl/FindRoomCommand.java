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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class FindRoomCommand implements Command {
    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final RoomService ROOM_SERVICE = PROVIDER.getRoomService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {

            Date startDate = Date.valueOf(request.getParameter("startDate"));
            session.setAttribute("startDate", startDate);
            Date endDate = Date.valueOf(request.getParameter("endDate"));
            session.setAttribute("endDate", endDate);

            int guestsNumber = Integer.parseInt(request.getParameter(Constant.Utility.GUESTS_NUMBER));

            List<Room> availableRooms;

            availableRooms = ROOM_SERVICE.findAvailableRooms(startDate, endDate, guestsNumber);
            if (availableRooms.size() > 0) {
                request.setAttribute(Constant.Utility.AVAILABLE_ROOMS, availableRooms);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/availableRooms.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect(Constant.Redirect.TO_REQUEST_PAGE + Constant.Message.PARAM_MESSAGE + Constant.Message.NO_AVAILABLE_ROOMS);
            }
        } catch (ServiceException e) {
            response.sendRedirect(Constant.Redirect.TO_ERROR_PAGE);
        }
    }
}
