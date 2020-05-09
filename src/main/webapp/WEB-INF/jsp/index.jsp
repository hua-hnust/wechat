<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="inc/pageHeader.jsp"/>
    <title> 管理台 </title>
</head>
<body>
<div>
    <jsp:include page="inc/top.jsp"/>
    <div id="wrapper">
        <jsp:include page="inc/pageNav.jsp"/>
        <div id="page-wrapper">
            <div class="page-title-breadcrumb">
                <div class="page-header">
                    <div class="page-title">控制台</div>
                </div>
            </div>
            <div class="page-content">
                <div id="tab-general">
                    <!-- TODO 此处填写内容 -->
                </div>
            </div>
            <jsp:include page="inc/pageBottom.jsp"/>
        </div>
    </div>
</div>
</body>
<script>
    $(function(){
        selectNav("console");
    });
</script>
</html>
