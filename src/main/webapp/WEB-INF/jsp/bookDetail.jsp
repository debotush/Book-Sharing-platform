<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Book Information</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <%@include file="bootstrapFiles.jsp" %>
</head>
<body>
<%@include file="navBar.jsp" %>

<h4 class="text-center">${book.bookName}'s Information</h4>

<div class="card book-detail-page book-detail-card">
    <div class="card-body">
        <div class="row">
            <div class="col-sm-4">
                <img src="/book/coverPhoto?bookId=${book.bookId}" class="img-thumbnail" width="100%">
            </div>
            <div class="col-sm-8">
                <div class="row">
                    <div class="col-sm-4 form-group">
                        <label>Book Name</label>
                    </div>
                    <div class="col-sm-8 form-group">
                        <c:out value="${book.bookName}"/>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-4 form-group">
                        <label>Edition</label>
                    </div>
                    <div class="col-sm-8 form-group">
                        <c:out value="${book.bookEdition}"/>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-4 form-group">
                        <label>Publication</label>
                    </div>
                    <div class="col-sm-8 form-group">
                        <c:out value="${book.bookPublication}"/>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-4 form-group">
                        <label>Author</label>
                    </div>
                    <div class="col-sm-8 form-group">
                        <c:out value="${book.bookAuthor}"/>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-4 form-group">
                        <label>Type</label>
                    </div>
                    <div class="col-sm-8 form-group">
                        <c:out value="${book.bookCategory}"/>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-4 form-group">
                        <h6>Rating</h6>
                    </div>
                    <div class="col-sm-8 form-group">
                        <c:forEach begin="1" end="5" varStatus="loop">
                            <span class="fa fa-star ${loop.index <= bookRating ? 'checked' : ''}"></span>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<c:url value="/book/edit" var="editBookLink">
    <c:param name="bookId" value="${book.bookId}"/>
</c:url>

<c:url value="/pdf/download" var="downloadLink">
    <c:param name="bookId" value="${book.bookId}"/>
</c:url>

<c:url value="/book/delete" var="bookDeleteLink">
    <c:param name="bookId" value="${book.bookId}"/>
</c:url>

<div class="book-detail-page text-right" style="margin-top: 20px;">
    <a href="${editBookLink}" class="btn btn-primary">Update</a>
    <a href="${downloadLink}" class="btn btn-secondary">Download</a>
    <a href="${bookDeleteLink}" class="btn btn-danger">Delete</a>
</div>

<c:if test="${not sessionScope.currentUser.admin}">
    <h4 class="text-center" style="margin-top: 20px">Request for ${book.bookName}</h4>

    <c:choose>
        <c:when test="${empty listOfIndividualBookRequest}">
            <div class="alert alert-info table-div text-center">
                Currently, there is no new request for the book.
            </div>
        </c:when>
        <c:otherwise>
            <div class="table-responsive table-div">
                <table class="table table-hover">
                    <thead class="thead-light">
                    <tr>
                        <th>Requested By</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="transaction" items="${listOfIndividualBookRequest}">
                        <tr>
                            <td>${transaction.requestedBy.fullName}</td>
                            <td>
                                <c:url value="/share" var="approvedUser">
                                    <c:param name="transactionId" value="${transaction.transactionId}"/>
                                    <c:param name="status" value="Approve"/>
                                    <c:param name="bookId" value="${transaction.bookId}"/>
                                </c:url>
                                <c:url value="/share" var="declineUser">
                                    <c:param name="transactionId" value="${transaction.transactionId}"/>
                                    <c:param name="status" value="Decline"/>
                                    <c:param name="bookId" value="${transaction.bookId}"/>
                                </c:url>
                                <div class="btn-group">
                                    <a href="${approvedUser}" class="btn btn-success">Approve</a>
                                    <a href="${declineUser}" class="btn btn-secondary">Decline</a>
                                </div>

                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:otherwise>
    </c:choose>
</c:if>

<h4 class="text-center" style="margin-top: 20px">Review of ${book.bookName}</h4>

<div class=" card review-block">
    <c:forEach var="review" items="${ListOfReview}">
        <div class="space">
            <span><h5>${review.user.fullName}</h5></span>
            <div>
                <c:forEach begin="1" end="5" varStatus="loop">
                    <span class="fa fa-star ${loop.index <= review.rating ? 'checked' : ''}"></span>
                </c:forEach>
            </div>
        </div>
        <div class = "inner-review-block">
            <div class="readable stack space" style="right: 0">
                <span>${review.review}</span>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
