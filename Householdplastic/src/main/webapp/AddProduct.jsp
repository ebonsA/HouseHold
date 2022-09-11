
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Register</title>
         
    </head>
    <body>
     <h3>House Hold Plastics</h3><br>
<fieldset >
  <legend >Add Product</legend>
   
 <form action="AddProduct" method = "post">
  
  <table >
     <tr><td ><input type = "text"    name = "productName" placeholder = "Product Name" ></td></tr>
     <tr><td ><input type = "text"    name = "productCategory" placeholder = "Product Category" ></td></tr>
     <tr><td ><input type = "number"    name = "unitPrice" placeholder = "Unit Price" ></td></tr>
     <tr><td ><input type = "number"    name = "quantity" placeholder = "Quantity" ></td></tr>
     <tr><td><input  type="file"        name="productImage"></td></tr>
     <tr><td><input  type = "submit"   value = "Add Product" ></td></tr>
     
   </table> 
  
 
  </form>
   </fieldset>
        
    </body>
</html>