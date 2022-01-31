<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Requests</title>
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
        button[type=submit].approve {
            width: 100%;
            background-color: darkgreen;
            color: white;
            padding: 5px 5px;
            margin: 2px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button[type=submit].decline {
            width: 100%;
            background-color: darkred;
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
<a href="Controller?command=GO_TO_ACCOUNT_PAGE">User Info</a> -
<a href="Controller?command=GO_TO_ALL_REQUESTS_PAGE">All requests</a>
<input type="hidden" name="command" value="showAllRequests">
<br/>

<c:if test="${not empty sessionScope.login}">

    <br>
    <table>

        <tr>
            <th>№</th>
            <th>Room category</th>
            <th>Room number</th>
            <th>Maximum persons</th>
            <th>Arrival date</th>
            <th>Departure date</th>
            <th>Guest</th>
            <th>Status of the booking</th>
            <th>Action</th>
        </tr>
        <tr>
            <c:forEach var="request" items="${requestScope.allRequests}">
            <c:set var="request.id" value="${request.id}" scope="request" />
            <td><c:out value="${request.id}"/></td>
            <td><c:out value="${request.category}"/></td>
            <td><c:out value="${request.roomsId}"/></td>
            <td><c:out value="${request.maxPersons}"/></td>
            <td><c:out value="${request.startDate}"/></td>
            <td><c:out value="${request.endDate}"/></td>
            <td><c:out value="${request.usersId}"/></td>
            <td><c:out value="${request.status}"/></td>
            <td>
                <c:if test="${request.status eq 'in progress'}">
                    <form>
                        <input type="hidden" name="command" value="approveRequest">
                        <button type="submit" class="approve" id="approve" name="approve" value="${request.id}">approve</button>
                </form>
                    <form>
                        <input type="hidden" name="command" value="declineRequest">
                        <button type="submit" class="decline" id="decline" name="decline" value="${request.id}">decline</button>
                    </form>
                </c:if>
            </td>
        </tr>
        </c:forEach>
    </table>

</form>
</c:if>
</body>
</html>
