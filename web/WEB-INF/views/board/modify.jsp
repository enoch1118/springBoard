<%--
  Created by IntelliJ IDEA.
  User: emma
  Date: 2021/02/12
  Time: 6:48 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Get Page</title>
</head>
<body>
<%@include file="../includes/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Register</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">Board Read Page</div>
            <div class="panel-body">
                <form role="form" action="/board/modify" method="post">
                    <div class="form-group">
                        <label>Bno</label>
                        <input class="form-control" name="bno" value='<c:out value="${board.bno}"/>'
                               readonly="readonly"/>
                    </div>
                    <div class="form-group">
                        <label>Title</label>
                        <input class="form-control" name="title" value='<c:out value="${board.title}"/>'
                        />
                    </div>
                    <div class="form-group">
                        <label>Text Area</label>
                        <textarea class="form-control" rows="3" name="content"
                        ><c:out value="${board.content}"/></textarea>
                    </div>
                    <div class="form-group">
                        <label>Writer</label>
                        <input class="form-control" name="writer" value='<c:out value="${board.writer}"/>'
                               readonly="readonly"/>
                    </div>
                    <button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
                    <button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
                    <button data-oper='list' class="btn btn-info" onclick="location.href='/board/list'">List</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(() => {
        const formObj = $('form');
        $('button').on("click", function (e) {
            e.preventDefault();
            let operation = $(this).data("oper");
            console.log(operation);
            if (operation === 'remove') {
                console.log('remove');
                formObj.attr("action", "/board/remove")
            } else if (operation === 'list') {
                // self.location = "/board/list";
                formObj.attr("action", "/board/list").attr("method", "get");
                formObj.empty();
            }
            formObj.submit();
        });
    });
</script>
<%@include file="../includes/footer.jsp" %>
</body>
</html>
