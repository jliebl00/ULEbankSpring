<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
					<a href="<c:url value="showAllEmployees.htm"/>">Back</a>
				</li>
			</ul>
		</nav>
		
		<div class="content">
			<div class="headerContent">
				<b class="titleContent"><fmt:message key="reallocateemployee" /></b>
			</div>
				<form:form method="post" commandName="changeOffice">
				<ul>
					<li>
						<b>Employee id: </b>
					</li>
					<li>
						<%=request.getParameter("id1") %>
					</li>
					<li>
						<b>New office id: </b>
					</li>
					<li>
						<form:input path="officeID" />
						<form:errors path="officeID" cssClass="error" />
					</li>
					<li>
						<input type="submit" value="Execute">
					</li>
				</ul>
			</form:form>
		</div>
	</body>

</html>