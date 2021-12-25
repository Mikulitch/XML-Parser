<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4 align="center">Select Parser</h4>
<div>
    <form action="ParsersHandler" method = "post">
        <input type = radio id = "sax" name="parser" value="SAX">
        <label for = "sax"> SAX </label>
        <br>
        <input type = radio id = "dom" name="parser" value="DOM">
        <label for = "dom"> DOM </label>
        <br>
        <input type = radio id = "stax" name="parser" value="StAX">
        <label for = "stax">StAX</label>
        <br>
        <input type = "submit" value = "Parse">
    </form>
</div>
</body>
</html>