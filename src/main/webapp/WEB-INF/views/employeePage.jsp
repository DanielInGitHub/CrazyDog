<%--
  Created by IntelliJ IDEA.
  User: johnny
  Date: 15-8-28
  Time: 下午3:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.crazydog.util.ResourceString" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>人员管理</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="综合业务管理系统">
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="../../style/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="cont left">
    <div class="content">
        <jsp:include page="/WEB-INF/fragments/contentTop.jsp"/>
        <div class="ctop"><a href="#">首页</a> &gt; <a href="#">综合业务管理系统</a> &gt; <a href="#">显示人员信息</a></div>
        <div class="search">
            <table border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td><input type="text" name="textfield" id="textfield" class="s_input" value="人员编号"
                               onfocus="javascript:this.style.color='#000000';if(this.value=='人员编号')this.value='';"
                               onblur="javascript:if(this.value==''){this.value='人员编号';this.style.color='#CCCCCC';}"/>
                    </td>
                    <td><input type="text" name="textfield2" id="textfield2" class="s_input" value="姓名"
                               onfocus="javascript:this.style.color='#000000';if(this.value=='姓名')this.value='';"
                               onblur="javascript:if(this.value==''){this.value='姓名';this.style.color='#CCCCCC';}"/>
                    </td>
                    <td><input type="submit" name="button" id="button" value="查询" class="s_btn"/></td>
                </tr>
            </table>
        </div>

        <div class="tum">
            <div class="contlist">
                <table border="0" cellspacing="0" cellpadding="0" style="width:100%;">
                    <%--显示表头标题--%>
                    <tr style="color:#000; font-size:14px; padding:10px 0;">
                        <c:forEach var="column" items="<%=ResourceString.employeeShow%>">
                            <td align="center" bgcolor="#fff8f8"><c:out value="${column}"/></td>
                        </c:forEach>
                    </tr>

                    <form>
                        <%--显示表内容--%>
                        <c:forEach var="entity" items="${employeesList}">
                            <tr>
                                    <%--员工编号	姓名	性别	身份证号	手机	最高学历	服务单位	服务部门	合同起始日    合同终止日   签约次数--%>
                                <td align="center" bgcolor="#ffffff"><c:out value="${entity.id}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out value="${entity.empName}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out value="${entity.gender}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out value="${entity.idNum}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out value="${entity.tel}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out value="${entity.education}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out
                                        value="${entity.unitEntity.unitName}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out
                                        value="${entity.departmentEntity.deptName}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out
                                        value="${entity.contractEntity.contractStart}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out
                                        value="${entity.contractEntity.contractEnd}"/></td>
                                <td align="center" bgcolor="#ffffff"><a
                                        href="/employeePage?leave&empid=${entity.id}&empname=${entity.empName}">离职操作</a>
                                </td>
                                <td align="center" bgcolor="#ffffff"><a
                                        href="/employeePage?dispatch&empid=${entity.id}">调岗操作</a></td>
                                    <%--empid=${entity.id}&empname=${entity.empName}&unit=${entity.unitEntity.unitName}&dept=${entity.departmentEntity.deptName} --%>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td align="center"><input type="submit" value="上一页" class="s_btn"
                                                      onclick="javascript:this.form.action='/employeePage/${(page - 1) > 1 ? (page - 1) : 1}'">
                            </td>
                            <td align="center"><input type="submit" value="下一页" class="s_btn"
                                                      onclick="javascript:this.form.action='/employeePage/${page + 1}'">
                            </td>
                            <td align="center"><c:out value="当前页：${page}"></c:out></td>
                        </tr>
                    </form>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>