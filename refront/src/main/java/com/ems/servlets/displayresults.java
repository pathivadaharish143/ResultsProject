package com.ems.servlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import resultsbackend.resultsDAO;
import resultsbackend.Students;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AvailableEmployees
 */
//@WebServlet("/url")

@WebServlet("/displayresults")
public class displayresults extends HttpServlet {
private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
resultsDAO dao = new resultsDAO();
List<Students> empList = dao.displayresults();
//Use RequestDispatcher to redirect to a new jsp ir html page
PrintWriter out = resp.getWriter();
out.println("<html>");
out.println("<head>");
out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css'/>");
out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css'/>");
out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>");
out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
out.println("<link rel=\"stylesheet\" href=\"styles1.css\"/>");
out.println("<style>");
out.println(".nav-link{");
out.println("padding-left:20%;");
out.println("color:white;");
out.println("font-size: 20px;");
out.println("}");
out.println(".navbar-dark{");
out.println(" height:auto;");
out.println(" width:auto;");
out.println("background-color: #6A5ACD;");
out.println("padding-left:22%;");
out.println("}");
out.println(".navbar-brand{");
out.println("font-family:Lucida Handwriting;");
out.println("font-size: 20px;");
out.println("line-height: 32px;");
out.println(" color: #FFFFFF; ");
out.println("text-decoration: none;");
out.println("font-weight: 400;");
out.println(" }");
out.println("</style>");
out.println("</head>");
out.println("<body>");
out.println("<div class=\"div1\">");
out.println("<img src=\"images/headernewlogo.jpg\" width=\"100%\" height=auto%\r\n"
		+ "	\" align=\"center\" />");
out.println("</div>");
out.println("<div id=\"div2\">");
out.println("<nav class=\"navbar navbar-expand-lg navbar-dark\">\r\n"
+ "");
  out.println("<div class=\"container-fluid\">");
out.println("<a class=\"navbar-brand\" href=\"#\"></a>");
out.println(" <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
+ "");
out.println(" <span class=\"navbar-toggler-icon\"></span>");
out.println("</button>");
out.println("<div class=\"collapse navbar-collapse\" id=\"navbarNav\">");
out.println("<ul class=\"navbar-nav\">");
out.println("<li class=\"nav-item\">");
out.println("<a href=\"AvailableEmployees\" class=\"nav-link\">ADMIN</a>");
out.println("</li>");
out.println("<a href=\"responses\"class=\"nav-link\">UPLOAD RESULTS</a>");
out.println("</li>");
 out.println("<li class=\"nav-item\">");
 out.println("<a href=\"responses\"class=\"nav-link\">ACADMIC YEARS</a>");
 out.println("</li>");
 out.println("<li class=\"nav-item\">");
 out.println("<a href=\"responses\" class=\"nav-link\">SERVICES</a>");
 out.println("</li>");
 out.println("<li class=\"nav-item\">");
 out.println("<a href=\"responses\"class=\"nav-link\">SIGN UP</a>");
 out.println("</li>");
 out.println("<li class=\"nav-item\">");
 out.println("<a href=\"AdminRegistration.html\"class=\"nav-link\">LOGOUT</a>");
 out.println("</li>");
 out.println("<form class=\"d-flex\">");
 out.println("<input class=\"form-control me-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">");
 out.println("<button class=\"btn btn-outline-success\" type=\"submit\">Search</button>");
 out.println(" </form>");
 out.println("<li class=\"nav-item dropdown\">"); 
 out.println("<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDarkDropdownMenuLink\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">"); 
 out.println("<i class='fas fa-user-alt' style='font-size:34px;padding-left:97%;'></i></a>");   
 out.println("<ul class=\"dropdown-menu dropdown-menu-dark\" aria-labelledby=\"navbarDarkDropdownMenuLink\">"); 
 out.println("<li><a class=\"dropdown-item\" href=\"#\">Edit Profile</a></li>");  
 out.println("<li><a class=\"dropdown-item\" href=\"#\">Help</a></li>"); 
 out.println("<li><a class=\"dropdown-item\" href=\"Login.html\">Logout</a></li></ul>"); 
 out.println("</li>");
 out.println("</ul>");
 out.println("</nav>");
 out.println("</div>");
 out.println("</div>");

 out.println("<div style=\"overflow-x:auto;\">");
out.println("<div class='container'>");
out.println("<table class='table table-hover'");
out.println("<thead class='bg-primary'>");
out.println("<tr>");
out.println("<th>PIN NUMBER</th>");
out.println("<th>STUDENT NAME</th>");
out.println("<th>Gender</th>");
out.println("<th>TELUGU</th>");
out.println("<th>ENGLISH</th>");
out.println("<th>MATHS</th>");
out.println("<th>PHYSICS</th>");
out.println("<th>CHEMISTRY</th>");
out.println("<th>MODIFY</th>");
out.println("</tr>");
out.println("</thead>");
out.println("<tbody>");
for(Students resu : empList){
out.println("<tr>");
out.println("<td>"+resu.getPinnumber()+"</td>");
out.println("<td>"+resu.getName()+"</td>");
out.println("<td>"+resu.getGender()+"</td>");
out.println("<td>"+resu.getTelugu()+"</td>");
out.println("<td>"+resu.getEnglish()+"</td>");
out.println("<td>"+resu.getMaths()+"</td>");
out.println("<td>"+resu.getPhysics()+"</td>");
out.println("<td>"+resu.getChemistry()+"</td>");
out.println("<td><a class='btn btn-info' href='update?id="+resu.getPinnumber()+"'><i class=\"fa-solid fa-user-pen\"></i></a> <a class='btn btn-danger' href='delEmployee?id="+resu.getPinnumber()+"'><i class=\"fa-solid fa-user-pen\"></i></a></td>");
out.println("</tr>");
}
out.println("</tbody>");
out.println("<table/>");
out.println("</div>");
out.println("</div>");
out.println("</body>");

out.println("</html>");
}
}

