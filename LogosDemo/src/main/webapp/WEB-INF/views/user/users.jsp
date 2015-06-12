<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/users.css" />" rel="stylesheet">
<%@ page session="false"%>

<table id="users_table" class="table default_table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
		</tr>
	</thead>
	<c:forEach items="${usersList}" var="user">
		<tr>
			<td><a href="users/${user.id}">${user.id }</a></td>
			<td><a href="users/name/${user.userName}">${user.userName }</a></td>
			<td><a href="users/email/${user.email}">${user.email }</a></td>
		</tr>
	</c:forEach>
</table>

<form action="users/create" method="POST">
	<div id="user_create">
		<div>
			<label for="userName">Name</label> <input id="userName" type="text"
				name="userName" class="form-control" placeholder="name">
		</div>
		<div>
			<label for="email">Email</label> <input id="email" type="email"
				name="email" class="form-control" placeholder="example@mail.com">
		</div>
		<div>
			<label for="password">Password</label> <input id="password"
				type="password" name="password" class="form-control"
				placeholder="password">
		</div>

		<button class="btn btn-sample" type="submit">Submit</button>
	</div>

</form>