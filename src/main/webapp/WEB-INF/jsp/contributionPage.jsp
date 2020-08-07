<%--
  Created by IntelliJ IDEA.
  User: DEBOTUSH
  Date: 8/23/2019
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>User's Contribution</title>
    <%@include file="bootstrapFiles.jsp" %>
</head>
<body>
<%@include file="navBar.jsp" %>


<c:choose>
    <c:when test="${empty topContributor}">
        <div class="alert alert-info table-div text-center">
            Currently, There is no contribution in this System.
        </div>
    </c:when>
    <c:otherwise>
        <div class="table-responsive table-div">
            <table class="table table-hover">
                <thead class="thead-light">
                <tr>
                    <th>Full Name</th>
                    <th>Username</th>
                    <th>No. of book uploads</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="top" items="${topContributor}">
                    <tr>
                        <td>${top.user.fullName}</td>
                        <td>${top.user.userName}</td>
                        <td>${top.bookCount}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="btn-group">
                <a href="#" class="btn btn-outline-success" onclick="downloadPdf()">PDF</a>
            </div>
        </div>

    </c:otherwise>
</c:choose>


<script>
    function downloadPdf() {
        var pdf = new jsPDF('p', 'pt', 'letter'),
            source = $('.table-div')[0],
            specialElementHandlers = {
                '#bypassme': function (element, renderer) {
                    return true
                }
            },
            margins = {
                top: 80,
                bottom: 60,
                left: 40,
                width: 522
            };

        pdf.fromHTML(
            source,
            margins.left,
            margins.top, {
                'width': margins.width,
                'elementHandlers': specialElementHandlers
            },

            function (dispose) {
                pdf.save('TopContributors.pdf');
            }, margins
        );
    }
</script>

</body>
</html>
