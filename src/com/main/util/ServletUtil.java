package com.main.util;

import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class ServletUtil {

  private static ServletUtil instance = null;

  private ServletUtil() {
  }

  public static ServletUtil getInstance() {
    if (instance == null) {
      synchronized (ServletUtil.class) {
        if (instance == null) {
          instance = new ServletUtil();
        }
      }
    }
    return instance;
  }

  public void iterateServletInitParams(final ServletConfig config) {
    System.out.println("iterateServletInitParams config :" + config);
    Enumeration<String> initParams = config.getInitParameterNames();
    while (initParams.hasMoreElements()) {
      String paramName = initParams.nextElement();
      System.out.println("paramName :" + paramName + " paramValue :" + config.getInitParameter(paramName));
    }
  }

  public void iterateContextInitParams(final ServletConfig config) {
    ServletContext context = config.getServletContext();
    System.out.println("iterateContextInitParams context :" + context);
    Enumeration<String> initParams = context.getInitParameterNames();
    while (initParams.hasMoreElements()) {
      String paramName = initParams.nextElement();
      System.out.println("paramName :" + paramName + " paramValue :" + context.getInitParameter(paramName));
    }
  }

  public void iterateContextAttributes(final ServletContext context) {
    System.out.println("iterateContextAttributes context :" + context);
    Enumeration<String> initParams = context.getAttributeNames();
    while (initParams.hasMoreElements()) {
      String paramName = initParams.nextElement();
      System.out.println("paramName :" + paramName + " paramValue :" + context.getAttribute(paramName));
    }
  }
}
