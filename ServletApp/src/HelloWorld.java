// Import required java libraries
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Extend HttpServlet class
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
 
  private String message="";


  public void init() throws ServletException
  {
      message="";
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // Set response content type
      response.setContentType("text/html");
      
      // Actual logic goes here.
//      PrintWriter out = response.getWriter();
    //  out.println("<h1>" + message + "</h1>"); 
      try {
    	  message="";
      String url = "jdbc:oracle:thin:testuser/password@localhost"; 
      Class.forName("oracle.jdbc.driver.OracleDriver");
      //properties for creating connection to Oracle database
      Properties props = new Properties();
      props.setProperty("user", "testdb");
      props.setProperty("password", "password");
    
      //creating connection to Oracle database using JDBC
      Connection conn;
	
		conn = DriverManager.getConnection(url,props);
		String sql ="select * from demo_customers";
		PreparedStatement preStatement = conn.prepareStatement(sql);
		  
	    ResultSet result = preStatement.executeQuery();
	   // System.out.println(result);
       
	    
	    while(result.next()){
	      		 message +=  "<tr>" + "<th> <a href=\"details.jsp?customerId="+result.getInt("customer_id")+"\">"+result.getString("cust_first_name") + "</a></th>" +
	      				"<th>" + result.getString("cust_last_name") + "</th>";
	    }
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

      
     
      
      
      request.setAttribute("message", message);
      getServletContext().getRequestDispatcher("/output.jsp").forward(request,response);
   } 
  
  

   public void destroy() 
   { 
    //message=""; 
   } 
}
