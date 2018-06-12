<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 23.04.2018
  Time: 16:07
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
    <link rel="shortcut icon" href="/css/assets/icon-48.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="css/style.css" title="style"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title><c:out value="Field-View"/></title>
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


    <div id="site_content">
        <div id="content">
            <div class="container">
                <h3><fmt:message key="reg.form.title" /></h3>
                <form method="post" action="RegisterController" id="register" onsubmit="alert('<fmt:message key="reg.form.message" />')">
                    <h3><fmt:message key="reg.form.login" /></h3>
                    <input required type="text" class="form-control" name="login_field"/>
                    <h3><fmt:message key="reg.form.password" /></h3>
                    <input required type="password" class="form-control" name="password_field" pattern="[a-zA-Z0-9]{8,30}$"
                           placeholder="<fmt:message key="reg.form.password.condition" />"/>

                    <h3><fmt:message key="reg.form.email" /></h3>
                    <input required class="form-control" type="email" name="email_field"/>
                    <h3><fmt:message key="reg.form.name" /></h3>
                    <input required class="form-control" type="text" name="name_field" pattern="[a-zA-Zа-яА-Я]+"/>
                    <h3><fmt:message key="reg.form.city" /></h3>
                    <input required class="form-control" type="text" name="city_field"/>

                    <br/>
                    <a href="index.jsp">
                        <button type="button" class="btn btn-secondary"><fmt:message key="button.cancel" /></button>
                    </a>
                    <input type="submit" class="btn btn-primary active" value="<fmt:message key="reg.button" />"/>

                </form>

            </div>
        </div>
    </div>

    <div id="footer">
        <fmt:message key="footer.sign" />
    </div>


</div>

</body>
</html>
