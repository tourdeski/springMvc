<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Результат</title>
</head>
<body>
<p>
    <a href="${pageContext.request.contextPath}/machine/content">Back to Contents</a>
</p>

<h3>Результат подбора кранов</h3>
<c:forEach var="pairCollection" items="${result.result}">
    <table width="80%" align="center">
        <tr>
            <th width="10%">Кран</th>
            <th colspan="${result.blocks}">День/Блок</th>
        </tr>
        <tr>
            <th></th>
            <c:forEach var="i" begin="1" end="${result.blocks}">
                <th width="${90/result.blocks}%">${i}</th>
            </c:forEach>
        </tr>
        <c:forEach var="node" items="${pairCollection.nodes}">
            <tr>
                <td>${node.machine.name}</td>
                <c:forEach var="i" begin="1" end="${result.blocks}">
                    <c:if test="${i >= node.beginningBlock && i < node.endingBlock}">
                        <td bgcolor="#90ee90"></td>
                    </c:if>
                    <c:if test="${!(i >= node.beginningBlock && i < node.endingBlock)}">
                        <td bgcolor="white"></td>
                    </c:if>
                </c:forEach>
            </tr>
        </c:forEach>
        <tr>
            <th colspan="2">Итоговая стоимость</th>
            <th>${pairCollection.cost} руб.</th>
        </tr>
    </table>
</c:forEach>

</body>
</html>
