
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/AddProduct")
@MultipartConfig
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int productId;
	private String productName;
	private String productCategory;
	private int unitPrice;
	private int quantity;
	private String productImage;
	
	
   
	public AddProduct() {
		
	}



	public AddProduct(String productName, String productCategory, int unitPrice, int quantity, String productImage) {
		
		this.productName = productName;
		this.productCategory = productCategory;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.productImage = productImage;
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getProductCategory() {
		return productCategory;
	}



	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}



	public int getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getProductImage() {
		return productImage;
	}



	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		productName = request.getParameter("productName");
		productCategory = request.getParameter("productCategory");
		unitPrice = Integer.parseInt(request.getParameter("unitPrice"));
		quantity = Integer.parseInt(request.getParameter("quantity"));
		productImage = request.getParameter("productImage");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plastic", "root", "Merry724#");
			Statement stmt = con.createStatement();  
			PreparedStatement pstmt = null;
			String query = "INSERT INTO products(productName, productCategory, unitPrice, Quantity, image) VALUES (?, ?, ?, ?, ?)";
			try {
				pstmt = con.prepareStatement(query);
				
		        pstmt.setString(1, productName);
		        pstmt.setString(2, productCategory);
		        pstmt.setInt(3, unitPrice);
		        pstmt.setInt(4, quantity);
		        pstmt.setString(5, productImage);
		        
		         
		         
		         int status = pstmt.executeUpdate();
		         if(status > 0) 
		            
		         response.sendRedirect("AvailableProducts.jsp");
		            
		         
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
