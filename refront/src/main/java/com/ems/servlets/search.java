package com.ems.servlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
super();
// TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();     
		int Pinnumber =Integer.parseInt(request.getParameter("pinnumber"));
 
try{

 Class.forName("oracle.jdbc.driver.OracleDriver");

 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##harish123","Harish123");    

 PreparedStatement ps=con.prepareStatement("select * from resultdata where Pinnumber=?");
  ps.setInt(1,Pinnumber);
 ResultSet rs=ps.executeQuery();    
 ResultSetMetaData rsmd=rs.getMetaData();


 while(rs.next())

 {
	 
	 out.println("<html>");
  	out.println("<head>");
  	out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css'/>");
  	out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css'/>");
  	out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>");
  	out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
  	out.println("<link rel=\"stylesheet\" href=\"styles1.css\"/>");

  	out.println("<style>");
  	out.println(".table-header-info {");
  	out.println("background-color: #fff");
 	out.println("padding: 4px 10px");
    out.println(" border: 1px solid #dedede");
    out.println(" padding-left:36% ");
  	out.println("}");
  	out.println("tbody{");
  	out.println(" display: table-row-group;");
 	out.println("vertical-align: middle;");
    out.println("border-color: inherit;");
  	out.println("}");
  	out.println("table{");
  	out.println("  font-family: \"Trebuchet MS\",\"Arial\";;");
 	out.println("font-size: 20px;s");
    out.println("text-align: left;");
  	out.println("}");
  	out.println(".demo{");
  	out.println("position:absolute;");
  	out.println("left:28px;");
  	out.println("top:380px;");
  	out.println("font-size:17;");
  	out.println("font-family:Arial;");
  	out.println("font-weight:bold;");
  	out.println("margin-top:5%;");
  	out.println("margin-left:36%;");
  	out.println("border-collapse:collapse;");
  out.println("}");
out.println("</style>");
  	out.println("</head>");
  	out.println("<body>");
  	out.println("<div class=\"div1\">");
    out.println("<img src=\"images/headernewlogo.jpg\" width=\"100%\" height=auto%\r\n"
  		+ "	\" align=\"center\" />");
  out.println("</div>");
  out.println("<center><h1>Result:</h1></center>");
  out.println("<form action=\"search\" method=\"post\">");
  out.println("<table width=\"60%\" border=\"0\" align=\"center\" cellpadding=\"0\"\r\n"
  		+ "cellspacing=\"0\">");
  out.println("<tr>");
  out.println("<td align=\"center\"><table width=\"350\" border=\"0\"");
  out.println("cellpadding=\"0\" cellspacing=\"0\" class=\"tableboarder\">");
  out.println("<tr>");
  out.println("<td width=\"300\" align=\"center\" valign=\"top\" class=\"text\"><table");
  out.println("width=\"400\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"");
  out.println("align=\"center\">");
  out.println("<tr>");
  out.println("<td height=\"20\" colspan=\"3\" valign=\"top\" class=\"back2\">&nbsp;</td>");
  out.println("</tr>");
  out.println("<tr>");
  out.println("<td width=\"6%\" height=\"35\">&nbsp;</td>");
  out.println("<td width=\"94%\" height=\"35\" colspan=\"2\" valign=\"bottom\"><table\r\n"
  		+ "	width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
  out.println("<tr>");
  out.println("<td class=\"style1\"></td>");
  out.println("<td class=\"style1\"></td>");
  out.println("<td class=\"style1\"></td>");
  out.println("</tr>");
  out.println("<tr>");
  out.println("</tr>");
  out.println("<tr>");
  out.println("<td height=\"25\">Roll Number</td>");
  out.println("<td><input type=\"number\" name=\"pinnumber\"></td>");
  out.println("</tr>");
  out.println("</table></td>");
  out.println("</tr>");
  out.println("<tr>");
  out.println("<td height=\"20\">&nbsp;</td>");
  out.println("<td height=\"20\" colspan=\"2\">&nbsp;</td>");
  out.println("</tr>");
  out.println("<tr>");
  out.println("<td height=\"20\">&nbsp;</td>");
  out.println("<td height=\"20\" colspan=\"2\" align=\"center\"><span\r\n"
  		+ "class=\"style3\"> <input type=\"submit\"\r\n"
  		+ "	value=\"search\" />\r\n"
  		+ "	</span></td>");
  out.println("<td>");
  out.println("</td>");
  out.println("</tr>");
  out.println("<tr>");
  out.println("<td height=\"20\">&nbsp;</td>");
  out.println("<td height=\"20\" colspan=\"2\">&nbsp;</td>");
  out.println("</tr>");
  out.println("</table>");
  out.println("</tr>");
  out.println("</table></td>");
  out.println("</tr>");
  out.println("</table></td>");
  out.println("</form>");


  out.println("<DIV class=\"demo\">");
  out.println("<table width=400 border=1>");
  out.println("<tr>");
  out.println("<tr><td>"+rsmd.getColumnName(1)+"</td>");
  out.println("<td><font color=red>"+rs.getInt(1)+"</td></tr></font>");

 out.println("<tr><td>"+rsmd.getColumnName(2)+"</td>");

 out.println("<td><font color=blue>"+rs.getString(2)+"</td></tr></font>");

 out.println("<tr><td>"+rsmd.getColumnName(3)+"</td>");

 out.println("<td>"+rs.getString(3)+"</td></tr>");
 out.println("<tr><td>"+rsmd.getColumnName(4)+"</td>");

 out.println("<td>"+rs.getInt(4)+"</td></tr>");
 out.println("<tr><td>"+rsmd.getColumnName(5)+"</td>");

 out.println("<td>"+rs.getInt(5)+"</td></tr>");
 out.println("<tr><td>"+rsmd.getColumnName(6)+"</td>");

 out.println("<td>"+rs.getInt(6)+"</td></tr>");
 out.println("<tr><td>"+rsmd.getColumnName(7)+"</td>");

 out.println("<td>"+rs.getInt(7)+"</td></tr>");

 out.println("<tr><td>"+rsmd.getColumnName(8)+"</td>");

 out.println("<td>"+rs.getInt(8)+"</td></tr>"); 
 
 

 
 out.println("</br>");
 out.println("</table>");

 out.println("</body>");

 out.println("</html>");
 
 }
 
 
 if(Pinnumber==0) {
	 out.print("https://www.c-sharpcorner.com/UploadFile/fd0172/how-to-fetch-records-from-database-using-servlet-in-java/");
 }

  }catch (Exception e2)
    
    { 

e2.printStackTrace();

    }



  finally{out.close();

    }

}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
