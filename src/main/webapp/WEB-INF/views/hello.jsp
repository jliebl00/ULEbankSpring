<%@ include file="/WEB-INF/views/include.jsp"%>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="heading" />
	</h1>
	<p>
		<fmt:message key="greeting" />
		<c:out value="${model.now}" />
	</p>
	<h3>Offices</h3>
	<c:forEach items="${model.offices}" var="offic">
		<b>Identificador: </b>
		<c:out value="${offic.officeID}" />
		<i><b>Calle: </b>
		<c:out value="${offic.address}" /></i>
		<br>
		<br>
	</c:forEach>
	<br>
	<a href="<c:url value="find.htm"/>">-Finder-</a>
	<br>
	<br>
	<a href="<c:url value="startpage.htm"/>">-Home-</a>
	<br>
</body>
</html>