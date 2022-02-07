package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.constant.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeLanguageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String language = request.getParameter(Constant.Utility.LANGUAGE);
        HttpSession session = request.getSession(true);
        request.getSession().setAttribute(Constant.Utility.LANGUAGE, language);
        String url = (String) session.getAttribute(Constant.Utility.URL);
        response.sendRedirect(url);
    }
}
