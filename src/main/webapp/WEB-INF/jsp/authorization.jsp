<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.language}" />
    <fmt:setBundle basename="prop" var="lang" />
    <fmt:message bundle="${lang}" key="authorization.authorization" var="auth" />
    <fmt:message bundle="${lang}" key="authorization.login" var="login" />
    <fmt:message bundle="${lang}" key="authorization.login_message" var="login_mes" />
    <fmt:message bundle="${lang}" key="authorization.password" var="passw" />
    <fmt:message bundle="${lang}" key="authorization.password_message" var="passw_mes" />
    <fmt:message bundle="${lang}" key="authorization.log_in_button" var="log_in" />
    <fmt:message bundle="${lang}" key="authorization.not_registered" var="not_reg" />
    <fmt:message bundle="${lang}" key="authorization.register" var="register" />
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


    </style>

</head>

<body>

<jsp:include page="header.jsp" />
<br>


<form action="Controller" method="post">
    <input type="hidden" name="command" value="logination">
    <div>
 <fieldset>
     <font color="red" size="5">
         <c:if test="${param.message!=null}">
         <c:out value="${param.message}" />
     </c:if>
     </font>
<legend><h1>${auth}</h1></legend>
 <br/>
     <br/>
<label for="login">${login}</label>
 <br/>
    <input type="text" id="login" name="login" placeholder=${login_mes}>
 <br/>
<label for="password">${passw}</label>
 <br/>
    <input type="password" id="password" name="password" placeholder=${passw_mes}>
 <br/>
 <input type="submit" value=${log_in} />
 <br/><br/>
${not_reg} <a href="Controller?command=GO_TO_REGISTRATION_PAGE">${register}</a>
   </fieldset>
</div>
    <p><c:out value="${requestScope.mas}"/></p>
</form>
</body>
</html>