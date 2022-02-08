<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="utf-8"%>
<?xml version="1.0" encoding="UTF-8"?>
<html>
<head><title>Booking</title>

    <fmt:setLocale value="${sessionScope.language}" />
    <fmt:setBundle basename="prop" var="lang" />
    <fmt:message bundle="${lang}" key="request.greeting" var="greeting" />
    <fmt:message bundle="${lang}" key="request.arr_date" var="arr_date" />
    <fmt:message bundle="${lang}" key="request.depart_date" var="depart_date" />
    <fmt:message bundle="${lang}" key="request.number_guests" var="guests_number" />
    <fmt:message bundle="${lang}" key="request.find_room" var="find_room" />

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
        input[type=date], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
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
        h1{
            text-align: center;
            color: #191970;
        }
    </style></head>
<body>

<jsp:include page="header.jsp" />
<br/>

<h1><font color="#191970">${greeting} </font></h1>



<c:if test="${not empty sessionScope.login}" >

<form action="Controller" method="post">
    <input type="hidden" name="command" value="findRooms">
<div><fieldset>
    <label for="startDate">${arr_date}</label>
    <br/>

    <c:set var="startDate" value="startDate" scope="session" />
    <input type="date" id="startDate" name="startDate">
    <br>
    <label for="endDate">${depart_date}</label>
    <br/>
    <c:set var="endDate" value="endDate" scope="session" />
    <input type="date" id="endDate" name="endDate">

    <br>${guests_number}<br>
    <select id="guestsNumber" name="guestsNumber">
        <br/>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
    </select>
    <br/>
    <br/>
    <input type="submit" value=${find_room}/>
</fieldset>
</div>
</form>
</c:if>
</body>
</html>

