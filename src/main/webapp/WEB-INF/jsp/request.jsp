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

<form action="Controller" method="post">
    <input type="hidden" name="command" value="findRooms">
<h1><font color="#191970">Choose arrival date, departure date and number of guests </font></h1>
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
    <input type="hidden" name="command" value="GO_TO_AVAILABLE_ROOMS_PAGE">



</fieldset>
</div>
</form>
</body>
</html>

