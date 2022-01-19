package by.epam.tc.project.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestListener implements ServletRequestListener {

    public RequestListener() {
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        System.out.println("Request:" + request.getRequestURI() + "with ID" + request.getRequestedSessionId() + "was destroyed");
        //TODO add log, delete sout
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        System.out.println("Request:" + request.getRequestURI() + "with ID" + request.getRequestedSessionId() + "was initialized");
        //TODO add log, delete sout
    }
}
