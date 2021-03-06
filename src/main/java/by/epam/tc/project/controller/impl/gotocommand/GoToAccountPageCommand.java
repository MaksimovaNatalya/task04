package by.epam.tc.project.controller.impl.gotocommand;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.constant.Constant;
import by.epam.tc.project.controller.impl.AuthorizationCommand;
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

import static by.epam.tc.project.controller.constant.Constant.Utility.URL;

public class GoToAccountPageCommand implements Command {

    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final UserService USER_SERVICE = PROVIDER.getUserService();
        private final static Logger LOG = LogManager.getLogger(GoToAccountPageCommand.class);

    private final String LOGIN = "login";
    private final String USER = "user";
    private final String URL_NAME = "/task4/Controller?command=GO_TO_ACCOUNT_PAGE";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.getSession(true).setAttribute(URL, URL_NAME);
        String login = (String) session.getAttribute(LOGIN);

        User user;
        try {
            user = USER_SERVICE.getUser(login);
            request.setAttribute(USER, user);

            RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.Forward.TO_ACCOUNT_PAGE);
            dispatcher.forward(request, response);

        } catch (ServiceException e) {
            LOG.error(e);
            response.sendRedirect(Constant.Redirect.TO_ERROR_PAGE);
        }
    }
}

