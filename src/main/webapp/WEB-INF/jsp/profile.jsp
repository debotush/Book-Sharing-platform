<%--
  Created by IntelliJ IDEA.
  User: DIPTOPOL
  Date: 8/13/2019
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Profile Information</title>

    <%@include file="bootstrapFiles.jsp"%>
</head>
<body>
<%@include file="navBar.jsp"%>

<h4 class="text-center">${user.fullName}'s Information</h4>

<div class="card book-share-card">
    <div class="card-body">
        <div class="row">
            <div class="col-sm-4 form-group">
                <label>Full Name</label>
            </div>
            <div class="col-sm-8 form-group">
                <c:out value="${user.fullName}"/>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-4 form-group">
                <label>Username</label>
            </div>
            <div class="col-sm-8 form-group">
                <c:out value="${user.userName}"/>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-4 form-group">
                <label>Email Address</label>
            </div>
            <div class="col-sm-8 form-group">
                <c:out value="${user.userMail}"/>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-4 form-group">
                <label>Phone</label>
            </div>
            <div class="col-sm-8 form-group">
                <c:out value="${user.userContact}"/>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-4 form-group">
                <label>Type</label>
            </div>
            <div class="col-sm-8 form-group">
                <c:out value="${user.userType}"/>
            </div>
        </div>
    </div>

    <c:url value="editProfile" var = "editProfile">
        <c:param name="userId" value="${user.userId}"/>
    </c:url>


</div>

<div class="logo-div text-right" style="margin-top: 20px;">
    <a href="${editProfile}" class="btn btn-primary">Update</a>
</div>

<c:if test="${not user.admin}">
    <h4 class="text-center" style="margin-top: 20px">Requested book list of ${user.fullName}</h4>

    <c:choose>
        <c:when test="${empty list}">
            <div class="alert alert-info table-div text-center">
                Currently, there is no new request for the book.
            </div>
        </c:when>
        <c:otherwise>
            <div class="table-responsive table-div">
                <table class="table table-hover">
                    <thead class="thead-light">
                    <tr>
                        <th>Book Name</th>
                        <th>Book Author</th>
                        <th>Owner</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="transaction" items="${list}">
                        <c:choose>
                            <c:when test="${transaction.approved}" >
                                <tr>
                                    <td>${transaction.book.bookName}</td>
                                    <td>${transaction.book.bookAuthor}</td>
                                    <td>${transaction.owner.fullName}</td>
                                    <td>
                                        <c:url value="/pdf/download" var="download">
                                            <c:param name="bookId" value="${transaction.bookId}"/>
                                        </c:url>
                                        <a href="${download}" class="btn btn-success" >Download</a>
                                    </td>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td>${transaction.book.bookName}</td>
                                    <td>${transaction.book.bookAuthor}</td>
                                    <td>${transaction.owner.fullName}</td>
                                    <td>
                                        <c:url value="/pdf/download" var="download">
                                            <c:param name="transactionId" value="${transaction.transactionId}"/>
                                        </c:url>
                                        <a href="#" class="btn btn-success disabled">Download</a>
                                    </td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:otherwise>
    </c:choose>
</c:if>
</body>
</html>
