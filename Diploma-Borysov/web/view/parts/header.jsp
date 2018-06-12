<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 09.05.2018
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div id="header">
    <div id="logo">
        <div id="logo_text">
            <h1><a href="mainPage.jsp"><span class="logo_colour"><c:out value="Field-View"/></span></a></h1>
        </div>
        <div class="language">
            <h4>
                <form>
                    <select id="language" name="language" onchange="submit()">
                        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                        <option value="ua" ${language == 'ua' ? 'selected' : ''}>Ukrainian</option>
                    </select>
                </form>
            </h4>
        </div>
    </div>
    <div id="menubar">
        <ul id="menu">
            <li><a href="/view/mainPage.jsp"><fmt:message key="menu.home" /></a></li>
            <li><a href="/view/showData.jsp"><fmt:message key="menu.showdata" /></a></li>
            <li><a href="/view/dataAnalysis.jsp"><fmt:message key="menu.dataanalisys" /></a></li>
            <li><a href="/view/contact.jsp"><fmt:message key="menu.contact" /></a></li>
            <li><a href="#"></a></li>
            <li><a href="/LogOut"><fmt:message key="menu.logout" /></a></li>

        </ul>

    </div>
</div>
<div id="content_header"></div>