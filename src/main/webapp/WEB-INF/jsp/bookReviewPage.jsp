<%--
  Created by IntelliJ IDEA.
  User: DEBOTUSH
  Date: 8/22/2019
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Review</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <%@include file="bootstrapFiles.jsp" %>
</head>
<body>
<%@include file="navBar.jsp" %>
<h2 class="text-center">${book.bookName}</h2>

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

<h2 class="text-center">Review</h2>
<%--@elvariable id="review" type=""--%>
<form:form modelAttribute="review" method="post" enctype="multipart/form-data">
    <div class="card book-detail-page book-detail-card">
        <div class="card-body">
            <div class="row">
                <div class="col-sm-2 form-group">
                    <label>Rating</label>
                </div>
                <div class="col-sm-10 form-group">
                    <form:select path="rating" items="${ratingOptionMap}" cssClass="form-control"/>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-2 form-group">
                    <label>Review</label>
                </div>
                <div class="col-sm-10 form-group">
                    <form:textarea path="review" type="text" cssClass="form-control" placeholder="Write a review. . ." rows="6"/>
                </div>
            </div>

            <input type="hidden" name="reviewedById" value="${sessionScope.currentUser.userId}"/>
            <input type="hidden" name="bookId" value="${book.bookId}"/>
        </div>
    </div>


    <div class="book-detail-page text-right" style="margin-top: 20px;">
        <input type="submit" name="button" class="btn btn-lg btn-primary" value="Submit"/>
    </div>
</form:form>


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
        <div class = "well">
            <c:out value="${review.review}"/>
        </div>
    </c:forEach>
</div>

</body>
</html>
