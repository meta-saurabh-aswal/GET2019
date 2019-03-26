<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>

		<!-- metadata for bootstrap -->

		<meta charset="UTF-8">

		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		

		<title>User Database Management</title>

		

		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

	</head>

	<body>

	

		<div class="container">

			<!-- To add the user in database -->

			<a href="user/addUser" class="btn btn-primary">Add Employee</a>

			

			<!-- To list all the user from database -->

			<a href="user/allUser" class="btn btn-dark">View All Employees</a>

			

			<!-- for custom search -->

			<form action="user/search" method="get">

				<div class="form-group">

			    <label>Search According to </label>

			    <select class="form-control" name="type">

			      <option value="first_name">First Name</option>

			      <option value="last_name">Last Name</option>

			      <option value="contact_number">Phone</option>

			      <option value="email">Email</option>

			    </select>

			    </div>

			    <input type="text" class="form-control" name="value" required>

			    <button type="submit" class="btn btn-primary">Submit</button>

			</form>

		</div>	

	</body>

</html>