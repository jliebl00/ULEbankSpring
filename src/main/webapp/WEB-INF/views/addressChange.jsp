<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Ulebank</title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
<h1>Addres Change :: UleBank</h1>
<form:form method="post" commandName="addressChange">
  <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="right" width="20%">Nueva Direccion: </td>
        <td width="20%">
          <form:input path="address"/>
        </td>
        <td width="60%">
          <form:errors path="address" cssClass="error"/>
        </td>
    </tr>
  </table>
  <br>
  <input type="submit" value="Aplicar">
</form:form>
<a href="<c:url value="index.htm"/>">Volver</a>
</body>
</html>