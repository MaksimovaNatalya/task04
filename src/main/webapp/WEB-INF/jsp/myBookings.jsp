<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My bookings</title>

    <fmt:setLocale value="${sessionScope.language}" />
    <fmt:setBundle basename="prop" var="lang" />
    <fmt:message bundle="${lang}" key="account.user_info" var="user_info" />
    <fmt:message bundle="${lang}" key="account.my_bookings" var="my_bookings" />
    <fmt:message bundle="${lang}" key="mybookings.room_category" var="room_categ" />
    <fmt:message bundle="${lang}" key="mybookings.maximum_person" var="max_persons" />
    <fmt:message bundle="${lang}" key="mybookings.arr_date" var="arr_date" />
    <fmt:message bundle="${lang}" key="mybookings.depart_date" var="depart_date" />
    <fmt:message bundle="${lang}" key="mybookings.status" var="status" />
    <fmt:message bundle="${lang}" key="mybookings.action" var="action" />
    <fmt:message bundle="${lang}" key="mybookings.cancel" var="cancel" />



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

        table {
            border: 3px solid grey;

        }

        .doNotShow {
            display: none;
        }

        th, td {
            text-align: left;
            border: 1px solid grey;
            padding: 10px 15px;
        }
        button[type=submit] {
            width: 100%;
            background-color: #4682B4;
            color: white;
            padding: 5px 5px;
            margin: 2px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<br/>
<a href="Controller?command=GO_TO_ACCOUNT_PAGE">${user_info}</a> -
<a href="Controller?command=GO_TO_MY_BOOKINGS_PAGE">${my_bookings}</a>
<input type="hidden" name="command" value="GO_TO_MY_BOOKINGS_PAGE">
<br/>

<c:if test="${not empty sessionScope.login}">

    <br>
    <table>
        <tr class="doNotShow"><th>Id</th><td>${request.id}</td></tr>
        <tr>
            <th>${room_categ}</th>
            <th>${max_persons}</th>
            <th>${arr_date}</th>
            <th>${depart_date}</th>
            <th>${status}</th>
            <th>${action}</th>
        </tr>
        <tr>
            <c:forEach var="request" items="${requestScope.allRequests}">
            <td><c:out value="${request.category}"/></td>
            <td><c:out value="${request.maxPersons}"/></td>
            <td><c:out value="${request.startDate}"/></td>
            <td><c:out value="${request.endDate}"/></td>
            <td><c:out value="${request.status}"/></td>
            <td>
                <c:if test="${request.status eq 'in progress'}" >
                <form>
                    <input type="hidden" name="command" value="cancelBooking">
                    <button type="submit" id="cancelBooking" name="cancelBooking" value="${request.id}">
                        ${cancel}</button>
                </form>
                </c:if>
            </td>
        </tr>
        </c:forEach>
    </table>


</c:if>

</body>
</html>
