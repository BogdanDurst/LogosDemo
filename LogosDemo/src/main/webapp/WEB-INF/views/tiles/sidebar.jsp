<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<div class="internal-buttons">
	<ul class="nav nav-sidebar">
		<li><a href="home">Home</a></li>
		<sec:authorize access="hasAnyRole('ROLE_USER')">
			<li><a href="users">Users</a></li>
		</sec:authorize>
	</ul>
</div>
