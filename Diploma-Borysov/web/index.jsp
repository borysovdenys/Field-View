<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 30.04.2018
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" scope="session" />
<fmt:setBundle basename="text" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${language}">

<head>
  <title><c:out value="Field-View" /></title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <link rel="shortcut icon" href="/css/assets/icon-48.ico" type="image/x-icon">

    <link rel="stylesheet" type="text/css" href="css/style.css" title="style" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-4.1.1-dist/css/bootstrap.css" title="style"/>
</head>

<body>
<div id="main">
  <div id="header">
    <div id="logo">
      <div id="logo_text">
        <h1><a href="index.jsp"><span class="logo_colour"><fmt:message key="header.title" /></span></a></h1>
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
        <li class="selected"><a href="index.jsp"><fmt:message key="menu.main" /></a></li>
      </ul>
    </div>
  </div>
  <div id="content_header"></div>
  <div id="site_content">
      <div class="sidebar">
        <h2><fmt:message key="index.login.title" /></h2>
        <div class="form-group">
        <c:if test="${requestScope.errorLogIn!=null}">
          <span class="error"><h4><fmt:message key="index.login.error" /></h4></span>
        </c:if>

        <form method="post" action="LoginController">
          <input required type="text" class="form-control tabb" name="login_field" placeholder="<fmt:message key="index.login.log" />"/>
          <input required type="password" class="form-control tabb" name="password_field"  placeholder="<fmt:message key="index.login.pass" />"/>
          <input class="btn btn-primary tabb" type="submit"  value="<fmt:message key="index.login.enter" />">
        </form>
          <a href="register.jsp">
            <button type="submit" class="btn-full btn btn-outline-primary "><fmt:message key="index.login.register" /></button>
          </a>
        </div>
      </div>
      <div id="content">
        <h2><fmt:message key="index.content.title" /></h2>
        <img width="600"
             src="assets/image/front.jpg">
        <h3><p align="justify"><fmt:message key="index.content.text" /></p></h3>
      </div>
    </div>

    <div id="footer">
        <fmt:message key="footer.sign" />
    </div>
</div>
</body>
</html>

