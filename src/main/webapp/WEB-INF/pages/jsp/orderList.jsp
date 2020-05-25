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
                                <a class="current" href="<%=path%>/order/orderList">全部订单</a><a href="#">代付款</a><a href="#">待收货</a><a href="#">待评价</a>
                            </li>
                            <li class="order_search">
                                <form action="">
                                    <input id="search_text" name="search_text" placeholder="请输入订单号、商品名、商品编号"
                                           type="text">
                                    <button type="submit"></button>
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
                                        <li class="create_time">2020-05-20 12:43:22</li>
                                        <li>订单号:<a href="#">115715933302</a></li>
                                    </ul>
                                </div>
                                <div class="bd clearfix">
                                    <div class="item order_detail">
                                        <div class="goods_item clearfix">
                                            <div class="g_img">
                                                <a href="#">
                                                    <img alt="" src="upload/9ecf0b5491ed4aa69c41de609d2ded30.jpg">
                                                </a>
                                            </div>
                                            <div class="g_name">
                                                <a>TP-LINK双千兆路由器 1900M无线家用5G双频 WDR7660千兆 六信号放大器 高速路由TP-LINK双千兆路由器 1900M无线家用5G双频
                                                    WDR7660千兆 六信号放大器 高速路由</a>
                                            </div>
                                            <span class="g_num">x1</span>
                                        </div>
                                        <div class="goods_item clearfix">
                                            <div class="g_img">
                                                <a href="#">
                                                    <img alt="" src="upload/9ecf0b5491ed4aa69c41de609d2ded30.jpg">
                                                </a>
                                            </div>
                                            <div class="g_name">
                                                <a>TP-LINK双千兆路由器 1900M无线家用5G双频 WDR7660千兆 六信号放大器 高速路由TP-LINK双千兆路由器 1900M无线家用5G双频
                                                    WDR7660千兆 六信号放大器 高速路由</a>
                                            </div>
                                            <span class="g_num">x1</span>
                                        </div>
                                        <div class="goods_item clearfix">
                                            <div class="g_img">
                                                <a href="#">
                                                    <img alt="" src="upload/9ecf0b5491ed4aa69c41de609d2ded30.jpg">
                                                </a>
                                            </div>
                                            <div class="g_name">
                                                <a>TP-LINK双千兆路由器 1900M无线家用5G双频 WDR7660千兆 六信号放大器 高速路由TP-LINK双千兆路由器 1900M无线家用5G双频
                                                    WDR7660千兆 六信号放大器 高速路由</a>
                                            </div>
                                            <span class="g_num">x1</span>
                                        </div>
                                    </div>
                                    <div class="item order_address">李广帅</div>
                                    <div class="item order_money">
                                        <p class="money">¥74.03</p>
                                        <p class="pay_type">在线支付</p>
                                    </div>
                                    <div class="item order_status">
                                        <p class="status">已完成</p>
                                        <a href="#" class="order_detail_link">订单详情</a>
                                    </div>
                                    <div class="item order_operation">
                                        <a href="#">查看发票</a><a href="#">评价</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="order_item clearfix">
                            <div class="hd">
                                <ul>
                                    <li class="create_time">2020-05-20 12:43:22</li>
                                    <li>订单号:<a href="#">115715933302</a></li>
                                </ul>
                            </div>
                            <div class="bd clearfix">
                                <div class="item order_detail">
                                    <div class="goods_item clearfix">
                                        <div class="g_img">
                                            <a href="#">
                                                <img alt="" src="upload/9ecf0b5491ed4aa69c41de609d2ded30.jpg">
                                            </a>
                                        </div>
                                        <div class="g_name">
                                            <a>TP-LINK双千兆路由器 1900M无线家用5G双频 WDR7660千兆 六信号放大器 高速路由TP-LINK双千兆路由器 1900M无线家用5G双频
                                                WDR7660千兆 六信号放大器 高速路由</a>
                                        </div>
                                        <span class="g_num">x1</span>
                                    </div>
                                    <div class="goods_item clearfix">
                                        <div class="g_img">
                                            <a href="#">
                                                <img alt="" src="upload/9ecf0b5491ed4aa69c41de609d2ded30.jpg">
                                            </a>
                                        </div>
                                        <div class="g_name">
                                            <a>TP-LINK双千兆路由器 1900M无线家用5G双频 WDR7660千兆 六信号放大器 高速路由TP-LINK双千兆路由器 1900M无线家用5G双频
                                                WDR7660千兆 六信号放大器 高速路由</a>
                                        </div>
                                        <span class="g_num">x1</span>
                                    </div>
                                    <div class="goods_item clearfix">
                                        <div class="g_img">
                                            <a href="#">
                                                <img alt="" src="upload/9ecf0b5491ed4aa69c41de609d2ded30.jpg">
                                            </a>
                                        </div>
                                        <div class="g_name">
                                            <a>TP-LINK双千兆路由器 1900M无线家用5G双频 WDR7660千兆 六信号放大器 高速路由TP-LINK双千兆路由器 1900M无线家用5G双频
                                                WDR7660千兆 六信号放大器 高速路由</a>
                                        </div>
                                        <span class="g_num">x1</span>
                                    </div>
                                </div>
                                <div class="item order_address">李广帅</div>
                                <div class="item order_money">
                                    <p class="money">¥74.03</p>
                                    <p class="pay_type">在线支付</p>
                                </div>
                                <div class="item order_status">
                                    <p class="status">已完成</p>
                                    <a href="#" class="order_detail_link">订单详情</a>
                                </div>
                                <div class="item order_operation">
                                    <a href="#">查看发票</a><a href="#">评价</a>
                                </div>
                            </div>
                        </div>
                        <div class="order_item clearfix">
                            <div class="hd">
                                <ul>
                                    <li class="create_time">2020-05-20 12:43:22</li>
                                    <li>订单号:<a href="#">115715933302</a></li>
                                </ul>
                            </div>
                            <div class="bd clearfix">
                                <div class="item order_detail">
                                    <div class="goods_item clearfix">
                                        <div class="g_img">
                                            <a href="#">
                                                <img alt="" src="upload/9ecf0b5491ed4aa69c41de609d2ded30.jpg">
                                            </a>
                                        </div>
                                        <div class="g_name">
                                            <a>TP-LINK双千兆路由器 1900M无线家用5G双频 WDR7660千兆 六信号放大器 高速路由TP-LINK双千兆路由器 1900M无线家用5G双频
                                                WDR7660千兆 六信号放大器 高速路由</a>
                                        </div>
                                        <span class="g_num">x1</span>
                                    </div>
                                    <div class="goods_item clearfix">
                                        <div class="g_img">
                                            <a href="#">
                                                <img alt="" src="upload/9ecf0b5491ed4aa69c41de609d2ded30.jpg">
                                            </a>
                                        </div>
                                        <div class="g_name">
                                            <a>TP-LINK双千兆路由器 1900M无线家用5G双频 WDR7660千兆 六信号放大器 高速路由TP-LINK双千兆路由器 1900M无线家用5G双频
                                                WDR7660千兆 六信号放大器 高速路由</a>
                                        </div>
                                        <span class="g_num">x1</span>
                                    </div>
                                    <div class="goods_item clearfix">
                                        <div class="g_img">
                                            <a href="#">
                                                <img alt="" src="upload/9ecf0b5491ed4aa69c41de609d2ded30.jpg">
                                            </a>
                                        </div>
                                        <div class="g_name">
                                            <a>TP-LINK双千兆路由器 1900M无线家用5G双频 WDR7660千兆 六信号放大器 高速路由TP-LINK双千兆路由器 1900M无线家用5G双频
                                                WDR7660千兆 六信号放大器 高速路由</a>
                                        </div>
                                        <span class="g_num">x1</span>
                                    </div>
                                </div>
                                <div class="item order_address">李广帅</div>
                                <div class="item order_money">
                                    <p class="money">¥74.03</p>
                                    <p class="pay_type">在线支付</p>
                                </div>
                                <div class="item order_status">
                                    <p class="status">已完成</p>
                                    <a href="#" class="order_detail_link">订单详情</a>
                                </div>
                                <div class="item order_operation">
                                    <a href="#">查看发票</a><a href="#">评价</a>
                                </div>
                            </div>
                        </div>
                        <div class="order_item clearfix">
                            <div class="hd">
                                <ul>
                                    <li class="create_time">2020-05-20 12:43:22</li>
                                    <li>订单号:<a href="#">115715933302</a></li>
                                </ul>
                            </div>
                            <div class="bd clearfix">
                                <div class="item order_detail">
                                    <div class="goods_item clearfix">
                                        <div class="g_img">
                                            <a href="#">
                                                <img alt="" src="upload/9ecf0b5491ed4aa69c41de609d2ded30.jpg">
                                            </a>
                                        </div>
                                        <div class="g_name">
                                            <a>TP-LINK双千兆路由器 1900M无线家用5G双频 WDR7660千兆 六信号放大器 高速路由TP-LINK双千兆路由器 1900M无线家用5G双频
                                                WDR7660千兆 六信号放大器 高速路由</a>
                                        </div>
                                        <span class="g_num">x1</span>
                                    </div>
                                    <div class="goods_item clearfix">
                                        <div class="g_img">
                                            <a href="#">
                                                <img alt="" src="upload/9ecf0b5491ed4aa69c41de609d2ded30.jpg">
                                            </a>
                                        </div>
                                        <div class="g_name">
                                            <a>TP-LINK双千兆路由器 1900M无线家用5G双频 WDR7660千兆 六信号放大器 高速路由TP-LINK双千兆路由器 1900M无线家用5G双频
                                                WDR7660千兆 六信号放大器 高速路由</a>
                                        </div>
                                        <span class="g_num">x1</span>
                                    </div>
                                    <div class="goods_item clearfix">
                                        <div class="g_img">
                                            <a href="#">
                                                <img alt="" src="upload/9ecf0b5491ed4aa69c41de609d2ded30.jpg">
                                            </a>
                                        </div>
                                        <div class="g_name">
                                            <a>TP-LINK双千兆路由器 1900M无线家用5G双频 WDR7660千兆 六信号放大器 高速路由TP-LINK双千兆路由器 1900M无线家用5G双频
                                                WDR7660千兆 六信号放大器 高速路由</a>
                                        </div>
                                        <span class="g_num">x1</span>
                                    </div>
                                </div>
                                <div class="item order_address">李广帅</div>
                                <div class="item order_money">
                                    <p class="money">¥74.03</p>
                                    <p class="pay_type">在线支付</p>
                                </div>
                                <div class="item order_status">
                                    <p class="status">已完成</p>
                                    <a href="#" class="order_detail_link">订单详情</a>
                                </div>
                                <div class="item order_operation">
                                    <a href="#">查看发票</a><a href="#">评价</a>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>

    </div>
