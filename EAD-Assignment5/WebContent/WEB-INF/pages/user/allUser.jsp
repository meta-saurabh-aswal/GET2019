<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        

<!DOCTYPE html >

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Employees</title>

</head>

<body>

<%@include file="../partials/header.html" %>

<h1>Users List</h1>  

<table border="2" width="70%" cellpadding="2">  

<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Contact No</th><th>Email</th><th>Edit</th><th>Delete</th></tr>  

   <c:forEach var="user" items="${users}">   

   <tr>  

   <td>${user.id}</td>  

   <td>${user.first_name}</td>

   <td>${user.last_name}</td>  

   <td>${user.contact_number}</td>

   <td>${user.email}</td>  

   <td><a href="edit/${user.id}">Edit</a></td>  

   <td><a href="delete/${user.id}">Delete</a></td>  

   </tr>  

   </c:forEach>  

   </table>  

   <br/>  

</body>

</html>

© 2019 GitHub, Inc.
Terms
Privacy
Secu