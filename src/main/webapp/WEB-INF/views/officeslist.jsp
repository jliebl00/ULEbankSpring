<%@ include file="/WEB-INF/views/include.jsp"%>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>

<body>
	<h1>
		<fmt:message key="title" />
	</h1>
	<h3>
		<fmt:message key="offices" />
	</h3>
	<c:forEach items="${model.offices}" var="offic">
		<b>Id: </b>
		<c:out value="${offic.idOffice}" />
		<i><b>Address: </b>
		<c:out value="${offic.address}" /></i>
		<br>
		<br>
	</c:forEach>
	<br>
	<a href="<c:url value="searcher.htm"/>">Searcher</a>
	<br>
	<a href="<c:url value="startpage.htm"/>">Home</a>
	<br>
</body>
</html>