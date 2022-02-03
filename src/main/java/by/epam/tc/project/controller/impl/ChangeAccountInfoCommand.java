package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.constant.Constant;
import by.epam.tc.project.entity.User;
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

public class ChangeAccountInfoCommand implements Command {
    private final static String CHANGE_ACCOUNT_INFO = "/WEB-INF/jsp/account.jsp";
    private final String LOGIN = "login";
    private final String USER = "user";
    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final UserService USER_SERVICE = PROVIDER.getUserService();
    private final static Logger LOG = LogManager.getLogger(ChangeAccountInfoCommand.class);


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute(LOGIN);
        User user;
        try {
            user = USER_SERVICE.getUser(login);
            request.setAttribute(USER, user);
            RequestDispatcher dispatcher = request.getRequestDispatcher(CHANGE_ACCOUNT_INFO);
            dispatcher.forward(request, response);
        } catch (ServiceException e) {
            LOG.error(e);
            response.sendRedirect(Constant.Redirect.TO_ERROR_PAGE);
        }

    }
}
