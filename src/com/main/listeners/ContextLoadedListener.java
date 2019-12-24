package com.main.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoadedListener implements ServletContextListener {

  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("contextInitialized method called");
    sce.getServletContext().setInitParameter("newContext", "newContextValue");
  }

  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("contextDestroyed method called");
  }

}
