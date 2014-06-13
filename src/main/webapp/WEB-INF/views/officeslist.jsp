<%@ include file="/WEB-INF/views/include.jsp"%>

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
					<a class="menu selected" href="<c:url value="officeslist.htm"/>">Search Offices</a>
				</li>
				<li class="liMenu">
					<a class="menu" href="<c:url value="hello.htm"/> "> Show accounts from an office</a>
				</li>
			</ul>
		</nav>
		
		<div class="content">
			<div class="headerContent">
				<b class="titleContent"><fmt:message key="offices" /></b>
				<a class="searcherContent" href="<c:url value="searcher.htm"/>" title="Search office"></a>
			</div>
			<ul>
				<c:forEach items="${model.offices}" var="offic">
				<li>
					<b>Id: </b>
					<c:out value="${offic.officeID}" />
					<i><b>Address: </b>
					<c:out value="${offic.address}" /></i>
				</li>
				</c:forEach>
			</ul>
		</div>
	</body>
	
</html>