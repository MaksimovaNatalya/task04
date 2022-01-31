<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

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
        .local{
            float:right;
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

        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=password], select {
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

        input[type=submit]:hover {
            background-color: #4682B4;
        }

        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }

        footer {
            padding: 30px 0;
            background: #3C3D41;
            text-decoration-color: white;
        }

        span-name {
            width: 33.3333333333%;
            float: left;
        }

        span-contacts {
            width: 33.3333333333%;
            float: right;
        }
table{
    border: 3px solid grey;

}
        .doNotShow{display:none;}

        th, td{
            text-align: left;
            border: 1px solid grey;
            padding: 10px 15px;
        }

    </style>
</head>
<body>
<jsp:include page="header.jsp" />
<br/>
<c:if test="${requestScope.user.roleId eq 2}" >
<a href="Controller?command=GO_TO_ACCOUNT_PAGE">User Info</a> -
<a href="Controller?command=GO_TO_MY_BOOKINGS_PAGE">My Bookings</a>
<input type="hidden" name="command" value="GO_TO_MY_BOOKINGS_PAGE">
<br/>



<form action="Controller" method="post">
    <input type="hidden" name="command" value="GO_TO_ACCOUNT_PAGE">
    <br>
    <table>

        <tr class="doNotShow"><th>Id</th><td>${requestScope.user.id}</td></tr>
        <tr><th>Login:</th><td> <c:out value="${requestScope.user.login}"  /></td></tr>
        <tr><th>Name:</th><td> <c:out value="${requestScope.user.name}"  /></td></tr>
        <tr><th>Surname:</th><td> <c:out value="${requestScope.user.surname}"  /></td></tr>
        <tr><th>E-mail:</th><td> <c:out value="${requestScope.user.email}"  /></td></tr>
        <tr><th>Country:</th><td> <c:out value="${requestScope.user.country}"  /></td></tr>
        <tr><th>Phone number:</th><td> <c:out value="${requestScope.user.phone}"  /></td></tr>
    </table>

<br>

    <a href="Controller?command=GO_TO_CHANGE_ACCOUNT_INFO_PAGE">
        <input type="button" value="Change info"/>
    </a>

</form>
</c:if>

<c:if test="${requestScope.user.roleId eq 1}" >
    <a href="Controller?command=GO_TO_ACCOUNT_PAGE">User Info</a> -
    <a href="Controller?command=GO_TO_ALL_REQUESTS_PAGE">All requests</a>



    <form action="Controller" method="post">
    <input type="hidden" name="command" value="GO_TO_ACCOUNT_PAGE">
    ADMIN IS HERE
    </form>
</c:if>

</body>
</html>
