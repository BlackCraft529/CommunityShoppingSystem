<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liguangshuai
  Date: 2020/5/6
  Time: 12:00 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <link href="<%=path%>/css/base.css" rel="stylesheet">
    <link href="<%=path%>/css/common.css" rel="stylesheet">
    <link href="<%=path%>/css/index.css" rel="stylesheet">
    <title>商城</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="main clearfix">
    <div class="w">
        <div class="goods_view">
            <div class="new_goods_box clearfix">
                <h3 class="new_goods_title">最新商品</h3>
                <div class="new_goods">
                    <c:forEach items="{1,2,3,4,5,6,7,8}" step="1">
                        <div class="goods">
                            <a href="#"><img alt="" class="goods_img"
                                             src="<%=path%>/upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                            <p class="goods_name">小米4 2GB内存版 白色 移动4G</p>
                            <p class="new_price">优惠价：<span>￥1299.0</span></p>
                            <p class="old_price">市场价：
                                <del>￥1300.0</del>
                            </p>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="side_bar">
            <h3 class="hot_goods_title">最热商品</h3>
            <div class="hot_goods_box">
                <c:forEach items="{1,2,3,4,5,6,7,8}" step="1">
                    <div class="hot_goods">
                        <a href="#"><img alt="mi4" class="goods_img"
                                         src="<%=path%>/upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                        <p class="goods_name">小米4 2GB内存</p>
                        <p class="new_price">￥1299.0</p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>

<script src="<%=path%>/js/jquery-3.5.0.min.js"></script>
<script src="<%=path%>/js/common.js"></script>
</body>
</html>
