<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>

</head>
<body>




<%
    String regInfo = request.getParameter("registrationInfo");
    if (regInfo != null) {
%>
<h2>
<%
  out.println(regInfo);
        }
 %>
</h2>

<%
    String name = (String) request.getParameter("userName");
    if (name!=null){
%>
<h2>
    <%
            out.println(name);
        }
    %>

</h2>


    <h3>!!!!!!!!!!!!!!!!!</h3>
</body>
</html>
