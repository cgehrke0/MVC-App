<%@ include file="common/header.jspf" %>
Custom Login Page

<c:if test="${not empty errorMessage}">
	<div style="color: purple">${errorMessage}</div>
	</c:if>
<form name = 'login' action='/login' method='POST'>
User name: <input type="text" name="name" />
		Password: <input type="password" name="password" />
		<input type="submit" name="submit" value="submit"/>
</form>'


