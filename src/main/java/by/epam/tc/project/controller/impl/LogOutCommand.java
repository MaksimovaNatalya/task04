package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.constant.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOutCommand implements by.epam.tc.project.controller.Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        session.invalidate();
        response.sendRedirect(Constant.Redirect.LOG_OUT);
    }
}
