<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 15.05.2018
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="sidebar">
    <h4><fmt:message key="sidebar.you" /></h4>
    <h2>
        <c:out value="${currentUser.name}"/>
    </h2>
</div>
