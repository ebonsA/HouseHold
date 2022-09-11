
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plastic", "root", "Merry724#");
			Statement stmt = con.createStatement();  
			PreparedStatement pstmt = null;
			String query = "INSERT INTO cart(CustomerID,ProductName,OrderPrice, OrderQuantity) VALUES (?, ?, ?, ?)";
			try {
				pstmt = con.prepareStatement(query);
				
		        pstmt.setString(1, request.getParameter("CustomerID"));
		        pstmt.setString(2, request.getParameter("ProductName"));
		        pstmt.setInt(3, Integer.parseInt(request.getParameter("OrderPrice")));
		        pstmt.setInt(4, Integer.parseInt(request.getParameter("OrderQuantity")));
		        
		         
		         
		        RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
	            dispatcher.forward(request,response);
	            out.println("</body>");
	            out.println("</html>");
		         
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
