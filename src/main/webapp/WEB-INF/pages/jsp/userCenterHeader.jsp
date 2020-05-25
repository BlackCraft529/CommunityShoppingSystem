<%--
  Created by IntelliJ IDEA.
  User: liguangshuai
  Date: 2020/5/25
  Time: 12:56 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<header class="header">
    <div class="w">
        <div class="header_top clearfix">
            <h1 class="logo">
                <a class="prim_logo" href="<%=path%>/index">应急采购系统</a>
            </h1>
            <a class="sub_logo" href="<%=path%>/user/info">用户中心</a>
            <div class="top_right">
                <ul class="system_link clearfix">
                    <li><a href="<%=path%>/user/info">会员中心</a></li>
                    <li><a href="<%=path%>/order/orderList">我的订单</a></li>
                    <li><a href="#">后台管理</a></li>
                    <li><a href="#">使用帮助</a></li>
                </ul>
                <p class="user_info">
                    <span class="user_name">${sessionScope.user.nickname}</span>您好！欢迎登录应急采购系统！[<a href="<%=path%>/user/logout">安全退出</a>]
                </p>
            </div>
        </div>
    </div>
</header>