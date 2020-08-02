<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="formm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Uploading book</title>

    <%@include file="bootstrapFiles.jsp" %>
</head>

<body>
<%@include file="navBar.jsp" %>

<h4 class="text-center">Book Upload</h4>
<form:form modelAttribute="book" method="post" enctype="multipart/form-data">
    <div class="card book-upload-page book-upload-card">
        <div class="card-body">
            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="bookName">Book Title</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <form:input path="bookName" size="100" maxlength="100" cssClass="form-control" placeholder="Name" required="required"/>
                    <form:errors path="bookName"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="bookEdition">Book Edition</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <form:input path="bookEdition" size="20" maxlength="20" cssClass="form-control" placeholder="Edition" required="required"/>
                    <form:errors path="bookEdition"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="bookPublication">Book Publication</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <form:input path="bookPublication" size="20" maxlength="20" cssClass="form-control" placeholder="Publication" required="required"/>
                    <form:errors path="bookPublication"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="bookAuthor">Book Author</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <form:input path="bookAuthor" size="20" maxlength="20" cssClass="form-control" placeholder="Author" required="required"/>
                    <form:errors path="bookAuthor"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="bookCategory">Book Type:</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <form:select path="bookCategory" items="${bookTypeOptionList}" cssClass="form-control" placeholder="Category" required="required"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="uploadedCoverPhotoOfBook" for="coverPhotoOfBook">Book Cover Photo:</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <input id="coverPhotoOfBook" name="uploadedCoverPhotoOfBook" type="file" cssClass="form-control" placeholder="Cover Photo of Book"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-4 form-group">
                    <form:label path="uploadedBook" for="uploadedBook">Book:</form:label>
                </div>
                <div class="col-sm-8 form-group">
                    <input id="uploadedBook" name="uploadedBook" type="file" cssClass="form-control" placeholder="Book"/>
                </div>
            </div>

            <input type="hidden" name="uploaderId" value="${sessionScope.currentUser.userId}"/>
        </div>
    </div>

    <div class="book-upload-page text-right" style="margin-top: 20px;">
        <input type="submit" name="button" class="btn btn-lg btn-primary" value="Upload"/>
    </div>
</form:form>
</body>
</html>
