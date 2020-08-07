<%--
  Created by IntelliJ IDEA.
  User: DEBOTUSH
  Date: 8/12/2019
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>User List</title>
    <%@include file="bootstrapFiles.jsp" %>
</head>
<body>
<%@include file="navBar.jsp" %>

<h4 class="text-center">Users</h4>

<c:choose>
    <c:when test="${empty allUserList}">
        <div class="alert alert-info table-div text-center">
            Currently, no user is available in this system.
        </div>
    </c:when>
    <c:otherwise>
        <div class="table-responsive table-div">
            <table class="table table-hover">
                <thead class="thead-light">
                <tr>
                    <th>Full Name</th>
                    <th>User Name</th>
                    <th>Mail</th>
                    <th>Contact</th>
                    <th>User Type</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${allUserList}">
                    <tr>
                        <td>${user.fullName}</td>
                        <td>${user.userName}</td>
                        <td>${user.userMail}</td>
                        <td>${user.userContact}</td>
                        <td>${user.userType}</td>
                        <td>
                            <c:url value="/editProfile" var = "profileEditLink">
                                <c:param name="userId" value="${user.userId}"/>
                            </c:url>
                            <c:url value="/user/delete" var = "profileDeleteLink">
                                <c:param name="userId" value="${user.userId}"/>
                            </c:url>
                            <div class="btn-group">
                                <a href="${profileEditLink}" class="btn btn-outline-primary">Update</a>
                                <a href="${profileDeleteLink}" class="btn btn-outline-dark">Delete</a>
                            </div>
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
