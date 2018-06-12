<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 07.05.2018
  Time: 1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="parts/includes.jsp"%>
<%@ include file="parts/head.jsp"%>

<body>
<div id="main">
    <%@ include file="parts/header.jsp"%>

    <div id="site_content">
        <%@include file="parts/sidebar.jsp"%>
        <div id="content">
            <video width="600" controls="controls" poster="image" preload="true" autoplay>
                <source src="../assets/video/Example1.mp4" type="video/mp4"  /> </video>
            <h3><p align="justify"> <fmt:message key="mainpage.content" /></p></h3>
        </div>
    </div>
<%@ include file="parts/footer.jsp"%>
</div>
</body>
</html>
