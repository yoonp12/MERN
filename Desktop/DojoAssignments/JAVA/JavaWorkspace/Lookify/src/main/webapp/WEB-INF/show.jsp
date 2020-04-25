<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container ">
	<nav class="navbar navbar-expand-lg navbar-light bg-light d-flex justify-content-between">
		<h2>Song Details:</h2>
		<a href="/dashboard">Dashboard</a>
	</nav>
		<div class="card border-0" style="width: 50rem;">
			<div class="card-body">
			    <table class="table">
					<tbody>
						<tr>
							<th scope="row"><h4>Title:</h4></th>
							<td><h3><c:out value='${songs.title}'/></h3></td>
						</tr>
						<tr>
							<th scope="row"><h4>Artist:</h4></th>
							<td><h3><c:out value='${songs.artist}'/></h3></td>
						</tr>
						<tr>
							<th scope="row"><h4>Rating:</h4></th>
							<td><h3><c:out value='${songs.rating}'/></h3></td>
						</tr>
						<tr>
							<th scope="row">
								<form action="/delete/<c:out value='${songs.id}'/>" method="post">
								    <input type="hidden" name="_method" value="delete">
								    <input type="submit" value="Delete">
								</form>
							</th>
							<th></th>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>