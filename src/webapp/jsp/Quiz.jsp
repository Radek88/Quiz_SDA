<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="Header.jsp"/>
<head>
    <link rel="stylesheet" type="text/css" href="myCSS.css">
</head>
<div class="container">
    <c:if test="${not empty Lost}">
        <img src="https://lelum.pl/wp-content/uploads/2018/03/milionerzy1-1021x559.jpg">
        <h2>
            <center>${Lost}</center>
        </h2>
    </c:if>

</div>

<c:if test="${empty Lost}">
    <div>

    </div>
    <c:if test="${empty Show_question}">
        <div class="container">
            <form action="/quiz" method="post">
                <input type="hidden" name="parameter" value="next_question">
                <button class="buttonStart" value="Start">START</button>
            </form>
        </div>
    </c:if>



    <c:if test="${not empty Show_question}">
        <div class="container">

            <form action="/quiz" method="POST">

                <h3></h3>
                <p class="round3"> ${quest.question}</p><br></h3>

                <button class="button" name="parameter" value="A">A: ${quest.answer_A}</button>

                <button class="button" name="parameter" value="B">B: ${quest.answer_B}</button>
                <br><br>
                <button class="button" name="parameter" value="C">C: ${quest.answer_C}</button>

                <button class="button" name="parameter" value="D">D: ${quest.answer_D}</button>
                <input type="hidden" name="correctAnswer" value="${quest.correctAnswer}">
            </form>
        </div>

        </div>

    </c:if>
</c:if>


</body>
</html>