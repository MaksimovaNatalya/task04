<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

</head>
<body>
<%
    String regInfo = (String) request.getAttribute("registrationInfo");
    if (regInfo != null) {
%>
<h2>
<%
  out.println(regInfo);
        }
 %>

<%
    String name = (String) request.getAttribute("userName");
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
