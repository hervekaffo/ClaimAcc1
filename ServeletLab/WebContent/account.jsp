<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.user.Student"%>
<%
Student student = (Student) session.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acoount Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
</head>
<body>
	<nav
		class="navbar navbar-expand-md navbar-dark 
           fixed-top bg-dark">
		<a class="navbar-brand" href="#"> Welcome To <%
		out.print(student.getSchoolName());
		%>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		</div>
	</nav>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<h1>
				Hello,
				<%
			out.print(student.getFirstName());
			%>
			</h1>
			<p>This is a simple java servlet program for a functional
				website.</p>
		</div>
	</div>
	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>My GPA</h2>
				<p>
					<%
					out.print(student.getGpa());
					%>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Enter Grades</h2>
				<form action="GpaServlet" method="post">
					<div class="form-group">
						<label for="gradeOne">GradeOne</label> <input type="text"
							class="form-control" name="gradeOne" id="gradeOne"
							placeholder="Grade One">
					</div>
					<div class="form-group">
						<label for="gradeTwo">Grade Two</label> <input type="text"
							class="form-control" name="gradeTwo" id="gradeTwo"
							placeholder="Grade Two">
					</div>
					<div class="form-group">
						<label for="gradeThree">Grade Three</label> <input type="text"
							class="form-control" name="gradeThree" id="gradeThree"
							placeholder="Grade Three">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
			<hr>
			<footer>
				<p>&copy; 2017 Company, Inc.</p>
			</footer>
		</div>
		<!-- /container -->
	</div>


</body>
</html>