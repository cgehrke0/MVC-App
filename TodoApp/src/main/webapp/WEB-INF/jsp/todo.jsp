<%@ include file="common/header.jspf" %>
<html>
<head>
<title>
	Todo App 
</title>
<link href="webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">



	Add todo for ${name}
	<form:form method="post" modelAttribute="todo">
	<form:hidden path="id"/>
	<form:hidden path="user"/>
	<fieldset class="form-group">
	<form:label path="description">Todo Description:</form:label>
		 <form:input type="text" path="description" class="form-control" required="required"/>
		 <form:errors path="description" class="text-warning"/>
		 </fieldset>
		 
		 <fieldset class="form-group">
	<form:label path="targetDate">Todo TargetDate:</form:label>
		 <form:input type="text" path="targetDate" class="form-control" required="required"/>
		 <form:errors path="targetDate" class="text-warning"/>
		 </fieldset>
		<button type="submit" class = "btn btn-success">Add</button>
		</form:form>
	</div>
		<Script src="webjars/jquery/1.9.1/jquery.min.js"></Script>
		<Script src="webjars/bootsstrap/4.4.1/js/bootstrap.min.js"></Script>
		<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
<script>
	$('#targetDate').datepicker({ format : 'dd/mm/yyyy' });
</script>
		
</body>
</html>
