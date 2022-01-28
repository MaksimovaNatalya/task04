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
    </style>
</head>
<body>
<jsp:include page="header.jsp" />
<br/>

AVAILABLE ROOMS
<form action="Controller" method="post">
    <input type="hidden" name="command" value="findRooms">

<c:forEach var="room" items="${availableRooms}">
    <table >
        <tr>
            <th>Category</th>
            <th>Price per night</th>
            <th>Image</th>
        </tr>
        <tr>
            <td><c:out value="${room.category}"  /></td>
            <td><c:out value="${room.pricePerNight}" /></td>
            <td><c:out value="${room.image}" /></td>
        </tr>
    </table>

    <br/>
</c:forEach>

</body>
</html>
