<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
    <title>Cargo machine list</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Manage Cargo Machine</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <input type="button" value="Add Machine"
               onclick="window.location.href='showFormForAdd';return false;"
               class="add-button"
                />
        <table>
            <tr>
                <th>Name</th>
                <th>Capacity</th>
                <th>Price</th>
                <th>Update</th>
            </tr>

            <c:forEach var="tempMachine" items="${machines}">

                <c:url var="updateLink" value="/machine/showFormForUpdate">
                    <c:param name="machineId" value="${tempMachine.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/machine/delete">
                    <c:param name="machineId" value="${tempMachine.id}"/>
                </c:url>

                <tr>
                    <td> ${tempMachine.name} </td>
                    <td> ${tempMachine.capacity} </td>
                    <td> ${tempMachine.price} </td>
                    <td><a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure?'))) return false;">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<p>
    <a href="${pageContext.request.contextPath}/machine/content">Back to Contents</a>
</p>
</body>
</html>








