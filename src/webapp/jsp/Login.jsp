<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="Header.jsp"/>
<head>
    <link rel="stylesheet" type="text/css" href="myCSS.css">
</head>
<div class="container">
    <form action="/login" method="post">
        <label for="login">Login:</label><br>
        <input type="text" id="login" name="Login" ><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="Password" ><br><br>
        <input type="submit" value="Login"><br>

        <c:if test="${not empty unregistered}">
            <h5><i><font color="red">User not found. Please register!</font></i></h5>
        </c:if>


    </form>
</div>
</body>
</html>