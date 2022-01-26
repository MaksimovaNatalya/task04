package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.util.Util;
import by.epam.tc.project.dao.db.TableAndColumnName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOutCommand implements by.epam.tc.project.controller.Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        session.removeAttribute(TableAndColumnName.LOGIN);

        response.sendRedirect(Util.Redirect.LOG_OUT);
    }
}
