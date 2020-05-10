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
    <link href="css/base.css" rel="stylesheet">
    <link href="css/common.css" rel="stylesheet">
    <link rel="stylesheet" href="css/goodsList.css">
</head>
<body>
<!--Header Start-->
<header class="header">
    <div class="w">
        <div class="header_top clearfix">
            <h1 class="logo">
                <a href="/">应急采购系统</a>
            </h1>
            <div class="top_right">
                <ul class="system_link clearfix">
                    <li><a href="#">会员中心</a></li>
                    <li><a href="#">我的订单</a></li>
                    <li><a href="#">后台管理</a></li>
                    <li><a href="#">使用帮助</a></li>
                </ul>
                <p class="user_info">
                    <!--<span class="user_name">Double</span>您好！欢迎登录应急采购系统！[<a href="">安全退出</a>]-->
                    [<a href="#">登录</a>｜<a href="#" style="color: #3498db;">注册</a>]
                </p>
            </div>
        </div>
        <nav class="nav clearfix">
            <ul>
                <li><a class="nav_item" href="">首页</a></li>
                <li><a class="nav_item" href="">蔬菜</a></li>
                <li><a class="nav_item" href="">家禽</a></li>
                <li><a class="nav_item" href="">蛋类</a></li>
                <li><a class="nav_item" href="">水果</a></li>
                <li><a class="nav_item" href="">洗化用品</a></li>
                <li><a class="nav_item" href="">调味料</a></li>
                <li><a class="nav_item" href="">图书</a></li>
                <li><a class="nav_item" href="">小型家电</a></li>
            </ul>
        </nav>
        <div class="header_bottom clearfix">
            <div class="category">
                <h3 class="cate_title" id="cate_title">全部商品分类</h3>
                <div class="dropdown">
                    <li><a class="cate_item" href="">首页</a></li>
                    <li><a class="cate_item" href="">蔬菜</a></li>
                    <li><a class="cate_item" href="">家禽</a></li>
                    <li><a class="cate_item" href="">蛋类</a></li>
                    <li><a class="cate_item" href="">水果</a></li>
                    <li><a class="cate_item" href="">洗化用品</a></li>
                    <li><a class="cate_item" href="">调味料</a></li>
                    <li><a class="cate_item" href="">图书</a></li>
                    <li><a class="cate_item" href="">小型家电</a></li>
                </div>
            </div>
            <div class="search">
                <form action="" class="search_form">
                    <input placeholder="请输入关键字..." type="text">
                    <button type="submit">搜索</button>
                </form>
            </div>
        </div>
    </div>
</header>
<!--Header End-->

<!--Main Start-->
<div class="main">
    <div class="w clearfix">
        <c:forEach items="goods" var="item" step="1">
            <div class="goods-item">
                <a href="<%=path%>/goods/goodsDetail?goodsId=${item.goodsId}">
                    <img src="${item.goodsImage}" alt="">
                    <h5>${item.goodsName}</h5>
                    <p class="price"><i class="new-price">¥${goodsSalesPrice}</i>&nbsp;<del>￥${goodsPrice}</del></p>
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

<script src="js/jquery-3.5.0.min.js"></script>
<script src="js/common.js"></script>
</body>
</html>
