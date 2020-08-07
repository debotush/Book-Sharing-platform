<%--
  Created by IntelliJ IDEA.
  User: DEBOTUSH
  Date: 8/22/2019
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Report</title>
    <%@include file="bootstrapFiles.jsp"%>
</head>
<body>
<%@include file="navBar.jsp"%>
<div class="card book-share-card">
    <div class="card-body">
        <div class="row">
            <div class="col-sm-12 form-group">
                <div class="logo-div text-right" style="margin-top: 20px;">
                    <a href="/report/topUsers" class="btn btn-primary btn-block">Top Contributors of the System</a>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12 form-group">
                <div class="logo-div text-right" style="margin-top: 20px;">
                    <a href="/report/topSharedBooks" class="btn btn-primary btn-block">Top Shared Books</a>
                </div>
            </div>
        </div>
   </div>
</div>
</body>
</html>
