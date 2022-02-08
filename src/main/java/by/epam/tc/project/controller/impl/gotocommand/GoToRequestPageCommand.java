package by.epam.tc.project.controller.impl.gotocommand;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.constant.Constant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;

import static by.epam.tc.project.controller.constant.Constant.Utility.LOGIN;
import static by.epam.tc.project.controller.constant.Constant.Utility.URL;

public class GoToRequestPageCommand implements Command {
    private final String URL_NAME = "/task4/Controller?command=GO_TO_REQUEST_PAGE";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession(true).setAttribute(URL, URL_NAME);

        if (request.getSession(true).getAttribute(LOGIN) == null) {
            response.sendRedirect(Constant.Redirect.TO_AUTHORIZATION_PAGE + Constant.Message.PARAM_MESSAGE + Constant.Message.AUTHORIZATION_OBLIGATORY);
            return;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.Forward.TO_REQUEST_PAGE);
        dispatcher.forward(request, response);
    }
}
