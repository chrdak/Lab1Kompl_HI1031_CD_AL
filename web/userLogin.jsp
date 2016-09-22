<%--
  Created by IntelliJ IDEA.
  User: Degern
  Date: 2016-09-22
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="UI.ProductVM" %>

<html>
<head>
    <title>UserLogin$</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        session.setAttribute("username", username);
        session.setAttribute("password", password);
    %>
    Logged in: <%= (String) session.getAttribute("username")%>
    <br>
    Products:
    <br>
    <% for(int i = 0; i < ProductVM.getAllProducts().size(); i+=1) { %>
    <ul>
        <form method="post" action="userLogin.jsp">
            <li><%=ProductVM.getAllProducts().get(i).getName()%>
                <button type="submit"> Add to cart </button></li>
        </form>

    </ul>
    <% } %>

</body>
</html>
