<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>

<table style="border:2px solid blue">

	<thead style="border:2px solid blue">
		<tr style="border:2px solid blue">
			<th> Id</th>
			<th>Name</th>
			<th>Salary</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${list}" var="e">
			<tr style="border:2px solid blue">
				<td>${e.id }</td>
				<td>${e.name }</td>
				<td>${e.salary }</td>
			</tr>
		</c:forEach>
	
	
	</tbody>


</table>

</body>
</html>