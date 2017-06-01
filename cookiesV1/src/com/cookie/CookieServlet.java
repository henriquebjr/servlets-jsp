package com.cookies;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CookieServlet extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html");

    PrintWriter html = response.getWriter();

    html.println("<html>");
    html.println("<body>");
    html.println("<h1>Cookies 5!</h1>");

    html.println("<form action='Cookie.do' method='post'>");

    String name = getUsername(request);

    if(name != null)
      html.println("Nome: " + name + " <br>");
    else {
      html.println("Nome: <input type='text' name='username' size='55' />");
      html.println("<input type='submit' name='adduser' value='Add' /> <br>");
    }

    html.println("</form>");

    html.println("</body>");
    html.println("</html>");
  }

  private String getUsername(HttpServletRequest request) {
    if(request.getCookies() == null)
      return null;

    for(Cookie cookie : request.getCookies())
      if(cookie.getName().equals("username"))
        return cookie.getValue();
    return null;
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
      String username = request.getParameter("username");
      Cookie cookie = new Cookie("username", username);
      response.addCookie(cookie);
      response.sendRedirect("Cookie.do");
  }
}
