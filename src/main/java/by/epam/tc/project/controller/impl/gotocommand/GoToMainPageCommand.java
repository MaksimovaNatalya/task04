package by.epam.tc.project.controller.impl.gotocommand;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.constant.Constant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.epam.tc.project.controller.constant.Constant.Utility.LANGUAGE;
import static by.epam.tc.project.controller.constant.Constant.Utility.URL;

public class GoToMainPageCommand implements Command {

    private final String URL_NAME = "/task4/Controller?command=GO_TO_MAIN_PAGE";
    private final String EN = "en";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        session.setAttribute(URL, URL_NAME);

        String language = (String) session.getAttribute(LANGUAGE);

        if (language == null) {
            session.setAttribute(LANGUAGE, EN);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.Forward.TO_MAIN_PAGE);
        dispatcher.forward(request, response);
    }
}
