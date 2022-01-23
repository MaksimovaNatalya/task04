<%--
  Created by IntelliJ IDEA.
  User: MaxMoff
  Date: 11.01.2022
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


<div class="header-logo">
    <a class="header-logo-link" href="Controller?command=GO_TO_INDEX_PAGE">
        <img class="header-logo-src" src="/hotel-logo.jpg"  alt="Logo" >
    </a>
</div>
<ul>
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

<img src="/background.gif"  alt="Hotel" >

</body>
</html>
