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
                <li><a href="/view/adminPage.jsp"><fmt:message key="menu.home" /></a></li>
                <li class="selected"><a href="/view/addData.jsp"><fmt:message key="menu.adddata" /></a></li>
                <li><a href="#"></a></li>
                <li><a href="/LogOut"><fmt:message key="menu.logout" /></a></li>
            </ul>
        </div>
    </div>
    <div id="content_header"></div>

    <div id="site_content">
        <%@include file="parts/sidebar.jsp" %>
        <div id="content">
            <div class="container">
                <h3>Add Data</h3>
                <form method="post" action="/AddData" <%--onsubmit="alert('Added!')"--%>>
                    <h3>User</h3>
                    <select name="selected_user_field">
                        <c:forEach items="${userList}" var="user">
                            <option value="${user.id}"><c:out
                                    value="${user.login}" /></option>
                        </c:forEach>
                    </select>

                    <h3>Name of file</h3>
                    <input required type="text" class="form-control" name="name_of_file_field"/>

                    <h3>link</h3>
                    <input required class="form-control" type="text" name="link_field"/>
                    <h3>date</h3>
                    <input required class="form-control" type="date" name="date_field" />
                    <h3>coordinates</h3>
                    <input required class="form-control" type="text" name="coordinates_field"/>
                    <h3>prescription</h3>
                    <input required class="form-control" type="text" name="prescription_field"/>

                    <br/>
                    <input type="submit" class="btn btn-primary active" value="Add"/>

                </form>

            </div>

        </div>
    </div>

    <div id="footer">
        <a href="adminPage.jsp"><fmt:message key="menu.home" /></a> | <a href="addData.jsp"><fmt:message key="menu.adddata" /></a>
    </div>
</div>

</body>
</html>
