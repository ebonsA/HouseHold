<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<form action="./LoginUser" method = "post">
  <fieldset >
  <legend >Login</legend>
  <table >
     
    <tr><td ><input type = "email"  name = "email" placeholder = "Email" ></td></tr>
     <tr><td><input type = "password" name = "password" placeholder = "Password"></td></tr>
     <tr><td><input type = "submit" value = "Login" ></td></tr>
   </table> 
  
  </fieldset>
  </form>

</body>
</html>