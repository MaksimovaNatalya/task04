
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
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
        table{
            width:100%;
            background-color: #f2f2f2;
            border: 5px ;
        }
    </style>
    <title></title>
</head>
<body>

<form action="Controller" method="post">
    <input type="hidden" name="command" value="showRooms">

<div class="header-logo">
    <a class="header-logo-link" href="Controller?command=GO_TO_INDEX_PAGE">
        <img class="header-logo-src" src="/hotel-logo.jpg"  alt="Logo" >
    </a>
</div>
<ul>
    <li class="local">
        <form>
            <input type="hidden" name="command" value="ChangeLanguage" >
            <select name="language" onchange="submit()">
                <option value="ru" ${language == 'ru' ? 'selected' : ''}>RU</option>
                <option value="en" ${language == 'en' ? 'selected' : ''}>ENG</option>
            </select>
        </form>
    </li>
    <li class="log-in">
        <a href="Controller?command=GO_TO_AUTHORIZATION_PAGE">Sign in/Sign up</a>
    </li>

    <li class="dropdown">
        <a  href="javascript:void(0)" class="dropbtn">About us</a>
        <div class="dropdown-content">
            <a href="Controller?command=GO_TO_INFO_PAGE">Info</a>
            <a href="Controller?command=GO_TO_CONTACTS_PAGE">Contacts</a>
        </div>
    <li><a href="Controller?command=GO_TO_ROOMS_PAGE">Rooms</a></li>
    <li><a href="Controller?command=GO_TO_BOOKING_PAGE">Book a room</a></li>

</ul>

    <c:forEach var="room" items="${allRooms}">
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


</form>
</body>
</html>