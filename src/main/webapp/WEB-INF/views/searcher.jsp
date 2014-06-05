<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>

<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>
		<fmt:message key="title" />
	</h1>
	<h3>
		<fmt:message key="searcher.heading" />
	</h3>
	<form:form method="post" commandName="searcher">
		<table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
			cellpadding="5">
			<tr>
				<td align="right" width="20%">Search:</td>
				<td width="20%"><form:input path="id" /></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Execute">
	</form:form>
	<a href="<c:url value="officeslist.htm"/>">List of offices</a>
	<br>
	<a href="<c:url value="startpage.htm"/>">Home</a>
</body>
</html>