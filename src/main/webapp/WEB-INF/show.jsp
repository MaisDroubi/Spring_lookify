<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/9/2021
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="/songs">Dashboard</a>

<h1><c:out value="${song.title}"/></h1>
<p>Artist: <c:out value="${song.artist}"/></p>
<p>Rating: <c:out value="${song.rating}"/></p>
<a href="/songs/edit/${song.id}">Edit Song</a>
<form action="/songs/${song.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>