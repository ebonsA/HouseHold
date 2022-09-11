
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/CustomerRegister")
public class CustomerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		this.firstName = request.getParameter("firstName");
		
		if(request.getParameter("firstName") != null) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plastic", "root", "Merry724#");
			
			String query = "INSERT INTO customer(firstName, lastName, email, gender, location, phone, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			try {
				
		         pstmt.setString(1, firstName);
		         pstmt.setString(2, request.getParameter("lastName"));
		         pstmt.setString(3, request.getParameter("email"));
		         pstmt.setString(4, request.getParameter("gender"));
		         pstmt.setString(5, request.getParameter("location"));
		         pstmt.setString(6, request.getParameter("telephone"));
		         pstmt.setString(7, request.getParameter("password"));
		         
		         int status = pstmt.executeUpdate();
		         if(status > 0) 
		            out.println("");
		            response.sendRedirect("Login.jsp");
		         
			}
				
			catch(Exception e){
		         e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	} 
}
