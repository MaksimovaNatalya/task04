package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.util.Util;
import by.epam.tc.project.entity.Room;
import by.epam.tc.project.service.RoomService;
import by.epam.tc.project.service.ServiceProvider;
import by.epam.tc.project.service.UserService;
import by.epam.tc.project.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class FindRoomCommand implements Command {
    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final RoomService ROOM_SERVICE = PROVIDER.getRoomService();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     Date startDate = Date.valueOf(request.getParameter(Util.Utility.START_DATE));
        Date endDate = Date.valueOf(request.getParameter(Util.Utility.END_DATE));
        int guestsNumber = Integer.parseInt(request.getParameter(Util.Utility.GUESTS_NUMBER));

        List<Room> availableRooms;
        try {


            availableRooms=ROOM_SERVICE.findAvailableRooms(startDate,endDate,guestsNumber);
            if(availableRooms.size()>0) {
                request.setAttribute(Util.Utility.AVAILABLE_ROOMS, availableRooms);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/availableRooms.jsp");
                dispatcher.forward(request,response);
            }else{
                response.sendRedirect(Util.Redirect.TO_REQUEST_PAGE+Util.Message.PARAM_MESSAGE+Util.Message.NO_AVAILABLE_ROOMS);
            }
            } catch (ServiceException e) {
            response.sendRedirect(Util.Redirect.TO_ERROR_PAGE);
        }
    }
}
