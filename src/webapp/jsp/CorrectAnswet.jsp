<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="Header.jsp"/>
<head>
    <link rel="stylesheet" type="text/css" href="myCSS.css">
</head>
<div class="container">
    <img src="https://i.iplsc.com/-/0006SLT67MJTKFEP-C122.jpg">
<form action="/quiz" method="post">
    <input type="hidden" name="parameter" value="next_question">
    <button class="buttonStart" value="Start"><center>NEXT QUESTION</center></button>

</form>
</div>
</body>
</html>