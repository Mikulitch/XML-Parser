
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix = "c" %>
<!DOCTYPE html>
<html>
<title>MainPage</title>
</head>
<body>
<div>
  <h3>XML Upload</h3>
  Select XML file to upload: <br />
  <form action = "FileUploadController" method = "post" enctype = "multipart/form-data">
    <input type = "file" name = "xml" size = "70" accept=".xml" /> <br />
    <br/>
    <input type = "submit" value = "Upload"/>
  </form>
</div>
</body>
</html>
