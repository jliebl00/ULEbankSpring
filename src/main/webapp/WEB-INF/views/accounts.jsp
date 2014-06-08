<%@ include file="/WEB-INF/views/include.jsp"%>

<html>

<head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h3>Accounts</h3>
    <c:forEach items="${model.accounts}" var="acco">
      <b>Identificador: </b><c:out value="${acco.accountID}"/> <br><br>
    </c:forEach>
 <br>
    <a href="<c:url value="hello.htm"/>">-Home-</a>
 <br>
</body>
</html>