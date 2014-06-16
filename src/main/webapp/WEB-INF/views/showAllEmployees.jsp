<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>
<html>

	<head>
		<style type="text/css">
			<%@include file="/resources/css/style.css" %>
	  	</style>
		<title><fmt:message key="title" /></title>
	</head>
	
	<body>
		<header>
			<a class="backHome" href="<c:url value="startpage.htm"/>" title="Home"></a>
			<a class="optionsHeader assets" href="<c:url value="assets.htm"/>" title="Assets"></a>
			<a class="optionsHeader brokerage" href="<c:url value="brokerage.htm"/>" title="brokerage"></a>
			<a class="optionsHeader liabilities" href="<c:url value="liabilities.htm"/>" title="Liabilities"></a>
			<a class="optionsHeader payments" href="<c:url value="payments.htm"/>" title="Payments"></a>
		</header>
		
		<nav class="menu">
			<ul>
				<li>
					<a href="<c:url value="addoffice.htm"/>">Add office</a>
				</li>
				<li>
					<a href="<c:url value="addemployee.htm"/>">Add employee</a>
				</li>
				<li>
					<a href="<c:url value="officeslist.htm"/>">Search offices</a>
				</li>
				<li>
					<a class="selected" href="<c:url value="showAllEmployees.htm"/>">Show all employees</a>
				</li>
			</ul>
		</nav>
		
		<div class="content">
			<div class="headerContent">
				<b class="titleContent"><fmt:message key="showAllEmployees" /></b>
			</div>
			<ul>
				<c:forEach items="${model.allEmployees}" var="allEmplo">
				<a href="<c:url value="reallocateEmployee.htm?id1=${allEmplo.employeeID}&id2=${allEmplo.officeID}"/>">
				Employee:  ${allEmplo.employeeID}  ${allEmplo.name}
				<br>
				Office:	${allEmplo.officeID}</a>
				<br>
				<br>
				</c:forEach>
			</ul>
		</div>
	</body>
	
</html>