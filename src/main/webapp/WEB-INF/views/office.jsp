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
	</p>
	<h3>Offices</h3>


	<b>Calle: </b>
	<c:out value="${office.getAddress()}" />
	<br>
	<b>Balance: </b>
	<c:out value="${office.getBalance()}" />
	<br>
	<b>Utilities costs: </b>
	<c:out value="${office.getUtilitiesCost()}" />
	<br>
	<b>Local costs: </b>
	<c:out value="${office.getLocalCost()}" />
	<br>
	<b>Employee costs: </b>
	<c:out value="${office.getEmployeeCost()}" />
	<br>
	<b>Total expenses: </b>
	<c:out value="${office.getTotalExpenses()}" />
	<br>	
	<b>City: </b>
	<c:out value="${office.getCity()}" />
	<br>
	<b>PostCode: </b>
	<c:out value="${office.getPostCode()}" />
	<br>
	<b>Telephone: </b>
	<c:out value="${office.getTelephone()}" />
	<br>
	<br>
	<br>
	<br>
	<a href="<c:url value="searcher.htm"/>">Searcher</a>
	<br>
	<a href="<c:url value="startpage.htm"/>">Home</a>
	<br>
	<a href="<c:url value="costmodify.htm?previous=${office.getEmployeeCost}"/>">Modify Cost</a>
	<br>
</body>
</html>