<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>综合业务管理系统</title>
    <link href="../style/style.css" rel="stylesheet" type="text/css"/>
    <script src="../js/jquery-1.3.2.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            $(".subNav").click(function () {
                $(this).toggleClass("currentDd").siblings(".subNav").removeClass("currentDd")
                $(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt")
                $(this).next(".navContent").slideToggle(500).siblings(".navContent").slideUp(500);
            })
        })
    </script>
</head>
<body>
<div class="subNavBox">
    <div style="padding-bottom:50px;">
        <div class="subs"><a href="#">监管人事管理系统</a></div>
        <div class="subNav currentDd currentDt">基础数据维护</div>
        <ul class="navContent " style="display:block">
            <li><a href="/unit?page=unitManage" target="contentFrame">单位管理</a></li>
            <%--<li><a href="/fragments/content.jsp" target="contentFrame">资质管理</a></li>--%>
        </ul>
        <div class="subNav">简历</div>
        <ul class="navContent">
            <li><a href="/resumeController?getAllmes" target="contentFrame">显示所有简历</a></li>
            <li><a href="/views?page=resumeManage" target="contentFrame">简历录取</a></li>
            <li><a href="/views?page=resumeManage" target="contentFrame">取消录取</a></li>
        </ul>
        <div class="subNav">人事信息</div>
        <ul class="navContent">
            <li><a href="/employeePage" target="contentFrame">人员信息建档</a></li>
            <li><a href="/employeePage" target="contentFrame">人事信息管理</a></li>
            <li><a href="/fragments/content.jsp" target="contentFrame">离职查看</a></li>
            <li><a href="/fragments/content.jsp" target="contentFrame">调岗查看</a></li>
        </ul>
        <%--<div class="subNav">合同管理</div>--%>
        <%--<ul class="navContent">--%>
            <%--<li><a href="/contract?page=contractChange" target="contentFrame">合同续签管理</a></li>--%>
            <%--<li><a href="/contract?page=changeRecord" target="contentFrame">续签合同记录</a></li>--%>
        <%--</ul>--%>
        <%--<div class="subNav">工资管理</div>--%>
        <%--<ul class="navContent">--%>
            <%--<li><a href="/fragments/content.jsp" target="contentFrame">发布职位</a></li>--%>
            <%--<li><a href="/fragments/content.jsp" target="contentFrame">已发职位</a></li>--%>
            <%--<li><a href="/fragments/content.jsp" target="contentFrame">历史信息</a></li>--%>
        <%--</ul>--%>
        <%--<div class="subNav">统计查询</div>--%>
        <%--<ul class="navContent">--%>
            <%--<li><a href="/fragments/content.jsp" target="contentFrame">花名册</a></li>--%>
        <%--</ul>--%>
    </div>
</div>
</body>
</html>
