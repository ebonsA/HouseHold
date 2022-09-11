
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
@WebServlet("/Employee")
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String firstNames;
	private String lastNames;
	private String emails;
	private int ages;
	private String gender;
	private String productCategory;
	private String contract;
	private String telephone;
	
	
	
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		this.firstNames = request.getParameter("firstName");
		this.lastNames = request.getParameter("lastName");
		this.emails = request.getParameter("email");
		this.ages = Integer.parseInt(request.getParameter("age"));
		this.gender = request.getParameter("gender");
		this.productCategory = request.getParameter("productCategory");
		this.contract = request.getParameter("contract");
		//this.telephone = Integer.parseInt(request.getParameter("telephone"));
		this.telephone = request.getParameter("telephone");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plastic", "root", "Merry724#");
			Statement stmt = con.createStatement();  
			PreparedStatement pstmt = null;
			String query = "INSERT INTO employee(firstName, lastName, email, phone, age, gender, productCategory,contractTerm) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				pstmt = con.prepareStatement(query);
		         pstmt.setString(1, firstNames);
		         pstmt.setString(2, lastNames);
		         pstmt.setString(3, emails);
		         pstmt.setString(4, telephone);
		         pstmt.setInt(5, ages);
		         pstmt.setString(6, gender);
		         pstmt.setString(7, productCategory);		         
		         pstmt.setString(8, contract);
		         
		         int status = pstmt.executeUpdate();
		         if(status > 0) 
		            
		            response.sendRedirect("EmployeeReport.jsp");
		            
		          
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
