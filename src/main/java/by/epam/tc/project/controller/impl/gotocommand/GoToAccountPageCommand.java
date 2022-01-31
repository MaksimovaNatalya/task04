package by.epam.tc.project.controller.impl.gotocommand;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.constant.Constant;
import by.epam.tc.project.entity.User;
import by.epam.tc.project.service.ServiceProvider;
import by.epam.tc.project.service.UserService;
import by.epam.tc.project.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToAccountPageCommand implements Command {

    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final UserService USER_SERVICE = PROVIDER.getUserService();
    private final String LOGIN = "login";
    private final String USER = "user";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String login = (String) session.getAttribute(LOGIN);
        User user;
        try {
            user = USER_SERVICE.getUser(login);
            request.setAttribute(USER, user);

            RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.Forward.TO_ACCOUNT_PAGE);
            dispatcher.forward(request, response);

        } catch (ServiceException e) {
            //log
            e.printStackTrace();
        }
    }
}

