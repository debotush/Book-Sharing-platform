<%--
  Created by IntelliJ IDEA.
  User: DEBOTUSH
  Date: 8/22/2019
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book Feed</title>
    <%@include file="bootstrapFiles.jsp" %>
</head>
<body>
<%@include file="navBar.jsp" %>

<h4 class="text-center">Book Collection</h4>

<c:choose>
    <c:when test="${empty bookList}">
        <div class="alert alert-info table-div text-center">
            Currently, no book is available.
        </div>
    </c:when>
    <c:otherwise>
        <div class="table-responsive table-div">
            <table class="table table-hover">
                <thead class="thead-light">
                <tr>
                    <th>Book Name</th>
                    <th>Book Edition</th>
                    <th>Book Publication</th>
                    <th>Book Author</th>
                    <th>Book Type</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${bookList}">
                    <tr>
                        <td>${book.bookName}</td>
                        <td>${book.bookEdition}</td>
                        <td>${book.bookPublication}</td>
                        <td>${book.bookAuthor}</td>
                        <td>${book.bookCategory}</td>
                        <td>
                            <c:choose>
                                <c:when test="${sessionScope.currentUser.admin}">
                                    <c:url value="/book/detail" var="bookDetailLink">
                                        <c:param name="bookId" value="${book.bookId}"/>
                                    </c:url>
                                    <a href="${bookDetailLink}" class="btn btn-primary">Details</a>
                                </c:when>
                                <c:when test="${excludeOwner}">
                                    <c:set var="showRequestedBy" value="${showRequestedByButtonMap[book.bookId]}"/>

                                    <c:url value="/request" var="bookRequestLink">
                                        <c:param name="bookId" value="${book.bookId}"/>
                                    </c:url>
                                    <c:url value="/review" var="reviewLink">
                                        <c:param name="bookId" value="${book.bookId}"/>
                                    </c:url>
                                    <div class="btn-group">
                                        <a href="${bookRequestLink}"
                                           class="btn btn-outline-success" ${not showRequestedBy ? 'disabled' : ''}>Request</a>
                                        <a href="${reviewLink}" class="btn btn-outline-dark">Review</a>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <c:url value="/book/detail" var="bookDetailLink">
                                        <c:param name="bookId" value="${book.bookId}"/>
                                    </c:url>
                                    <a href="${bookDetailLink}" class="btn btn-outline-primary">Details</a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:otherwise>
</c:choose>


</body>
</html>
