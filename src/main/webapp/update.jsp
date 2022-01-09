<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello from employee register jsp</title>
</head>
<body>
 <div align="center">
  <h1>Update employee </h1>
  <form action="modify" method="post">
   <table style="with: 80%">
   <tr>
     <td>ID</td>
     <td><input type="text" name="id" /></td>
    </tr>
   
    <tr>
     <td>Name</td>
     <td><input type="text" name="allname" /></td>
    </tr>
    <tr>
     <td>Date_Birth</td>
     <td><input type="text" name="dateBirth" /></td>
    </tr>
    <tr>
     <td>Gender</td>
     <td><input type="text" name="gender" /></td>
    </tr>
    <tr>
     <td>grad_date</td>
     <td><input type="text" name="gradDate" /></td>
    </tr>
    
     <tr>
     <td>department</td>
     <td><input type="text" name="department" /></td>
    </tr>
    
     <tr>
     <td>team</td>
     <td><input type="text" name="team" /></td>
    </tr>
    
    <tr>
     <td>manager</td>
     <td><input type="text" name="manager" /></td>
    </tr>
    
    <tr>
     <td>gross_salary</td>
     <td><input type="text" name="gross" /></td>
    </tr>
    
    <tr>
     <td>net_salary</td>
     <td><input type="text" name="net" /></td>
    </tr>
    
    <tr>
     <td>isManager</td>
     <td><input type="text" name="ismanager" /></td>
    </tr>
    
    
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>