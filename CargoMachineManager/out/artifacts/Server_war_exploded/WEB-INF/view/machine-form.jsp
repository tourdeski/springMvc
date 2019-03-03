<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
  <title>Save Machine</title>

  <link type="text/css"
        rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/style.css">

  <link type="text/css"
        rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

<div id="wrapper">
  <div id="header">
    <h2>Cargo Manager Manager</h2>
  </div>
</div>

<div id="container">
  <h3>Save Machine</h3>

  <form:form action="saveMachine" modelAttribute="machine" method="POST">

    <form:hidden path="id" />
    <table>
      <tbody>
      <tr>
        <td><label>Name:</label></td>
        <td><form:input path="name" /></td>
      </tr>

      <tr>
        <td><label>Capacity:</label></td>
        <td><form:input path="capacity" /></td>
      </tr>

      <tr>
        <td><label>Price:</label></td>
        <td><form:input path="price" /></td>
      </tr>

      <tr>
        <td><label>Capacity map:</label></td>
        <td><form:textarea rows="15" cols="40" path="capacityMapXml" /></td>
      </tr>

      <tr>
        <td><label></label></td>
        <td><input type="submit" value="Save" class="save" /></td>
      </tr>
      </tbody>
    </table>
  </form:form>

  <div style="clear; both;"></div>

  <p>
    <a href="${pageContext.request.contextPath}/machine/list">Back to List</a>
  </p>
  <p>
    <a href="${pageContext.request.contextPath}/machine/content">Back to Contents</a>
  </p>

</div>

</body>

</html>
