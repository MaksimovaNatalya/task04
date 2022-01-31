<%--
  Created by IntelliJ IDEA.
  User: MaxMoff
  Date: 25.01.2022
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request confirmation</title>
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
        img{
            width: 50%;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<br/>
<br/>
<h1>
    Thank you for your request! <br/>
    The request is being processed. <br/>
    You can find its status in your account. <br/>
    <br/>
    <a href="Controller?command=GO_TO_INDEX_PAGE">Return to the main page</a>
</h1>
</body>
</html>
