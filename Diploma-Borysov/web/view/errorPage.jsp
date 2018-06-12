<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 08.05.2018
  Time: 1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="parts/includes.jsp"%>

<%@ include file="parts/head.jsp"%>

<body>
<div id="main">
    <div id="header">
        <div id="logo">
            <div id="logo_text">
                <h1><a href="../index.jsp"><span class="logo_colour"><c:out value="Field-View" /></span></a></h1>
            </div>
        </div>
        <div id="menubar">
            <ul id="menu">
                <li><a href="../index.jsp"><fmt:message key="menu.main" /></a></li>
            </ul>
        </div>
    </div>
    <div id="content_header"></div>
    <div id="site_content">
        <div id="content">
            <h2><fmt:message key="error.message" /></h2>

        </div>
    </div>

    <div id="footer">
        <fmt:message key="footer.sign" />
    </div>
</div>
</body>
</html>

