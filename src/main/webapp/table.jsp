<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="table" uri="/WEB-INF/tld/gem.tld" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>GemTable</title>
</head>
<body>


<jsp:useBean id="gembean" class="by.epam.training.mikulich.xmlparser.tablebuild.GemSet" scope="request" />

<table:jspset set="${gembean}" />
<br/>
</body>
</html>