<%@ include file="common/header.jspf" %>
<html>
<head>
<title> Todo App </title>

<!-- CSS Javascript Metatags -->
<link href="webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Logo</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="/">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/listtodos">Todos</a>
				</li>
				<li class = "nav-item"><a class = "nav-link" href ="/logout">Logout</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class = "container">
	<table class="table table-striped">
	<thead>
		<tr>
			<td>Description</td>
			<td>Target Date</td>
			<td>Status</td>
			<th></th>
		</tr>
	</thead>
	<tbody>
	<!--  for(Items item: val) -->
	<c:forEach items="${todos}" var="todo">
		<tr>
			<td>${todo.description }</td>
			<td><fmt:formatDate value="${todo.targetDate }" pattern = "dd/MM/yyyy"/></td>
			<td>${todo.status }</td>
			<td><a role="button" class="btn btn-warning"href ="/deletetodo?todoId=${todo.id }">Delete</a></td>
			<td><a role="button" class="btn btn-danger"href ="/edittodo?todoId=${todo.id }">Edit</a></td>
			</tr>
			
			</c:forEach>
	
	</tbody>
	
	</table>
	</div>
	Click here to
	<a href="/todo"> Add Todo </a>
	
	<Script src="webjars/jquery/1.9.1/jquery.min.js"></Script>
	<Script src="webjars/bootsstrap/4.4.1/js/bootstrap.min.js"></Script>
	
</body>
</html>