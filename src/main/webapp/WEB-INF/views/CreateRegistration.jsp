<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration form</title>
</head>
<body>
<h2> Registration | Create </h2>
<form action="registrationController" method="post">
<pre>
        name<input type="text" name="name"/>
        city<input type="text" name="city"/>
        email<input type="text" name="email"/>
        mobile<input type="text" name="mobile"/>
        <input type="submit" value="register"/>
        </pre>
        </form>
        
        <%
         if( request.getAttribute("msg")!=null)
          out.println( request.getAttribute("msg"));
        
        %>
</body>
</html>