<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="v" uri="http://vdab.be/tags"%>
<!doctype html>
<html>
<v:head title='${empty docent ? "Docent zoeken" : docent.naam}' />
<body>
	<v:menu />
	<h1>Docent Zoeken</h1>
	<form>
		<label>Nummer:<span>${fouten.id}</span> <input name='id'
			value='${param.id}' required autofocus type='number' min='1'></label>
		<input type='submit' value='Zoeken'>
	</form>
	<c:if test="${not empty param and empty fouten and empty docent}">
	Docent niet gevonden
</c:if>
	<c:if test="${not empty docent}">
${docent.naam}, wedde: &euro; <fmt:formatNumber value='${docent.wedde}'/>
	</c:if>
</body>
</html>