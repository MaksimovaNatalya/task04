<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:setBundle basename="prop" var="lang"/>
    <fmt:message bundle="${lang}" key="rooms.image" var="image"/>
    <fmt:message bundle="${lang}" key="rooms.category" var="category"/>
    <fmt:message bundle="${lang}" key="rooms.price" var="price"/>
    <fmt:message bundle="${lang}" key="rooms.max_persons" var="max_persons"/>

    <style>
        body {
            background: #B0E0E6;
        }

        .header-logo {
            width: 200px;
            float: left;

            position: relative;
            z-index: 1;

        }

        .header-logo-src {
            width: 200px;
            height: 55px;
            float: left;

            position: relative;
            z-index: 1;

        }

        .log-in {
            float: right;
        }

        .local {
            float: right;
        }

        img {
            width: 100%;
            height: 110%;
            position: relative;
            z-index: 1;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            font-size: 18pt;
        }

        li {
            float: left;
        }

        li a, .dropbtn {
            display: inline-block;
            color: black;
            text-align: center;
            padding: 14px 40px;
            text-decoration: none;
        }

        li a:hover, .dropdown:hover .dropbtn {
            background-color: #B0C4DE;
        }

        li.dropdown {
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #AFEEEE;
            min-width: 90px;
            box-shadow: 0px 8px 16px 0px rgba(0, 134, 254, 0.42);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 32px;
            text-decoration: none;
            display: block;
            text-align: center;
            z-index: 1;
        }

        .dropdown-content a:hover {
            background-color: #B0C4DE;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }


        table {
            border: 3px solid grey;
            width: 100%;
        }


        th, td {
            text-align: center;
            border: 1px solid grey;
            padding: 10px 15px;
        }

        img {
            position: center;
            width: 600px;
            height: 375px;
        }
        h1{
            text-align: center;
            color: #191970;
        }
        input[type=submit] {
            width: 100%;
            background-color: #6495ED;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
    <title>Rooms</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<h1>Номера и цены</h1>
    <br/>
    <br/>
    <form action="Controller" method="post">
        <input type="hidden" name="command" value="GO_TO_REQUEST_PAGE">
    <table>
        <tr>
            <td>
                <img src="/lux.jpg" alt="room">
                <img src="/lux2.jpg" alt="room">
            </td>
            <td>
                LUX <br/>
                from ${luxPrice}$/night <br/>
                <br/>
                    <input type="submit" value="book">

            </td>
        </tr>
        <tr>

            <td>
                <img src="/standard1.jpg" alt="room">
                <img src="/standard2.jpg" alt="room">
            </td>
            <td>
                STANDARD <br/>
                from ${standardPrice}$/night <br/>
                <br/>
                <input type="submit" value="book">
            </td>
        </tr>
        <tr>
            <td>
                <img src="/economy.jpg" alt="room">
                <img src="/economy2.jpg" alt="room">
            </td>
            <td>
                ECONOMY <br/>
                from ${economyPrice}$/night<br/>
                <br/>
                <input type="submit" value="book">
            </td>
        </tr>
    </table>
    </form>

<c:if test="${requestScope.user.roleId eq 1}" >

    <h2>
        <a href="Controller?command=GO_TO_ALL_REQUESTS_PAGE">Show all rooms</a>
    </h2>
</c:if>

</body>
</html>
