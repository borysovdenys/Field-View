<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 15.05.2018
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="parts/includes.jsp"%>

<%@ include file="parts/head.jsp"%>

<body>
<div id="main">
    <%@ include file="parts/header.jsp"%>

    <div id="site_content">
        <%@include file="parts/sidebar.jsp"%>
        <div class="form-group">

            <form action="/ContactController" method="post">

                <h2>
                    <fmt:message key="contact.message" />
                </h2>
                <h2 style="color: darkblue">
                    <c:if test="${requestScope.messageSent!=null}">
                        <fmt:message key="contact.messageHaveSent" />
                    </c:if>

                </h2>
                <textarea required rows="8" cols="50" class="form-control-message" name="contact_message_field" placeholder="<fmt:message key="contact.text" />"></textarea>
                <br>
                <input type="submit" class="btn btn-primary btn-lg active"
                       value="<fmt:message key="contact.button" />" />
            </form>

        </div>
    </div>
    <%@ include file="parts/footer.jsp"%>
</div>
</body>

</html>
