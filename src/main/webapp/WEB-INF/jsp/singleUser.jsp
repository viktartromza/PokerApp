<%@ page import="com.tms.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: Viktar
  Date: 07.02.2023
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User userJsp = (User) request.getAttribute("user");%>
<html>
<head>
    <title>User info</title>
</head>
<body>
<h1> Hello, this is your User!</h1>
<h3>User id:  <%=userJsp.getId()%></h3>
<h3>User login:  <%=userJsp.getLogin()%></h3>
<h3>User password:  <%=userJsp.getPassword()%></h3>
<h3>User registration date:  <%=userJsp.getRegDate()%></h3>
<h3>User email:  <%=userJsp.getEmail()%></h3>
<h3>User score:  <%=userJsp.getScore()%></h3>

<h3>User first name:  <%=userJsp.getFirstName()%></h3>
<h3>User last name:  <%=userJsp.getLastName()%></h3>
<h3>User birthdate:  <%=userJsp.getBirthDay()%></h3>
<h3>User telephone:  <%=userJsp.getTelephone()%></h3>
<h3>User balance:  <%=userJsp.getBalance()%>$</h3>
</body>
</html>
