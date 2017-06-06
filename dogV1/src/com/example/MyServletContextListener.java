package com.example;

import javax.servlet.*;

public class MyServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext(); // Ask the event for the ServletContext
		String dogBreed = sc.getInitParameter("breed"); // Use the context to get the init parameter.
		Dog d = new Dog(dogBreed);
		sc.setAttribute("dog", d);
		System.out.println("### initialized ###");
	}

	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("### destroyed ###");
	}
}
