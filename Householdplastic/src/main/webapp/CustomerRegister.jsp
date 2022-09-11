

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Register</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
         
    </head>
    
<fieldset class = "field">
  <legend >Customer Register</legend>
   
 <form action="CustomerRegister" method = "post">
  
  <table >
      <tr><td>First Name:</td><td ><input type = "text"  name = "firstName" placeholder = "First Name" required ></td></tr>
     <tr><td>Last Name:</td><td ><input type = "text"    name = "lastName" placeholder = "Last Name" required  ></td></tr>
     <tr><td>Email:</td><td ><input type = "email"   name = "email" placeholder = "Email" ></td></tr>
     <tr><td>Gender:</td><td ><input type = "text"    name = "gender" placeholder = "Gender" required ></td></tr>
     <tr><td>Location:</td><td ><input type = "text"    name = "location" placeholder = "location" required ></td></tr>
     <tr><td>Telephone:</td><td ><input type = "text"  name = "telephone" placeholder = "Telephone Number" required ></td></tr>
     <tr><td>Password:</td><td><input  type = "password" name = "password" placeholder = "Password" required ></td></tr>
     <tr><td><input  type = "submit"  name ="submit" value = "Create Account" ></td></tr>
   </table> 
  
 
  </form>
   </fieldset>
        
    </body>
</html>