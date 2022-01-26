
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="by.epam.tc.project.controller.util.*" %>
<html>
<head>
<style>
    body {
        background: #B0E0E6;
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
<jsp:include page="header.jsp" />

<img src="/background.gif"  alt="Hotel" >

</body>
</html>
