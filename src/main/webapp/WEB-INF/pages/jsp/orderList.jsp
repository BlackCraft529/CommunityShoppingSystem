<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liguangshuai
  Date: 2020/5/23
  Time: 4:50 下午
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
    <title>社区采购系统-用户中心</title>
    <link href="<%=path%>/css/base.css" rel="stylesheet">
    <link href="<%=path%>/css/common.css" rel="stylesheet">
    <link href="<%=path%>/css/orderList.css" rel="stylesheet">
</head>
<body>
<jsp:include page="userCenterHeader.jsp"/>
<div class="main">
    <div class="w clearfix">
        <jsp:include page="sideNav.jsp"/>
        <div class="content fl">
            <div class="head">
                我的订单
            </div>
            <div class="content-order">
                <div class="tool_bar">
                    <div class="hd">
                        <ul class="clearfix">
                            <li class="order_type">
                                <a
                                        <c:if test="${type eq 0}">class="current"</c:if>
                                        href="<%=path%>/order/orderList">全部订单</a>
                                <a
                                        <c:if test="${type eq 1}">class="current"</c:if>
                                        href="<%=path%>/order/orderList?status=1">待付款</a>
                                <a
                                        <c:if test="${type eq 2}">class="current"</c:if>
                                        href="<%=path%>/order/orderList?status=2">待收货</a>
                                <a
                                        <c:if test="${type eq 4}">class="current"</c:if>
                                        href="<%=path%>/order/orderList?status=3">待评价</a>
                                <a
                                        <c:if test="${type eq 5}">class="current"</c:if>
                                        href="<%=path%>/order/orderList?status=4">已完成</a>
                                <a
                                        <c:if test="${type eq 6}">class="current"</c:if>
                                        href="<%=path%>/order/orderList?status=4">已取消</a>
                            </li>
                            <li class="order_search">
                                <form action="<%=path%>/order/orderList">
                                    <input id="search_text" name="search_text" placeholder="请输入订单号、商品名、商品编号"
                                           type="text">
                                    <button type="submit" style="font-family: iconfont">&#xe613;</button>
                                </form>
                            </li>
                        </ul>
                    </div>
                    <div class="bd">
                        <ul class="order_title clearfix">
                            <li class="order_detail">订单详情</li>
                            <li class="order_address">收货人</li>
                            <li class="order_money">金额</li>
                            <li class="order_status">订单状态</li>
                            <li class="order_operation">操作</li>
                        </ul>
                    </div>
                </div>
                <div class="order_list">
                    <c:if test="${empty orderList}">
                        <div class="none_list">
                            <p style="text-align: center;">暂无订单</p>
                        </div>
                    </c:if>
                    <c:if test="${! empty orderList}">
                        <c:forEach items="${orderList}" var="order">
                            <div class="order_item clearfix">
                                <div class="hd">
                                    <ul>
                                        <li class="create_time">${order.createTime}</li>
                                        <li>订单号:<a href="#">${order.orderId}</a></li>
                                    </ul>
                                </div>
                                <div class="bd clearfix">
                                    <div class="item order_detail">
                                        <c:forEach items="${order.goodsList}" var="goods">
                                            <div class="goods_item clearfix">
                                                <div class="g_img">
                                                    <a href="<%=path%>/goods/goodsDetail?goodsId=${goods.goodsId}">
                                                        <img alt="" src="${goods.goodsImage}">
                                                    </a>
                                                </div>
                                                <div class="g_name">
                                                    <a href="<%=path%>/goods/goodsDetail?goodsId=${goods.goodsId}">${goods.goodsName}</a>
                                                </div>
                                                <span class="g_num">x${goods.quantity}</span>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="item order_address">${order.address.contact}</div>
                                    <div class="item order_money">
                                        <p class="money">¥${order.paymentAmount}</p>
                                        <p class="pay_type">在线支付</p>
                                    </div>
                                    <div class="item order_status">
                                        <c:if test="${order.status eq 1}">
                                            <p class="status">未付款</p>
                                        </c:if>
                                        <c:if test="${order.status eq 2}">
                                            <p class="status">未发货</p>
                                        </c:if>
                                        <c:if test="${order.status eq 3}">
                                            <p class="status">已发货</p>
                                        </c:if>
                                        <c:if test="${order.status eq 4}">
                                            <p class="status">未评价</p>
                                        </c:if>
                                        <c:if test="${order.status eq 5}">
                                            <p class="status">订单完成</p>
                                        </c:if>
                                        <c:if test="${order.status eq 6}">
                                            <p class="status">订单取消</p>
                                        </c:if>
                                        <a href="#" class="order_detail_link">订单详情</a>
                                    </div>
                                    <div class="item order_operation">
                                        <a href="#">查看发票</a><a href="#">评价</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
        </div>

    </div>
</div>
</div>
<footer class="footer">
    <div class="w">
        <p class="copyright">Copyright © 2020-2022 应急采购系统 <a class="beian" href="" target="_blank">京ICP备1234567890号</a>
        </p>
    </div>
</footer>
</body>
</html>
