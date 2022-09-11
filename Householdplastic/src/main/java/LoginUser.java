
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet1
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		
		PrintWriter out = response.getWriter();
		
		String emails = request.getParameter("email");
		String passwords = request.getParameter("password");
		
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plastic", "root", "Merry724#");
			Statement stmt = con.createStatement();  
			
			try {
				String query = "SELECT*FROM customer WHERE email = '"+emails+"' AND password = '"+passwords+"'";
				
				ResultSet rs = stmt.executeQuery(query);
				if(rs.next()) {
				
				HttpSession session = request.getSession();
				session.setAttribute(emails, passwords);
				
				out.print("Login Successful");
				response.sendRedirect("welcome.jsp");
			}
				else
					//response.getWriter().append("Login Failured, Try Again");
					response.sendRedirect("LoginAgain.jsp");
					
			}
				
			catch(Exception e){
		         e.printStackTrace();
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	
}
