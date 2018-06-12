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

    <%@ include file="parts/header.jsp" %>

    <div id="site_content">
        <%@include file="parts/sidebar.jsp" %>
        <div id="content">
            <h3><fmt:message key="showdata.yourdata" /></h3>

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

                        <c:if test="${sessionScope.stuffElement!=null}">
                            <hr/>
                            <img src="${stuffElement.linkToMaterial}" width="600">
                            <h2><fmt:message key="content.table.date" />: ${stuffElement.dateOfCreation}</h2>
                            <h2><fmt:message key="content.table.prescription" />: ${stuffElement.prescription}</h2>
                            <hr/>
                        </c:if>

        </div>
    </div>

    <%@ include file="parts/footer.jsp" %>
</div>

</body>
</html>
