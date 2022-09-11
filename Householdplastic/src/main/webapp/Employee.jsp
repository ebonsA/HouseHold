

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register New Employee</title>
         
    </head>
    <body>
     <h3>House Hold Plastics</h3><br>
<fieldset >
  <legend >Register New Employee</legend>
   
 <form action="Employee" method = "post">
  
  <table >
     <tr><td ><input type = "text"    name = "firstName" placeholder = "First Name" ></td></tr>
     <tr><td ><input type = "text"    name = "lastName" placeholder = "Last Name" ></td></tr>
     <tr><td ><input type = "email"   name = "email" placeholder = "Email" ></td></tr>
     <tr><td ><input type = "number"  name = "age" placeholder = "Age" ></td></tr>
     <tr><td ><input type = "text"    name = "gender" placeholder = "Gender" ></td></tr>     
     <tr><td ><input type = "text"  name = "telephone" placeholder = "Telephone Number" ></td></tr>
     
     
     <tr><td>Product Category<select id="plastics" name="productCategory">
       <option value="cup">Cup</option>
       <option value="plate">Plate</option>
       <option value="jerrycan">Jerrycans</option>
       <option value="chair">Chairs</option>
       <option value="basin">Basin</option>
     </select></td></tr>
     
      <tr><td>Contract Terms<select id="contract" name="contract">
       <option value="Long Term">Long-Term</option>
       <option value="Short Term">Short-Term</option>
       <option value="Mid Term">Mid-Term</option>
       
     </select></td></tr>
     <tr><td><input  type = "submit"   value = "Register Employee" ></td></tr>
   </table> 
  
 
  </form>
   </fieldset>
        
    </body>
</html>