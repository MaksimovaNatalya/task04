package by.epam.tc.project.listener;

import jdk.internal.org.jline.utils.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestListener implements ServletRequestListener {

    private final static Logger LOG = LogManager.getLogger(RequestListener.class);

    public RequestListener() {
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        LOG.info("Request:" + request.getRequestURI() + "with ID" + request.getRequestedSessionId() + "was destroyed");

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        LOG.info("Request:" + request.getRequestURI() + "with ID" + request.getRequestedSessionId() + "was initialized");

    }
}
