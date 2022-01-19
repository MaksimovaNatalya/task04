package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.util.Util;
import by.epam.tc.project.dao.db.TableAndColumnName;
import by.epam.tc.project.entity.Role;
import by.epam.tc.project.entity.User;
import by.epam.tc.project.service.ServiceProvider;
import by.epam.tc.project.service.UserService;
import by.epam.tc.project.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthorizationCommand implements Command {
    private static final String PARAM_MESSAGE = "&message=";

    ServiceProvider provider = ServiceProvider.getInstance();
    UserService userService = provider.getUserService();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String login = request.getParameter(TableAndColumnName.LOGIN);
        String password = request.getParameter(TableAndColumnName.PASSWORD);

        try {
           if (TableAndColumnName.LOGIN==null || TableAndColumnName.PASSWORD==null){

           }
           User user = userService.authorization(login, password);
           if(user!=null){
               request.getSession().setAttribute(TableAndColumnName.LOGIN, login);
               request.getSession().setAttribute(TableAndColumnName.USER_ROLES_ROLE_NAME, Role.valueOf(user.getRoleId().toString()));
               response.sendRedirect(Util.Redirect.TO_ACCOUNT_PAGE + PARAM_MESSAGE +Util.Message.AUTHORIZATION_SUCCESS);
           } else {
               response.sendRedirect(Util.Redirect.TO_AUTHORIZATION_PAGE + PARAM_MESSAGE +Util.Message.AUTHORIZATION_ERROR);
           }
        } catch (ServiceException e) {
           //log
            response.sendRedirect(Util.Redirect.TO_ERROR_PAGE);
        }



        }

    }