</div>
</div>
<footer class="footer">
    <div class="w">
        <div class="service">
            <div class="mod-service-item">
                <h5>购物指南</h5>
                <ul>
                    <li><a href="">订单状态</a></li>
                    <li><a href="">交易条款</a></li>
                    <li><a href="">积分说明</a></li>
                    <li><a href="">会员制度</a></li>
                    <li><a href="">购物流程</a></li>
                </ul>
            </div>
            <div class="mod-service-item">
                <h5>购物指南</h5>
                <ul>
                    <li><a href="">支付帮助</a></li>
                    <li><a href="">余额支付</a></li>
                    <li><a href="">银行电汇</a></li>
                    <li><a href="">在线支付</a></li>
                    <li><a href="">货到付款</a></li>
                </ul>
            </div>
            <div class="mod-service-item">
                <h5>购物指南</h5>
                <ul>
                    <li><a href="">EMS/邮政普包</a></li>
                    <li><a href="">商品验货与签收</a></li>
                    <li><a href="">加急快递</a></li>
                    <li><a href="">上门自提</a></li>
                    <li><a href="">配送范围及运费</a></li>
                </ul>
            </div>
            <div class="mod-service-item">
                <h5>购物指南</h5>
                <ul>
                    <li><a href="">售后服务</a></li>
                    <li><a href="">发票制度</a></li>
                    <li><a href="">余额的使用与提现</a></li>
                    <li><a href="">退/换货注意事项</a></li>
                    <li><a href="">退货说明</a></li>
                    <li><a href="">换货说明</a></li>
                </ul>
            </div>
            <div class="mod-service-item">
                <h5>购物指南</h5>
                <ul>
                    <li><a href="">友情链接</a></li>
                    <li><a href="">诚聘英才</a></li>
                    <li><a href="">联系客服</a></li>
                    <li><a href="">退订邮件/短信</a></li>
                    <li><a href="">找回密码</a></li>
                    <li><a href="">常见问题</a></li>
                    <li><a href="">关于我们</a></li>
                </ul>
            </div>
        </div>
        <p class="links">
            <a href="#">关于我们</a><a href="#">常见问题</a><a href="">安全交易</a><a href="">购买流程</a><a href="">如何付款</a><a
                href="">联系我们</a><a
                href="">商务合作</a>
        </p>
        <p class="copyright">Copyright © 2020-2022 应急采购系统 <a class="beian" href="" target="_blank">京ICP备1234567890号</a></p>
    </div>
</footer>
</body>
</html>
