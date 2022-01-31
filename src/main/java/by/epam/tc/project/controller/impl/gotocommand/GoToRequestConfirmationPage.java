package by.epam.tc.project.controller.impl.gotocommand;

import by.epam.tc.project.controller.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToRequestConfirmationPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/requestConfirmation.jsp");
        dispatcher.forward(request, response);
    }
}
