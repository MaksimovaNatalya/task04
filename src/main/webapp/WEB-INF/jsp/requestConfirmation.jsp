<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request confirmation</title>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:setBundle basename="prop" var="lang"/>
    <fmt:message bundle="${lang}" key="request_conf.message1" var="mes1"/>
    <fmt:message bundle="${lang}" key="request_conf.message2" var="mes2"/>
    <fmt:message bundle="${lang}" key="request_conf.message3" var="mes3"/>
    <fmt:message bundle="${lang}" key="request_conf.return" var="returnToMain"/>
    <fmt:message bundle="${lang}" key="request_conf.toAccount" var="toAccount"/>

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

        h1 {
            background: antiquewhite;
            text-align: center;
            padding: 12px 32px;
            font-size: 18pt;
        }

        img {
            width: 50%;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<br/>
<br/>
<h1>
    ${mes1} <br/>
    ${mes2} <br/>
    ${mes3}
        <a href="Controller?command=GO_TO_MY_BOOKINGS_PAGE"> ${toAccount}</a>
    <br/>
</h1>
    <a href="Controller?command=GO_TO_INDEX_PAGE"> ${returnToMain}</a>



</body>
</html>
