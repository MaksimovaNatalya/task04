<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.language}" />
    <fmt:setBundle basename="prop" var="lang" />
    <fmt:message bundle="${lang}" key="menu.about_us" var="about" />
    <fmt:message bundle="${lang}" key="menu.info" var="info" />
    <fmt:message bundle="${lang}" key="menu.contacts" var="contacts" />
    <fmt:message bundle="${lang}" key="menu.rooms" var="rooms" />
    <fmt:message bundle="${lang}" key="menu.book_room" var="book_room" />
    <fmt:message bundle="${lang}" key="menu.authorization" var="authorization" />
    <fmt:message bundle="${lang}" key="menu.my_account" var="my_account" />
    <fmt:message bundle="${lang}" key="menu.log_out" var="log_out" />
    <fmt:message bundle="${lang}" key="menu.en" var="en_button"/>
    <fmt:message bundle="${lang}" key="menu.ru" var="ru_button"/>

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
            input[type=submit].local {
                background-color: #6495ED;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
        </style>
    </head>
<body>


<div class="header-logo">
    <a class="header-logo-link" href="Controller?command=GO_TO_MAIN_PAGE">
        <img class="header-logo-src" src="/hotel-logo.jpg"  alt="Logo" >
    </a>
</div>
<ul>

    <li class="local">
        <form action="Controller?command=changeLanguage" method="post">
            <input type="hidden" name="language" value="en"/> <input type="submit" class="local" value="${en_button}">
        </form>
        <form action="Controller?command=changeLanguage" method="post">
            <input type="hidden" name="language" value="ru"/> <input type="submit" class="local" value="${ru_button}"><br/>
        </form>
    </li>


    <li class="log-in">
        <c:if test="${empty sessionScope.login}" >
            <a href="Controller?command=GO_TO_AUTHORIZATION_PAGE">${authorization}</a>
        </c:if>
        <c:if test="${not empty sessionScope.login}" >
            <a href="Controller?command=GO_TO_ACCOUNT_PAGE">${my_account}</a>
                <a href="Controller?command=logOut">${log_out}</a>
                <input type="hidden" name="command" value="logOut" />
            </form>
        </c:if>
    </li>

    <li class="dropdown">
        <a  href="javascript:void(0)" class="dropbtn">${about}</a>
        <div class="dropdown-content">
            <a href="Controller?command=GO_TO_INFO_PAGE">${info}</a>
            <a href="Controller?command=GO_TO_CONTACTS_PAGE">${contacts}</a>
        </div>
    <li><a href="Controller?command=showRooms">${rooms}</a></li>
    <li><a href="Controller?command=GO_TO_REQUEST_PAGE">${book_room}</a></li>

</ul>
</body>
</html>
