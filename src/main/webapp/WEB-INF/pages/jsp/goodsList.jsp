<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liguangshuai
  Date: 2020/5/6
  Time: 9:35 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品列表</title>
    <link href="<%=path%>/css/base.css" rel="stylesheet">
    <link href="<%=path%>/css/common.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=path%>/css/goodsList.css">
</head>
<body>
<!--Header Start-->
<jsp:include page="header.jsp"/>
<!--Header End-->

<!--Main Start-->
<div class="main">
    <div class="w clearfix">
        <c:forEach items="${goods}" var="item" step="1">
            <div class="goods-item">
                <a href="<%=path%>/goods/goodsDetail?goodsId=${item.goodsId}">
                    <img src="${item.goodsImage}" alt="">
                    <h5>${item.goodsName}</h5>
                    <p class="price"><i class="new-price">¥${item.goodsSalesPrice}</i>&nbsp;<del>￥${item.goodsPrice}</del></p>
                    <div class="buy-btn">
                        查看详情
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>
</div>
<!--Main End-->

<!--Footer Start-->
<footer class="footer">
    <p class="links">
        <a href="#">关于我们</a><a href="#">常见问题</a><a href="">安全交易</a><a href="">购买流程</a><a href="">如何付款</a><a
            href="">联系我们</a><a
            href="">商务合作</a>
    </p>
    <p class="copyright">Copyright © 2020-2022 应急采购系统 <a class="beian" href="" target="_blank">京ICP备1234567890号</a></p>
</footer>
<!--Footer End-->

<script src="<%=path%>/js/jquery-3.5.0.min.js"></script>
<script src="<%=path%>/js/common.js"></script>
</body>
</html>
