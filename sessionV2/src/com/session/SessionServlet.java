package com.session;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class SessionServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
    HttpServletResponse response) throws IOException, ServletException {
      response.setContentType("text/html");

      PrintWriter html = response.getWriter();

      html.println("<html>");
      html.println("<body>");
      html.println("<h1>Session!</h1>");

      html.println("<form action='Session.do' method='post'>");

      HttpSession session = request.getSession(false);

      String username = getUsername(session);

      if(username != null)
        html.println("Bem-vindo: " + username + " <br>");
      else {
        html.println("Nome: <input type='text' name='username' size='55' />");
        html.println("Senha: <input type='password' name='password' size='55' />");
        html.println("<input type='submit' name='dologin' value='Entra' /> <br>");
      }

      html.println("</form>");

      html.println("</body>");
      html.println("</html>");
    }

    private String getUsername(HttpSession session) {
      if(session == null)
        return null;

      return (String) session.getAttribute("username");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        response.sendRedirect("Session.do");
    }
}
