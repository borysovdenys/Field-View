<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 07.05.2018
  Time: 1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="parts/includes.jsp"%>
<%@ include file="parts/head.jsp" %>

<body>
<div id="main">

    <div id="header">
        <div id="logo">
            <div id="logo_text">
                <h1><a href="adminPage.jsp"><span class="logo_colour"><c:out value="Field-View"/></span></a></h1>
            </div>
        </div>
        <div id="menubar">
            <ul id="menu">
                <li class="selected"><a href="/view/adminPage.jsp"><fmt:message key="menu.home" /></a></li>
                <li><a href="/view/addData.jsp"><fmt:message key="menu.adddata" /></a></li>
                <li><a href="#"></a></li>
                <li><a href="/LogOut"><fmt:message key="menu.logout" /></a></li>
            </ul>
        </div>
    </div>
    <div id="content_header"></div>

    <div id="site_content">
        <%@include file="parts/sidebar.jsp" %>
        <div id="content">
            <h3><fmt:message key="showdata.yourdata" /></h3>

            <table>

                <tr>
                    <th align="center"><fmt:message key="content.table.number" /></th>
                    <th align="center"><fmt:message key="content.table.login" /></th>
                    <th align="center"><fmt:message key="content.table.email" /></th>
                    <th align="center"><fmt:message key="content.table.name" /></th>
                    <th align="center"><fmt:message key="content.table.city" /></th>
                    <th align="center" width="15%"></th>
                </tr>
                <c:forEach items="${userList}" var="user" varStatus="status">
                    <tr>
                        <td align="center"><c:out value="${status.count}"/></td>
                        <td align="center">${user.login}</td>
                        <td align="center">${user.email}</td>
                        <td align="center">${user.name}</td>
                        <td align="center">${user.city}</td>

                        <c:url var="showElementLink" value="/ShowUserStuffController">
                            <c:param name="user_id" value="${user.id}"/>
                        </c:url>
                        <td align="center"><a href="${showElementLink}"><fmt:message key="content.table.showinfo" /></a></td>
                    </tr>
                </c:forEach>

            </table>

            <h2 id="stopper">
                <c:out value="${selectedUser.login}"/>
            </h2>

            <c:if test="${sessionScope.stuffList!=null}">
                <table>

                    <tr>
                        <th align="center"><fmt:message key="content.table.number" /></th>
                        <th align="center"><fmt:message key="content.table.name" /></th>
                        <th align="center"><fmt:message key="content.table.date" /></th>
                        <th align="center"><fmt:message key="content.table.coordinates" /></th>
                        <th align="center"></th>
                    </tr>
                    <c:forEach items="${stuffList}" var="stuff" varStatus="status">
                        <tr>
                            <td align="center"><c:out value="${status.count}"/></td>
                            <td align="center">${stuff.name}</td>
                            <td align="center">${stuff.dateOfCreation}</td>

                            <td align="center">${stuff.coordinates}</td>
                            <c:url var="showElementLink" value="/ShowDataController">
                                <c:param name="stuff_id" value="${stuff.id}"/>
                            </c:url>
                            <td align="center"><a href="${showElementLink}"><fmt:message key="content.table.showinfo" /></a></td>
                        </tr>
                    </c:forEach>

                </table>
            </c:if>

            <c:if test="${sessionScope.stuffElement!=null}">
                <hr/>
                <img src="${stuffElement.linkToMaterial}" width="600">
                <h2><fmt:message key="content.table.date" />: ${stuffElement.dateOfCreation}</h2>
                <h2><fmt:message key="content.table.prescription" />: ${stuffElement.prescription}</h2>
                <hr/>
            </c:if>

        </div>
    </div>
    <script>
        window.onload = function()
        {
            document.getElementById('stopper').scrollIntoView(true);
        }
    </script>

    <div id="footer">
        <a href="adminPage.jsp"><fmt:message key="menu.home" /></a> | <a href="addData.jsp"><fmt:message key="menu.adddata" /></a>
    </div>
</div>

</body>
</html>
