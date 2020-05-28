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
                    <c:forEach items="${newsList}" var="goods">
                        <div class="goods">
                            <a target="_blank" href="<%=path%>/goods/goodsDetail?goodsId=${goods.goodsId}"><img alt="" class="goods_img"
                                             src="${goods.goodsImage}"></a>
                            <p class="goods_name">${goods.goodsName}</p>
                            <p class="new_price">优惠价：<span>￥${goods.goodsSalesPrice}</span></p>
                            <p class="old_price">市场价：
                                <del>￥${goods.goodsPrice}</del>
                            </p>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="side_bar">
            <h3 class="hot_goods_title">最热商品</h3>
            <div class="hot_goods_box">
                <c:forEach items="${hotsList}" var="goods">
                    <div class="hot_goods">
                        <a target="_blank" href="<%=path%>/goods/goodsDetail?goodsId=${goods.goodsId}"><img alt="mi4" class="goods_img"
                                         src="${goods.goodsImage}"></a>
                        <p class="goods_name">${goods.goodsName}</p>
                        <p class="new_price">￥${goods.goodsSalesPrice}</p>
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
