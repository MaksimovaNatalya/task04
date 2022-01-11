package controller.impl;

import controller.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String userName;
        String password;
        userName = request.getParameter("username");
        password = request.getParameter("password");

        out.println("Hello,");
        out.println(userName);
        out.println(password);

        boolean flag = true; //stub (в будущем получает результат реального сохранения в БД)
        if (flag){
            request.setAttribute("userName", "Vasya");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainPage.jsp");
            dispatcher.forward(request,response);
        }

    }
}
