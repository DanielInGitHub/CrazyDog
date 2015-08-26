<%--
  Created by IntelliJ IDEA.
  User: never
  Date: 2015/8/26
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>综合业务管理系统</title>
  <link href="style/style.css" rel="stylesheet" type="text/css" />
  <script src="js/jquery-1.3.2.js" type="text/javascript"></script>
  <script type="text/javascript">
    $(function(){
      $(".subNav").click(function(){
        $(this).toggleClass("currentDd").siblings(".subNav").removeClass("currentDd")
        $(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt")

        // 修改数字控制速度， slideUp(500)控制卷起速度
        $(this).next(".navContent").slideToggle(500).siblings(".navContent").slideUp(500);
      })
    })
  </script>
</head>

<body>
<div class="head">
  <div class="logo"><a href="#">综合业务管理系统</a></div>
  <div class="headright">
    <div><a href="#"><span><img src="images/person.png" width="17" height="19" /></span><span>您好！管理员</span></a></div>
    <div><a href="#"><span><img src="images/password.png" width="15" height="21" /></span><span>修改密码</span></a></div>
    <div><a href="#"><span><img src="images/colse.png" width="19" height="20" /></span><span>注销</span></a></div>
  </div>
</div>
<div class="main clearfix">
  <div class="side left">

    <div class="leftlist">
      <!-- 代码 开始 -->
      <div class="subNavBox">
        <div style="padding-bottom:50px;">
          <div class="subs"><a href="#">监管助理人事管理 </a></div>
          <div class="subNav currentDd currentDt">基础数据维护</div>
          <ul class="navContent " style="display:block">
            <li><a href="#">会员管理</a></li>
            <li><a href="#">资质管理</a></li>
          </ul>
          <div class="subNav">社会招聘管理</div>
          <ul class="navContent">
            <li><a href="#">会员管理</a></li>
            <li><a href="#">身份管理</a></li>
          </ul>
          <div class="subNav">人事信息管理</div>
          <ul class="navContent">
            <li><a href="#">人员信息管理</a></li>
            <li><a href="#">离职管理</a></li>
            <li><a href="#">调岗管理</a></li>
            <li><a href="#">离职人员</a></li>
            <li><a href="#">调岗人员</a></li>
          </ul>
          <div class="subNav">合同管理</div>
          <ul class="navContent">
            <li><a href="#">合同续签管理</a></li>
            <li><a href="#">续签合同记录</a></li>
          </ul>
          <div class="subNav">工资管理</div>
          <ul class="navContent">
            <li><a href="#">发布职位</a></li>
            <li><a href="#">已发职位</a></li>
            <li><a href="#">历史信息</a></li>
          </ul>
          <div class="subNav">统计查询</div>
          <ul class="navContent">
            <li><a href="#">花名册</a></li>
          </ul>

          <div class="subs"><a href="#">监管助理物品管理</a></div>
          <div class="subNav">基础数据维护</div>
          <ul class="navContent ">
            <li><a href="#">会员管理</a></li>
            <li><a href="#">资质管理</a></li>
          </ul>
          <div class="subNav">社会招聘管理</div>
          <ul class="navContent">
            <li><a href="#">会员管理</a></li>
            <li><a href="#">身份管理</a></li>
          </ul>
          <div class="subNav">人事信息管理</div>
          <ul class="navContent">
            <li><a href="#">人员信息管理</a></li>
            <li><a href="#">离职管理</a></li>
            <li><a href="#">调岗管理</a></li>
            <li><a href="#">离职人员</a></li>
            <li><a href="#">调岗人员</a></li>
          </ul>
          <div class="subNav">合同管理</div>
          <ul class="navContent">
            <li><a href="#">合同续签管理</a></li>
            <li><a href="#">续签合同记录</a></li>
          </ul>
          <div class="subNav">工资管理</div>
          <ul class="navContent">
            <li><a href="#">发布职位</a></li>
            <li><a href="#">已发职位</a></li>
            <li><a href="#">历史信息</a></li>
          </ul>
          <div class="subNav">统计查询</div>
          <ul class="navContent">
            <li><a href="#">花名册</a></li>
          </ul>
        </div>
      </div>
      <!-- 代码 结束 -->

    </div>
  </div>

  <div class="cont left">
    <div class="content">
      <div class="contentop">
        <div class="welcome">您好：<a href="#">admin</a>，欢迎登综合业务管理系统！</div>
        <div class="time"><span>2015年4月21日</span><span>星期二</span></div>
      </div>
      <div class="ctop"><a href="#">首页</a> &gt; <a href="#">综合业务管理系统</a> &gt; <a href="#">待办申请</a></div>
      <div class="search">
        <table border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><input type="text" name="textfield" id="textfield"  class="s_input"  value="员工编号"  onfocus="javascript:this.style.color='#000000';if(this.value=='员工编号')this.value='';" onblur="javascript:if(this.value==''){this.value='员工编号';this.style.color='#CCCCCC';}" /></td>
            <td><input type="text" name="textfield2" id="textfield2"  class="s_input"  value="姓名"  onfocus="javascript:this.style.color='#000000';if(this.value=='姓名')this.value='';" onblur="javascript:if(this.value==''){this.value='姓名';this.style.color='#CCCCCC';}" /></td>
            <td><input type="text" name="textfield3" id="textfield3"  class="s_input"  value="性别"  onfocus="javascript:this.style.color='#000000';if(this.value=='性别')this.value='';" onblur="javascript:if(this.value==''){this.value='性别';this.style.color='#CCCCCC';}" /></td>
            <td><select name="select" id="select" class="s_inputs" >
              <option>政治面貌</option>
              <option>党员</option>
              <option>团员</option>
            </select></td>
            <td><input type="submit" name="button" id="button" value="查询"  class="s_btn"/></td>
            <td><input type="submit" name="button2" id="button2" value="导出Excel"  class="s_btns"/></td>
          </tr>
        </table>
      </div>

      <div  class="tum">
        <div class="contlist">
          <table border="0" cellspacing="0" cellpadding="0" style="width:100%;">
            <tr  style="color:#000; font-size:14px; padding:10px 0;">
              <td align="center" bgcolor="#fff8f8">员工编号</td>
              <td align="center" bgcolor="#fff8f8">姓名</td>
              <td align="center" bgcolor="#fff8f8">性别</td>
              <td align="center" bgcolor="#fff8f8">政治面貌</td>
              <td align="center" bgcolor="#fff8f8">英语水平</td>
              <td align="center" bgcolor="#fff8f8">技能等级</td>
              <td align="center" bgcolor="#fff8f8">职称</td>
              <td align="center" bgcolor="#fff8f8">手机</td>
              <td align="center" bgcolor="#fff8f8">户口性质</td>
              <td align="center" bgcolor="#fff8f8">户口所在地</td>
              <td align="center" bgcolor="#fff8f8">现居地</td>
              <td align="center" bgcolor="#fff8f8">邮政编码</td>
              <td align="center" bgcolor="#fff8f8">电子邮箱</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">007</td>
              <td align="center" bgcolor="#ffffff">安静</td>
              <td align="center" bgcolor="#ffffff">女</td>
              <td align="center" bgcolor="#ffffff">团员</td>
              <td align="center" bgcolor="#ffffff">4级</td>
              <td align="center" bgcolor="#ffffff">高级</td>
              <td align="center" bgcolor="#ffffff">UI设计</td>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
          </table>

        </div>

      </div>

    </div>
  </div>
</div>
<div class="footer">
  <p>Copyright ©2014 Siansoft. All Rights Reserved.</p>
</div>
</body>
</html>
