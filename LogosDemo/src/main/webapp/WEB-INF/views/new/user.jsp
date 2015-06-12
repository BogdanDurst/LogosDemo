<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<a href="/demo/users">back</a>

<div>
	<h1>${userInfo.userName}</h1>
	<h3>${userInfo.email}</h3>
</div>