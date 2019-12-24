package com.main.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Single thread model servlet is calling service method only one instance per
 * time. (i.e.) If we have more load it is creating multiple servlet instances
 * and allocating the instance to particular thread for processing
 * 
 * Normal servlet will create only one instance and that instance only will be
 * passed to multiple request calling via thread.
 * 
 * SingleThreadModel is deprecated from servlet 2.4 onwards because the service
 * method only has been synchronized but the session and context objects are not
 * feasible for multithreaded
 * 
 * @author Surendar
 *
 */
@WebServlet(name = "SingleThreadModelServlet", description = "Single thread model servlet", urlPatterns = {
    "/homeServlet", "/home/homeServlet" }, initParams = { @WebInitParam(name = "test", value = "testing"),
        @WebInitParam(name = "test1", value = "testing1") }, asyncSupported = false, displayName = "SingleThreadModelServlet")
public class SingleThreadModelServlet extends GenericServlet implements SingleThreadModel {

  private static final long serialVersionUID = 1L;
  public static final String HTML_START = "<html><body>";
  public static final String HTML_END = "</body></html>";

  @Override
  public void init() throws ServletException {
    System.out.println("SingleThreadModelServlet init method");
  }

  public SingleThreadModelServlet() {
    System.out.println("SingleThreadModelServlet constructor");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println("SingleThreadModelServlet service method");
    // ServletUtil servletUtil = ServletUtil.getInstance();
    // servletUtil.iterateServletInitParams(getServletConfig());
    // servletUtil.iterateContextInitParams(getServletConfig());
    PrintWriter out = res.getWriter();
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Date date = new Date();
    out.println(HTML_START + "<h2>Hi There!</h2><br/><h3>Date=" + date + "</h3>" + HTML_END);
    out.close();  
  }

}
