<%--
  Created by IntelliJ IDEA.
  User: DIPTOPOL
  Date: 8/22/2019
  Time: 1:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Book Information</title>
    <%@include file="bootstrapFiles.jsp" %>
</head>
<body>
<%@include file="navBar.jsp" %>

<h4 class="text-center">Edit Book Information</h4>
<form:form modelAttribute="book" method="post" enctype="multipart/form-data">
    <div class="card book-upload-page book-upload-card">
        <div class="card-body">
            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="bookName">Book Name</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <form:input path="bookName" size="20" maxlength="20" cssClass="form-control" required="required"/>
                    <form:errors path="bookName"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="bookEdition">Book Edition</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <form:input path="bookEdition" size="20" maxlength="20" cssClass="form-control" required="required"/>
                    <form:errors path="bookEdition"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="bookPublication">Book Publication</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <form:input path="bookPublication" size="20" maxlength="20" cssClass="form-control" required="required"/>
                    <form:errors path="bookPublication"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="bookAuthor">Book Author</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <form:input path="bookAuthor" size="20" maxlength="20" cssClass="form-control"/>
                    <form:errors path="bookAuthor"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="bookCategory">Book Type:</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <form:select path="bookCategory" items="${bookTypeOptionList}" cssClass="form-control"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="uploadedCoverPhotoOfBook" for="coverPhotoOfBook">Book Cover Photo:</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <input id="coverPhotoOfBook" name="uploadedCoverPhotoOfBook" type="file" cssClass="form-control"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="uploadedBook" for="uploadedBook">Book:</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <input id="uploadedBook" name="uploadedBook" type="file" cssClass="form-control"/>
                </div>
            </div>
            <input type="hidden" name="uploaderId" value="${sessionScope.currentUser.userId}"/>
        </div>
    </div>

    <div class="book-upload-page text-right" style="margin-top: 20px;">
        <input type="submit" name="button" class="btn btn-lg btn-primary" value="Update"/>
    </div>
</form:form>

</body>
</html>
