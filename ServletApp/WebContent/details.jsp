<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
<link rel="stylesheet" type="text/css"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="custom.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="jumbotron" align="center">
			<h1>Details</h1>
			<p>${custName}</p>
		</div>
	</div>
	<div class="container-fluid">
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Address 1</th>
					<th>Address 2</th>
					<th>City</th>
					<th>State</th>
					<th>Zipcode</th>
					<th>Phone #1</th>
					<th>Phone #2</th>
					<th>Credit Limit</th>
					<th>Email</th>
				</tr>
			</thead>
			${message}
			</tbody>
		</table>
	</div>
</body>
</html>