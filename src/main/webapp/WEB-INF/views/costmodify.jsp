<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><fmt:message key="title" /></title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>
		<fmt:message key="costmodify.heading" />
	</h1>


	<form:form method="post" commandName="employeeCostModify">
		
		<table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
			cellpadding="5"><br> 
			<td align="right" width="40%">Previous employee cost:</td>
			<td align="right" width="20%"><%=request.getParameter("previous")%>E</td>
			<br>


			<tr>
				<td align="right" width="40%">Modify employee cost :</td>
				<td width="10%"><form:input path="amount" /></td>
				<td width="60%"><form:errors path="amount" cssClass="error" />
				</td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Execute">
	</form:form>
	<a href="<c:url value="startpage.htm"/>">Home</a>
</body>
</html>