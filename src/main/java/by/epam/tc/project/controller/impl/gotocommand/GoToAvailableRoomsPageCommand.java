package by.epam.tc.project.controller.impl.gotocommand;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.constant.Constant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.tc.project.controller.constant.Constant.Utility.URL;

public class GoToAvailableRoomsPageCommand implements Command {
    private final String URL_NAME = "/task4/Controller?command=GO_TO_AVAILABLE_ROOMS_PAGE";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession(true).setAttribute(URL, URL_NAME);

        RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.Forward.TO_AVAILABLE_ROOMS_PAGE);
        dispatcher.forward(request, response);
    }
}
