package com.main.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.main.util.ServletUtil;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(description = "My First Servlet", urlPatterns = { "/FirstServlet", "/FirstServlet.do" }, initParams = {
    @WebInitParam(name = "id", value = "1"), @WebInitParam(name = "name", value = "pankaj") }, loadOnStartup = 1)
public class FirstServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public static final String HTML_START = "<html><body>";
  public static final String HTML_END = "</body></html>";

  @Override
  public void init() throws ServletException {
    System.out.println("FirstServlet init method");
  }

  /**
   * @see HttpServlet#HttpServlet()
   */
  public FirstServlet() {
    super();
    System.out.println("FirstServlet constructor");
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("FirstServlet service method");
    ServletUtil servletUtil = ServletUtil.getInstance();
    // servletUtil.iterateServletInitParams(getServletConfig());
    servletUtil.iterateContextInitParams(getServletConfig());
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    PrintWriter out = response.getWriter();
    Date date = new Date();
    out.println(HTML_START + "<h2>Hi There!</h2><br/><h3>Date=" + date + "</h3>" + HTML_END);
    ServletContext context = getServletConfig().getServletContext();
    context.setAttribute("contextAtributeParam1", "contextAtributeParamValue1");
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
  }

}
