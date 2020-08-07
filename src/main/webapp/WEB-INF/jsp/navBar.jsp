<%--
  Created by IntelliJ IDEA.
  User: Debotush
  Date: 8/16/2019
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-sm bg-light">
    <img src="/img/logo-t.png" width="150px" height="50px"/>

    <ul class="navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link" href="/profile">Profile</a>
        </li>

        <c:choose>
            <c:when test="${sessionScope.currentUser.admin}">
                <li class="nav-item">
                    <a class="nav-link" href="/book/bookList">Books Feed</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/user/userList">Users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/report/page">Reports</a>
                </li>
            </c:when>
            <c:otherwise>
                <c:url var="bookListExcludingOwnerUrl" value="/book/bookList">
                    <c:param name="userId" value="${sessionScope.currentUser.userId}"/>
                    <c:param name="excludeOwner" value="true"/>
                </c:url>

                <li class="nav-item">
                    <a class="nav-link" href="${bookListExcludingOwnerUrl}">Books Feed</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/book/upload">Upload</a>
                </li>

                <c:url var="bookListUrl" value="/book/bookList">
                    <c:param name="userId" value="${sessionScope.currentUser.userId}"/>
                    <c:param name="excludeOwner" value="false"/>
                </c:url>
                <li class="nav-item">
                    <a class="nav-link" href="${bookListUrl}">My Book Collection</a>
                </li>
            </c:otherwise>
        </c:choose>

        <li class="nav-item notification-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">
                Notification<span class="badge badge-primary badge-pill"></span></a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="/logout">Logout</a>
        </li>
    </ul>

    <div class="form-inline search-div dropdown">
        <input type="search" name="param" class="form-control mr-sm-2" placeholder="Search">
        <button class="search-button btn btn-outline-success" type="button" data-toggle="dropdown">Search</button>
        <div class="dropdown-menu search-menu w-100">
        </div>
    </div>
</nav>

<script>
    $(function () {
        $(document)
            .on('click', '.search-button', function () {
                var param = $('input[name="param"]').val();
                $('.search-menu').empty();

                if (param) {
                    $.get('/search', {param: param}, function (bookList) {
                        bookList.forEach(function (book, index) {
                            $('.search-menu').append($('<a/>', {
                                'class': 'dropdown-item search-item',
                                href: '/review?bookId=' + book.bookId
                            }).text(book.bookName));


                            if (index < bookList.length - 1) {
                                $('.search-menu').append($('<div/>', {class: 'dropdown-divider'}));
                            }
                        });
                    });
                }
            })
            .on('click', '.notification-item', function () {
                $.post('/acknowledge', {'notificationId': $(this).data('notificationId')});
            });

        $('.notification-item').append($('<div/>', {class: 'dropdown-menu notification-menu'}));
        checkNotification();

        window.setInterval(function () {
            checkNotification();
        }, 3000);
    });

    function checkNotification() {
        $.get("/notifications", function (notificationList) {
            $('.badge').text(notificationList.length || '');

            $('.notification-menu').empty();

            notificationList.forEach(function (notification) {
                var url = notification.type === 'Request' ? '/book/detail?bookId=' + notification.bookId : '/profile';

                $('.notification-menu').append($('<a/>', {
                    class: 'dropdown-item notification-item',
                    href: url,
                    'data-notification-id': notification.notificationId
                }).text(notification.message));
            })
        });
    }
</script>
