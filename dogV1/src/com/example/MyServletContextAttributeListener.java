package com.example;

import javax.servlet.*;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {
  public void attributeAdded(ServletContextAttributeEvent event) {
    System.out.println("### attributeAdded ###");
    System.out.println("##### name -> " + event.getName());
    System.out.println("##### value -> " + event.getValue());
  }

  public void attributeRemoved(ServletContextAttributeEvent event) {
    System.out.println("### attributeRemoved ###");
  }

  public void attributeReplaced(ServletContextAttributeEvent event) {
    System.out.println("### attributeReplaced ###");
  }
}
