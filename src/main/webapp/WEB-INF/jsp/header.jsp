<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.language}" />
    <fmt:setBundle basename="prop" var="lang" />
    <fmt:message bundle="${lang}" key="menu.authorization"
                 var="reg_button" />
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

    <li class="local">
        <form>
            <input type="hidden" name="command" value="changeLanguage" >
            <select name="language" onchange="submit()">
                <option value="ru" ${requestScope.language == 'ru' ? 'selected' : ''}>RU</option>
                <option value="en" ${requestScope.language == 'en' ? 'selected' : ''}>ENG</option>
            </select>
        </form>
    </li>

    <li class="log-in">
        <c:if test="${empty sessionScope.login}" >
            <a href="Controller?command=GO_TO_AUTHORIZATION_PAGE">${reg_button}</a>
        </c:if>
        <c:if test="${not empty sessionScope.login}" >
            <a href="Controller?command=GO_TO_ACCOUNT_PAGE">My account</a>
                <a href="Controller?command=logOut">Log out</a>
                <input type="hidden" name="command" value="logOut" />
            </form>
        </c:if>
    </li>

    <li class="dropdown">
        <a  href="javascript:void(0)" class="dropbtn">About us</a>
        <div class="dropdown-content">
            <a href="Controller?command=GO_TO_INFO_PAGE">Info</a>
            <a href="Controller?command=GO_TO_CONTACTS_PAGE">Contacts</a>
        </div>
    <li><a href="Controller?command=showRooms">Rooms</a></li>
    <c:if test="${not empty sessionScope.login}" >
        <li><a href="Controller?command=GO_TO_REQUEST_PAGE">Book a room</a></li>
    </c:if>
    <c:if test="${empty sessionScope.login}" >
        <li><a href="Controller?command=GO_TO_AUTHORIZATION_PAGE">Book a room</a></li>
    </c:if>
</ul>
</body>
</html>
