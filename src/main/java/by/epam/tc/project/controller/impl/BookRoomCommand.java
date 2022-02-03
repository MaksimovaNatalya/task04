package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.constant.Constant;
import by.epam.tc.project.dao.db.TableAndColumnName;
import by.epam.tc.project.entity.Request;
import by.epam.tc.project.entity.User;
import by.epam.tc.project.service.RequestService;
import by.epam.tc.project.service.ServiceProvider;
import by.epam.tc.project.service.UserService;
import by.epam.tc.project.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BookRoomCommand implements Command {
    private final String IN_PROGRESS = "in progress";
    private final String CATEGORY = "room.category";
    private final String MAX_PERSONS = "room.maxPersons";
    private final String START_DATE = "startDate";
    private final String END_DATE = "endDate";
    private final String ROOM_ID = "room.id";
    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final RequestService REQUEST_SERVICE = PROVIDER.getRequestService();
    private static final UserService USER_SERVICE = PROVIDER.getUserService();
    private final static Logger LOG = LogManager.getLogger(BookRoomCommand.class);


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String login = (String) session.getAttribute(TableAndColumnName.LOGIN);
        try {
            String category = (String) session.getAttribute(CATEGORY);
            int maxPersons = (int) session.getAttribute(MAX_PERSONS);
            java.sql.Date startDate = (java.sql.Date) session.getAttribute(START_DATE);
            java.sql.Date endDate = (java.sql.Date) session.getAttribute(END_DATE);
            String status = IN_PROGRESS;
            User user = USER_SERVICE.getUser(login);
            int roomId = (int) session.getAttribute(ROOM_ID);
            REQUEST_SERVICE.addRequest(new Request(category, maxPersons, startDate, endDate, status, user.getId(), roomId));
            RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.Forward.TO_REQUEST_CONFIRMATION_PAGE);
            dispatcher.forward(request, response);
        } catch (ServiceException e) {
            LOG.error(e);
            response.sendRedirect(Constant.Redirect.TO_ERROR_PAGE);
        }
    }
}
