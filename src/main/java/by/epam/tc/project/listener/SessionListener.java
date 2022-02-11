package by.epam.tc.project.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    private final static Logger LOG = LogManager.getLogger(SessionListener.class);

    public SessionListener() {
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        LOG.info("Session created: ID = " + httpSessionEvent.getSession().getId());

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        LOG.info("Session destroyed: ID = " + httpSessionEvent.getSession().getId());

    }
}
