<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http:www.w3.org/TR/1999/PR-xhtml1-19991210/DTD/xhtml-strict.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    <title>${initParam.blogTitle}</title>
</head>
<body>
<div id="container">
    <div id="nav">
        <ul>
            <li>home</li>
            <li>blogs</li>
            <li>message</li>
            <li>about me</li>
        </ul>
    </div>
    <div>
        <div id="slider">slider</div>
        <div id="main">
            <div id="content">
                <ul>
                    <c:forEach var="blog" items="${blogs}">
                        <li class="item" id="${blog.blogId}">
                            <h2>${blog.title}</h2>

                            <div>${blog.brief}</div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div id="pagination"></div>
        </div>
        <div id="tag">tag</div>
    </div>
    <div id="comment">comment</div>
</div>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript">
    $("document").ready(function () {
        alert("here");
        $("li.item").each(function (i, item) {
            this.onclick = showDetail;
        });
    });
    var showDetail = function (e) {
        var blogId = $(this).attr("id");
        var content = $(this).children("div");
        $.ajax({
            type: "POST",
            dataType: "text",
            url: "/blog/getBlogContent",
            data: "blog.blogId=" + blogId,
            success: function (msg) {
                content[0].innerHTML = msg;
            }
        });
    };
</script>
</body>
</html>