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
		
		<nav>
			<ul>
				<li class="liMenu">
					<a class="menu selected" href="<c:url value="costmodify.htm?previous=${model.office.employeeCost}"/>">Modify cost</a>
				</li>
			</ul>
		</nav>
		
		<div class="content">
			<div class="headerContent">
				<b class="titleContent"><fmt:message key="costmodify" /></b>
			</div>
				<form:form method="post" commandName="employeeCostModify">
				<ul>
					<li>
						<b>Previous employee cost: </b>
					</li>
					<li>
						<%=request.getParameter("previous")%>
					</li>
					<li>
						<b>New employee cost: </b>
					</li>
					<li>
						<form:input path="amount" />
						<form:errors path="amount" cssClass="error" />
					</li>
					<li>
						<input type="submit" value="Execute">
					</li>
				</ul>
			</form:form>
		</div>
	</body>

</html>