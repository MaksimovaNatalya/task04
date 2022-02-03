package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.constant.Constant;
import by.epam.tc.project.entity.Room;
import by.epam.tc.project.service.RoomService;
import by.epam.tc.project.service.ServiceProvider;
import by.epam.tc.project.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private final static Logger LOG = LogManager.getLogger(FindRoomCommand.class);

    private final String START_DATE = "startDate";
    private final String END_DATE = "endDate";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {

            Date startDate = Date.valueOf(request.getParameter(START_DATE));
            session.setAttribute(START_DATE, startDate);
            Date endDate = Date.valueOf(request.getParameter(END_DATE));
            session.setAttribute(END_DATE, endDate);

            int guestsNumber = Integer.parseInt(request.getParameter(Constant.Utility.GUESTS_NUMBER));

            List<Room> availableRooms;

            availableRooms = ROOM_SERVICE.findAvailableRooms(startDate, endDate, guestsNumber);
            if (availableRooms.size() > 0) {
                request.setAttribute(Constant.Utility.AVAILABLE_ROOMS, availableRooms);
                RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.Forward.TO_AVAILABLE_ROOMS_PAGE);
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect(Constant.Redirect.TO_REQUEST_PAGE + Constant.Message.PARAM_MESSAGE + Constant.Message.NO_AVAILABLE_ROOMS);
            }
        } catch (ServiceException e) {
            LOG.error(e);
            response.sendRedirect(Constant.Redirect.TO_ERROR_PAGE);
        }
    }
}
