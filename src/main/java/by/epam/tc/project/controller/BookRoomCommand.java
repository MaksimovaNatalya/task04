package by.epam.tc.project.controller;

import by.epam.tc.project.controller.util.Util;
import by.epam.tc.project.dao.db.TableAndColumnName;
import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Request;
import by.epam.tc.project.entity.User;
import by.epam.tc.project.service.RequestService;
import by.epam.tc.project.service.RoomService;
import by.epam.tc.project.service.ServiceProvider;
import by.epam.tc.project.service.UserService;
import by.epam.tc.project.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

public class BookRoomCommand implements Command {
    private final String IN_PROGRESS = "in progress";
    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final RequestService REQUEST_SERVICE = PROVIDER.getRequestService();
    private static final UserService USER_SERVICE = PROVIDER.getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String login = (String) session.getAttribute(TableAndColumnName.LOGIN);
        try {

            String category = (String) session.getAttribute("room.category");
            int maxPersons = (int) session.getAttribute("room.maxPersons");
            Date startDate = (Date) session.getAttribute("startDate");
            Date endDate = (Date) session.getAttribute("endDate");
            String status = IN_PROGRESS;
            User user = USER_SERVICE.getUser(login);
            int roomId = (int) session.getAttribute("room.id");
            REQUEST_SERVICE.addRequest(new Request(category, maxPersons, startDate, endDate, status, user.getId(), roomId));
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/requestConfirmation.jsp");
            dispatcher.forward(request, response);
        } catch (ServiceException e) {
            response.sendRedirect(Util.Redirect.TO_ERROR_PAGE);
        }
    }
}
