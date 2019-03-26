<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<title>Employee Login</title>

</head>

<body>

<%@include file="../partials/header.html" %>

<div class="container">

	<form action="../update" method="post">

		<span>ID</span>

		<input type="text" class="form-control" name="id" required value="${user.id}"  readonly="readonly"/><br>

		<span>First Name</span>

		<input type="text" class="form-control" name="first_name" value="${user.first_name}" required /><br>

		<span>Last Name</span>

		<input type="text" class="form-control" name="last_name" value="${user.last_name}" required /><br>

		<span>Contact Number</span>

		<input type="number" class="form-control" pattern="[0-9] {10}" name="contact_number" value="${user.contact_number}" required /><br> 

		<span>Email Id</span>

		<input type="email" class="form-control" name="email" required value="${user.email}" /><br> 

		<input type="submit" class="btn btn-primary" value="submit">

	</form>

</div>

</body>

</html>