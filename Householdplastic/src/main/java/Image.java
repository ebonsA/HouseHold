

import java.io.IOException;
import java.io.OutputStream;
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

/**
 * Servlet implementation class Image
 */
@WebServlet("/Image")
public class Image extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plastic", "root", "Merry724#");
			Statement stmt = con.createStatement();  
			PreparedStatement pstmt = null;
			String query = "SELECT image FROM products";
			try {
				pstmt = con.prepareStatement(query);
				
				ResultSet rs = pstmt.executeQuery();
				   if(rs.next()){
				    byte [] imageData = rs.getBytes("image"); // extract byte data from the resultset..
				    OutputStream os = response.getOutputStream(); // output with the help of outputStream 
				             os.write(imageData);
				             os.flush();
				             os.close();
				   }
				  } catch (SQLException e) {
				   // TODO Auto-generated catch block
				   e.printStackTrace();
				   response.getOutputStream().flush();
				   response.getOutputStream().close();
				  }
		        
		         
		         
		         int status = pstmt.executeUpdate();
		         if(status > 0) 
		           out.println("...");
		            
		         
			}
				
			catch(Exception e){
		         e.printStackTrace();
			}
		
	}
}
