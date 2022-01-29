<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8"?>
<html>
<head><title></title>
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
    </style></head>
<body>

<jsp:include page="header.jsp" />
<br/>

<h1><font color="#191970">Choose arrival date, departure date and number of guests </font></h1>



<c:if test="${not empty sessionScope.login}" >

<form action="Controller" method="post">
    <input type="hidden" name="command" value="findRooms">
<div><fieldset>
    <label for="startDate">Arrival date</label>
    <br/>
    <input type="date" id="startDate" name="startDate">
    <br>
    <label for="endDate">Departure date</label>
    <br/>
    <input type="date" id="endDate" name="endDate">
    <br>Number of guests<br>
    <select id="guestsNumber" name="guestsNumber">
        <br/>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
    </select>
    <br/>
    <br/>
    <input type="submit" value="Find room"/>
</fieldset>
</div>
</form>
</c:if>
</body>
</html>

