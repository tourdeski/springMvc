<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 11.12.2018
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    html, body{
        margin-left:15px; margin-right:15px;
        padding:0px;
        font-family:Verdana, Arial, Helvetica, sans-serif;
    }
    .button {
        background-color: white; /* Green */
        border: none;
        color: white;
        padding: 16px 42px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        -webkit-transition-duration: 0.1s; /* Safari */
        transition-duration: 0.1s;
        cursor: pointer;
    }

    .button1 {
        background-color: white;
        color: black;
        border: 2px solid #4CAF50;
    }
    .button:hover {
        background-color: #4CAF50; /* Green */
        color: white;
    }

    .modal {
        padding: 50px;
        position: fixed;
        top: 50%;
        left: 50%;
        -webkit-transform: translate(-50%, -50%);
        -ms-transform: translate(-50%, -50%);
        transform: translate(-50%, -50%);
    }
</style>
<head>
    <title>Содержание</title>
</head>
<body>

<div class="modal">
    <form>
        <table>
            <tr><td colspan="2">Please click a button to redirect you to the page you wish to go to.</td></tr>
            <tr>
                <td> <input type="button" class="button button1" value="Подбор" onclick="goToTower()"> </td>
                <td> <input type="button" class="button button1" value="Список кранов" onclick="goToEditMachineList()"></td>
            </tr>
        </table>
    </form>
</div>
<br>


<script type="text/javascript">
    function goToEditMachineList() {
        window.location = '/machine/list'
    }

    function goToTower() {
        window.location = '/machine/tower'
    }

</script>
</body>
</html>
