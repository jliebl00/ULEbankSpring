<%@ include file="/WEB-INF/views/include.jsp"%>

<html>


<body>

	<h1>
		<fmt:message key="title" />
	</h1>
	<h3>Office</h3>


	<b>Address: </b>
	<c:out value="${model.office.address}" />
	<br>
	<b>Balance: </b>
	<c:out value="${model.office.balance}" />
	<br>
	<b>Utilities costs: </b>
	<c:out value="${model.office.utilitiesCost}" />
	<br>
	<b>Local costs: </b>
	<c:out value="${model.office.localCost}" />
	<br>
	<b>Employee costs: </b>
	<c:out value="${model.office.employeeCost}" />
	<br>
	<b>Total expenses: </b>
	<c:out value="${model.office.totalExpenses}" />
	<br>
	<b>City: </b>
	<c:out value="${model.office.city}" />
	<br>
	<b>PostCode: </b>
	<c:out value="${model.office.postCode}" />
	<br>
	<b>Telephone: </b>
	<c:out value="${model.office.telephone}" />
	<br>
	<br>
	<br>
	<br>
	<a href="<c:url value="searcher.htm"/>">Searcher</a>
	<br>
	<a href="<c:url value="startpage.htm"/>">Home</a>
	<br>
	<a
		href="<c:url value="costmodify.htm?previous=${model.office.employeeCost}"/>">Modify
		Cost</a>
	<br>
</body>
</html>