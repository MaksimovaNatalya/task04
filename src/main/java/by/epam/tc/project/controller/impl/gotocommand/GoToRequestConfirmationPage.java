package by.epam.tc.project.controller.impl.gotocommand;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.constant.Constant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToRequestConfirmationPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.Forward.TO_REQUEST_CONFIRMATION_PAGE);
        dispatcher.forward(request, response);
    }
}
