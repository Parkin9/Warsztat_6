<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: parkin9
  Date: 02.05.18
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>

    <p>
        <a href="<c:url value="/"/>">Strona główna</a>
    </p>
    <hr>

    <%--@elvariable id="tweetList" type="pl.coderslab.model.Tweet"--%>
    <form:form modelAttribute="tweetList">

        <label for="text">Tweet: </label>
        <form:textarea path="text" id="text"/><br>

    </form:form>

</body>
</html>
