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
	<a href="<c:url value="officeslist.htm"/>">Search Offices</a>
	<br />
	<a href="<c:url value="hello.htm"/> "> Show accounts from an office</a>
	<br>
	<br>
	<h3>Categories:</h3>
	<br>
	<a href="<c:url value="assets.htm"/> "> Assets</a>
	<br>
	<a href="<c:url value="brokerage.htm"/> "> Brokerage</a>
	<br>
	<a href="<c:url value="liabilities.htm"/> "> Liabilities</a>
	<br>
	<a href="<c:url value="payments.htm"/> "> Payments</a>
</body>
</html>