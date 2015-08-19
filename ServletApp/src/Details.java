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
@WebServlet("/Details")
public class Details extends HttpServlet {

	private String message = "";

	public void init() throws ServletException {
		message = "";
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.
		String custName = "";
		try {
			message = "";
			String url = "jdbc:oracle:thin:testuser/password@localhost";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// properties for creating connection to Oracle database
			Properties props = new Properties();
			props.setProperty("user", "testdb");
			props.setProperty("password", "password");

			// creating connection to Oracle database using JDBC
			Connection conn;
			String custId = request.getParameter("customerId");
			conn = DriverManager.getConnection(url, props);
			String sql = "select * from demo_customers where customer_id="
					+ custId;
			PreparedStatement preStatement = conn.prepareStatement(sql);

			ResultSet result = preStatement.executeQuery();
			
			
			if (result.next()) {
				custName = result.getString("cust_first_name") + " "
						+ result.getString("cust_last_name");
				message += "<tr>" + "<th>"
						+ result.getString("cust_street_address1") + "</th>"
						+ "<th>" + result.getString("cust_street_address2")
						+ "</th>" + "<th>" + result.getString("cust_city")
						+ "</th>" + "<th>" + result.getString("cust_state")
						+ "</th>" + "<th>"
						+ result.getString("cust_postal_code") + "</th>"
						+ "<th>" + result.getString("phone_number1") + "</th>"
						+ "<th>" + result.getString("phone_number2") + "</th>"
						+ "<th>" + result.getString("credit_limit") + "</th>"
						+ "<th>" + result.getString("cust_email")
						+ "</th></tr>";
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("message", message);
		request.setAttribute("custName", custName);
		getServletContext().getRequestDispatcher("/details.jsp").forward(
				request, response);
	}

	public void destroy() {
		// message="";
	}
}
