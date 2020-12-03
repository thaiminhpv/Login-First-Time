package lms.funix.lab.commons;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static lms.funix.lab.view.View.Path.DAO.*;

public class HelperDAO implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        //do stuff
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        //do stuff before web application is started
        setResourcePath(arg0.getServletContext().getRealPath("/"));
    }

    public static String getFilePath(String file) {
        return getResourcePath() + DATABASE_LOCATION + file;
    }
}
