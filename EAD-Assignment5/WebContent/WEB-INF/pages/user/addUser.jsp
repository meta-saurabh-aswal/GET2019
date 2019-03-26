<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

	<meta charset="UTF-8">

	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<title>Add User</title>

</head>

<body>

<%@include file="../partials/header.html" %>

<div class="container">

	<form action="addUser" method="post">

	 <label>First Name</label>

	 <input type="text" class="form-control" name="first_name" maxlength="20" required>

	 <label>Last Name</label>

	 <input type="text" class="form-control" id="lName" name="last_name" maxlength="20" required>

	 <label>Contact Number</label>

	 <input type="text" class="form-control" pattern="[0-9]{10}" name="contact_number"  required />

	 <label >Email</label>

	 <input type="email" class="form-control" name="email" maxlength="50" required />

	  <input type="submit" class="btn btn-primary" value="submit">

	</form>

</div>

</body>

</html>