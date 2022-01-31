<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background: #B0E0E6;
        }
        .header-logo{
            width:200px;
            float:left;

            position:relative;
            z-index:1;

        }
        .header-logo-src{
            width:200px;
            height:55px;
            float:left;

            position:relative;
            z-index:1;

        }

        .log-in {
            float:right;
        }
        .local{
            float:right;
        }
        img{
            width:100%;
            height:110%;
            position:relative;
            z-index:1;
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
            background-color: 	#B0C4DE;
        }

        li.dropdown {
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: 	#AFEEEE;
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

        .dropdown-content a:hover {background-color: #B0C4DE;}

        .dropdown:hover .dropdown-content {
            display: block;
        }
        table {
            border: 3px solid grey;

        }

        th, td {
            text-align: left;
            border: 1px solid grey;
            padding: 10px 15px;
        }
        .doNotShow{display:none;}

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
</head>
<body>
<jsp:include page="header.jsp" />
<br/>

AVAILABLE ROOMS
<form action="Controller" method="post">
    <input type="hidden" name="command" value="bookRoom">
<c:forEach var="room" items="${availableRooms}">

    <table >
        <c:set var="room.id" value="${room.id}" scope="session" />
        <c:set var="room.category" value="${room.category}" scope="session" />
        <c:set var="room.maxPersons" value="${room.maxPersons}" scope="session" />
        <tr class="doNotShow"><th>Id</th><td>${room.id}</td></tr>
        <tr>
            <th>Image</th>
            <th>Category</th>
            <th>Maximum persons</th>
            <th>Seaview</th>
            <th>Breakfast</th>
            <th>Price per night</th>
            <th></th>

        </tr>
        <tr>
            <td><c:out value="${room.image}"  /></td>
            <td><c:out value="${room.category}"  /></td>
            <td><c:out value="${room.maxPersons}" /></td>
            <td><c:out value="${room.seaview}" /></td>
            <td><c:out value="${room.breakfast}" /></td>
            <td><c:out value="${room.pricePerNight}" /></td>

            <td>

                <input type="submit" value="Book"/>

            </form>
            </td>
        </tr>
    </table>

    <br/>
</c:forEach>

</body>
</html>
