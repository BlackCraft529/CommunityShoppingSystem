<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liguangshuai
  Date: 2020/5/7
  Time: 5:48 下午
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
                <a href="<%=path%>/index">应急采购系统</a>
            </h1>
            <div class="top_right">
                <ul class="system_link clearfix">
                    <li><a href="#">会员中心</a></li>
                    <li><a href="#">我的订单</a></li>
                    <li><a href="#">后台管理</a></li>
                    <li><a href="#">使用帮助</a></li>
                </ul>
                <p class="user_info">
                    <!---->
                    <c:if test="${! empty sessionScope.user}">
                        <span class="user_name">${user.nickname}</span>您好！欢迎登录应急采购系统！[<a href="<%=path%>/user/logout">安全退出</a>]
                    </c:if>
                    <c:if test="${empty sessionScope.user}">
                        [<a href="<%=path%>/user/toLogin">登录</a>｜<a href="<%=path%>/user/toRegister" style="color: #3498db;">注册</a>]
                    </c:if>
                </p>
            </div>
        </div>
        <nav class="nav clearfix">
            <ul>
                <li><a class="nav_item" href="<%=path%>/index">首页</a></li>
                <li><a class="nav_item" href="">蔬菜</a></li>
                <li><a class="nav_item" href="">家禽</a></li>
                <li><a class="nav_item" href="">蛋类</a></li>
                <li><a class="nav_item" href="">水果</a></li>
                <li><a class="nav_item" href="">洗化用品</a></li>
                <li><a class="nav_item" href="">调味料</a></li>
                <li><a class="nav_item" href="">图书</a></li>
                <li><a class="nav_item" href="<%=path%>/goods/goodsListCate?cateId=4aa9838573f44772849f888b7b994095">小型家电</a></li>
            </ul>
        </nav>
        <div class="header_bottom clearfix">
            <div class="category">
                <h3 class="cate_title" id="cate_title">全部商品分类</h3>
                <div class="dropdown">
                    <li><a class="cate_item" href="<%=path%>/index">首页</a></li>
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
                <form action="<%=path%>/goods/goodsListName" class="search_form">
                    <input placeholder="请输入关键字..." name="goodsName" type="text">
                    <button type="submit">搜索</button>
                </form>
            </div>
        </div>
    </div>
</header>
