package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeLanguageCommand implements Command
{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String language = request.getParameter(Util.Utility.LANGUAGE);
        request.getSession().setAttribute(Util.Utility.LANGUAGE, language);
        String url = (String) request.getSession().getAttribute(Util.Utility.URL);
        response.sendRedirect(url);
    }
}
