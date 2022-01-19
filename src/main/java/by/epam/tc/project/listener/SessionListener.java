package by.epam.tc.project.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    public SessionListener() {
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session created: ID = " + httpSessionEvent.getSession().getId());
        //TODO add log, delete sout
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session destroyed: ID = " + httpSessionEvent.getSession().getId());
        //TODO add log, delete sout
    }
}
