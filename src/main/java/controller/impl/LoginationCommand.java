package controller.impl;

import controller.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String name;
        String password;
        name = request.getParameter("username");
        password = request.getParameter("password");

        out.println("Hello,");
        out.println(name);
        out.println(password);

        boolean flag = true;//stub (в будущем получает результат реального сохранения в БД)
        String userName = "Vasya";

        HttpSession session = request.getSession(true);
        session.setAttribute("userName", userName);

        if (flag){
        //    request.setAttribute("userName", "Vasya");
            response.sendRedirect("MyController?command=GO_TO_MAIN_PAGE&userName=" +"Vasya");
        //    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainPage.jsp");
        //    dispatcher.forward(request,response);
        } else {

        }

    }
}
