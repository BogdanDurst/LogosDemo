<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page session="false"%>

<body>
	<sec:authorize access="isAnonymous()">
		<form action="j_spring_security_check" method="post">
			<div>
				<input type="text" class="form-control" name="j_username"
					placeholder="login" required> <input type="password"
					class="form-control" name="j_password" placeholder="password"
					required>
			</div>
			<div>
				<button class="btn btn-sample" type="submit">Enter</button>
			</div>
		</form>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<a href="<c:url value="/j_spring_security_logout"/>">Log Out</a>
	</sec:authorize>
</body>

