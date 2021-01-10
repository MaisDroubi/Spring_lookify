<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form action="/songs/search" method="post">
	<input type="text" name="artist"/>
	<button class="btn btn-primary">Search Artists</button>
</form>

<h1>All Songs</h1>
<table>
	<thead>
	<tr>
		<th>Title</th>
		<th>Artist</th>
		<th>Rating</th>
		<th>Action</th>

	</tr>
	</thead>
	<tbody>
	<c:forEach items="${songs}" var="song">
		<tr>
			<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>

			<td><c:out value="${song.artist}"/></td>
			<td><c:out value="${song.rating}"/></td>
			<td><a href="/songs/edit/${song.id}">Edit</a></td>
			<td>

				<form action="/songs/${song.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<input type="submit" value="Delete">
				</form>

			</td>

		</tr>
	</c:forEach>
	</tbody>
</table>

<a href="/songs/new">add new song</a>
<a href="/songs/top10">top 10 songs</a>