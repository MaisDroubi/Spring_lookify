<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/10/2021
  Time: 1:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/songs">Dashboard</a>

<h1>Top 10 Songs</h1>
<table>

    <tbody>
    <c:forEach items="${songs}" var="song">
        <tr>
            <td><c:out value="${song.rating}"/></td>

            <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>

            <td>-<c:out value="${song.artist}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
