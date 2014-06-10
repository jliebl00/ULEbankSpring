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
	<h3>Options</h3>
	<br>
	<br>
	<br>
	<a href="<c:url value="startpage.htm"/>">Home</a>
	<br>

</body>
</html>