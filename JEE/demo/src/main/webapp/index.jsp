<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<form action="add">
    <br/>
    Enter 1st number: <input type="text"  name=nb1><br>
    Enter 2nd number: <input type="text"  name=nb2><br>
    <input value="CalculateIT" type="submit">
</form>
<form action="FizzBuzz">
    <br/>
    Enter min of the range: <input type="text"  name=min><br>
    Enter min of the range <input type="text"  name=max><br>
    <input value="FizzBuzzIT" type="submit">
</form>
</body>
</html>