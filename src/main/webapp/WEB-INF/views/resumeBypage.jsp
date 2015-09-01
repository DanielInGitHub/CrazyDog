<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.crazydog.util.ResourceString" %>
<%@ page import="org.crazydog.util.HtmlResources" %>
<html>

<head>
  <title>服务单位管理</title>
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
    <div class="ctop"><a href="#">首页</a> &gt; <a href="#">社会招聘管理</a> &gt; <a href="#">简历管理</a>
    </div>
    <form id="formresume" method="post">
      <div class="search">
        <table border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>姓名：</td>
            <td><input type="text" name="username"  class="s_inputs"/></td>
            <td>学历：</td>
            <td><select name="highestEdu" id="select" class="s_inputs" >
              <c:forEach var="column" items="<%=HtmlResources.Edu%>">
                <option value="${column}">${column}</option>
              </c:forEach>
            </select></td>
            <td>录取状态：</td>
            <td><select name="luquState" id="select2" class="s_inputs" >
              <c:forEach var="column" items="<%=HtmlResources.state%>">
                <option value="${column}">${column}</option>
              </c:forEach>
            </select></td>
            <td><input type="submit"  name="submit" id="button" value="查询"  class="s_btn"  onclick="javascript:this.form.action='/resume?action=modelSearch'"/></td>
            <td><input type="button" name="submit" id="button2" value="导出Excel"  class="s_btns" /></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td><input type="submit"  name="submit" id="button3" value="批量删除"  class="s_btns" onclick="javascript:this.form.action='/resume?action=batchdelete'"/></td>
          </tr>

        </table>
      </div>

      <div  class="tum">
        <div class="contlist">
          <table border="0" cellspacing="0" cellpadding="0" style="width:100%;">
            <%--显示表头标题--%>
            <tr style="color:#000; font-size:14px; padding:10px 0;">
              <c:forEach var="column" items="<%=ResourceString.resumeShow%>">
                <td align="center" bgcolor="#fff8f8"><c:out value="${column}"/></td>
              </c:forEach>
            </tr>
            <%--显示表内容--%>
            <c:forEach var="column" items="${resume}">
              <tr style="color:#000; font-size:14px; padding:10px 0;">
                <td align="center" bgcolor="#fff8f8"><input name="selectid" type="checkbox" value="${column.id}" /></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.name}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.gender}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.nation}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.gender}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.birthday}"/></td><td align="center" bgcolor="#fff8f8"><c:out value="${column.hyzk}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.zzmm}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.hukouAddress}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.tel}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.hireById.state}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.email}"/></td>
                <td align="center" bgcolor="#fff8f8"><a href='/resume?action=getAresume&&resumeid=${column.id}'/>查看详细简历信息</td>
              </tr>
            </c:forEach>
              <tr>
                <td align="center" bgcolor="#fff8f8"><a href='/resume/${(page - 1) > 1 ? (page - 1) : 1}'/>上一页</td>
                <td align="center" bgcolor="#fff8f8"><a href='/resume/${page + 1}'/>下一页</td>
                <td align="center"><c:out value="当前页：${page}"></c:out></td>
              </tr>
          </table>
        </div>
      </div>
    </form>
  </div>
</div>
</div>
</body>
</html>
