package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String login = request.getParameter("login");
        String password = request.getParameter("password");


        // save data in DB

        boolean flag = true; //stub (в будущем получает результат реального сохранения в БД)
        if (flag){
         //   request.setAttribute("registrationInfo", "Registration Completed");
            response.sendRedirect("Controller?command=GO_TO_MAIN_PAGE&registrationInfo=" +"Registration Completed");
         //   RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainPage.jsp");
         //   dispatcher.forward(request,response);
        } else {
            request.setAttribute("errorMessage", "Smth is wrong");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
            dispatcher.forward(request,response);
        }
    }
}