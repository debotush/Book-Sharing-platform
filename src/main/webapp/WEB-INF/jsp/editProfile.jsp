<%--
  Created by IntelliJ IDEA.
  User: DEBOTUSH
  Date: 8/14/2019
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Profile Information Update</title>

    <%@include file="bootstrapFiles.jsp" %>
</head>
<body>
<%@include file="navBar.jsp" %>

<h4 class="text-center">${user.fullName}'s Profile Information</h4>

<form:form modelAttribute="user" method="post" enctype="multipart/form-data">
    <div class="card book-share-card">
        <div class="card-body">
            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="fullName">Full name</form:label>
                </div>
                <div class="col-sm-8  form-group">
                    <form:input path="fullName" size="20" maxlength="20" cssClass="form-control" required="required"/>
                    <form:errors path="fullName"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="userName">Username</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <form:input path="userName" size="20" maxlength="20" cssClass="form-control" required="required"/>
                    <form:errors path="userName"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4  form-group">
                    <form:label path="userPassword">Password</form:label>
                </div>
                <div class="col-sm-8  form-group">
                    <form:password path="userPassword" size="20" maxlength="20" cssClass="form-control" required="required"/>
                    <form:errors path="userPassword"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="userMail">Email Address</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <form:input path="userMail" size="20" maxlength="20" cssClass="form-control" required="required"/>
                    <form:errors path="userMail"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="userContact">Phone</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <form:input path="userContact" size="20" maxlength="20" cssClass="form-control" required="required"/>
                    <form:errors path="userContact"/>
                </div>
            </div>

            <input type="hidden" name="userType" value="${user.userType}">
            <input type="hidden" name="userId" value="${user.userId}">
        </div>
    </div>

    <div class="logo-div text-right" style="margin-top: 20px;">
        <input type="submit" name="button" class="btn btn-lg btn-primary" onclick="isEdit()" value="Save"/>
    </div>

</form:form>
</body>
</html>
