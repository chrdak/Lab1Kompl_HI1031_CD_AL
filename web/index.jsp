<%--
  Created by IntelliJ IDEA.
  User: Degern
  Date: 2016-09-21
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>

<html>
  <head>
    <title>Login Page$</title>
  </head>
  <body>
     <form method="post" action="userLogin.jsp">
        <td> Name </td>
            <td><input type = "text" name = "username" value = "" />

        <td> Password </td>
            </td><input type = "password" name = "password" value = "" />
        <tr>
            <td><input type = "submit" value = "Login" />
     </tr>
     </form>
  </body>
</html>
