package com.main.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextAttributeListenerEx implements ServletContextAttributeListener {

  public void attributeAdded(ServletContextAttributeEvent event) {
    System.out.println("attributeAdded method called");
    // The below line will print all the attributes. 
    //ServletUtil.getInstance().iterateContextAttributes(event.getServletContext());
  }

  public void attributeRemoved(ServletContextAttributeEvent event) {
    System.out.println("attributeRemoved method called");
    //ServletUtil.getInstance().iterateContextAttributes(event.getServletContext());
  }

  public void attributeReplaced(ServletContextAttributeEvent event) {
    System.out.println("attributeReplaced method called");
    //ServletUtil.getInstance().iterateContextAttributes(event.getServletContext());
  }

}
