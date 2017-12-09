<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07-12-2017
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page='/WEB-INF/jsp/jscsslibs.jsp'></jsp:include>
    <jsp:include page='/WEB-INF/jsp/gsignin.jsp'></jsp:include>
    <!--<link rel="stylesheet" href="/css/bootstrap.min.css" />
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/popper.min.js"></script>
    <script src="/js/tether.min.js"></script>
    <script src="/webjars/bootstrap.min.js"></script>-->

    <title>Home</title>
</head>
<body>
<jsp:include page='/WEB-INF/jsp/topmenuhome.jsp'></jsp:include>
<jsp:include page='/WEB-INF/jsp/mainmenu.jsp'></jsp:include>
<jsp:include page='/WEB-INF/jsp/actionmenu.jsp'></jsp:include>
<jsp:include page='/WEB-INF/jsp/body.jsp'></jsp:include>
</body>
</html>
