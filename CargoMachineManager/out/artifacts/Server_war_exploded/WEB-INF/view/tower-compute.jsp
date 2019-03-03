<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<style>
    html, body{
        margin-left:15px; margin-right:15px;
        padding:0px;
        font-family:Verdana, Arial, Helvetica, sans-serif;
    }
    input[type=text] {
        width: 100%;
        padding: 8px 20px;
        margin: 8px 0;
        box-sizing: border-box;
        border: 1px solid #555;
        outline: none;
        border-radius: 10px;
    }

    input[type=text]:focus {
        background-color: lightgreen;
    }
</style>
<html>
<head>
    <title>Подбор кранов</title>
</head>
<body>
Подбор кранов на автомобильном шасси


    <form:form action="compute" modelAttribute="towerBuilder" method="POST">
        <table>
            <tr>
                <th>Первый блок</th>
            </tr>
            <tr>
                <td><label>Высота:</label></td>
                <td><form:input path="firstBlockHigh"/></td>
            </tr>
            <tr>
                <td><label>Масса:</label></td>
                <td><form:input path="firstBlockWeight"/></td>
            </tr>

            <tr>
                <th>Второй блок</th>
            </tr>
            <tr>
                <td><label>Высота:</label></td>
                <td><form:input path="secondBlockHigh"/></td>
            </tr>
            <tr>
                <td><label>Масса:</label></td>
                <td><form:input path="secondBlockWeight"/></td>
            </tr>

            <tr>
                <th>Типовой блок</th>
            </tr>
            <tr>
                <td><label>Высота:</label></td>
                <td><form:input path="typicalBlockHigh"/></td>
            </tr>
            <tr>
                <td><label>Масса:</label></td>
                <td><form:input path="typicalBlockWeight"/></td>
            </tr>
            <tr>
                <td><label>Количество:</label></td>
                <td><form:input path="amountOfTypicalBlocks"/></td>
            </tr>
            <tr>
                <td><label>Расстояние от крана:</label></td>
                <td><form:input path="distance"/></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Compute" class="save"/></td>
            </tr>
        </table>
    </form:form>

<p>
    <a href="${pageContext.request.contextPath}/machine/content">На главную</a>
</p>
</body>
</html>