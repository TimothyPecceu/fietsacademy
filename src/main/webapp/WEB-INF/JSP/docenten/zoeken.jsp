<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="v" uri="http://vdab.be/tags"%>
<!doctype html>
<html>
<head>
<v:head title='${empty docent ? "Docent zoeken" : docent.naam}' />
</head>
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
	${docent.geslacht == 'MAN' ? '&#x2642;' : '&#x2640;'}
	${docent.naam}, wedde: &euro; <fmt:formatNumber value='${docent.wedde}' />
		<h2>Acties</h2>
		<c:url value='/docenten/verwijderen.htm' var='verwijderURL'>
			<c:param name="id" value='${docent.id}'></c:param>
		</c:url>
		<form action="${verwijderURL}" method='post'>
			<input type='submit' value='Verwijderen'>
		</form>
		<c:url value='/docenten/opslag.htm' var='opslagURL'><c:param name='id' value='${docent.id}'/></c:url>
		<a href='${opslagURL}' class='knop'><input type='button' value='Opslag'></a>
	</c:if>
</body>
</html>