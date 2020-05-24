<%--
  Created by IntelliJ IDEA.
  User: liguangshuai
  Date: 2020/5/25
  Time: 1:21 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<div class="side_nav fl">
    <dl>
        <dt><a href="#">用户信息</a></dt>
        <dd><a href="#">个人信息</a></dd>
        <dd><a href="#">账户安全</a></dd>
    </dl>
    <dl>
        <dt><a href="<%=path%>/order/orderList">订单中心</a></dt>
        <dd><a href="<%=path%>/order/orderList">我的订单</a></dd>
        <dd><a href="#">晒单评论</a></dd>
    </dl>
    <dl>
        <dt><a href="<%=path%>/address/list">收货地址</a></dt>
        <dd><a href="<%=path%>/address/list">我的地址</a></dd>
    </dl>
</div>