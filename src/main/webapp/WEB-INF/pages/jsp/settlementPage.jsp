<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liguangshuai
  Date: 2020/5/12
  Time: 6:26 下午
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
    <title>订单结算页-社区采购系统</title>
    <link href="<%=path%>/css/base.css" rel="stylesheet">
    <link href="<%=path%>/css/common.css" rel="stylesheet">
    <link href="<%=path%>/css/settlement.css" rel="stylesheet">
</head>
<body>
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
            <p class="settlement-logo">订单结算</p>
        </div>
    </div>
</header>
<div class="settlement-wrap w">
    <div class="hd">
        <h5>填写并核对订单信息</h5>
    </div>
    <div class="bd">
        <form action="" class="settlement-form clearfix">
            <div class="form-item">
                <div class="hd"><h6>收货人信息</h6></div>
                <div class="bd">
                    <div addressId="1" class="first-address address current">
                        <button class="address-item btn address-selected">李广帅</button>
                        <p class="address-item name">李广帅</p>
                        <p class="address-item address-content">江苏 徐州市 铜山经济技术开发区 蟠桃花园三期24号楼4单元101</p>
                        <p class="address-item address-phoneNum">134****8799</p>
                        <p class="address-item default-address">默认地址</p>
                    </div>
                    <div id="more-address" class="more-address">
                        <div addressId="2" class=" address">
                            <button class="address-item btn">李广帅</button>
                            <p class="address-item name">李广帅</p>
                            <p class="address-item address-content">江苏 徐州市 铜山经济技术开发区 蟠桃花园三期24号楼4单元101</p>
                            <p class="address-item address-phoneNum">134****8799</p>
                        </div>
                        <div addressId="3" class=" address">
                            <button class="address-item btn">李广帅</button>
                            <p class="address-item name">李广帅</p>
                            <p class="address-item address-content">江苏 徐州市 铜山经济技术开发区 蟠桃花园三期24号楼4单元101</p>
                            <p class="address-item address-phoneNum">134****8799</p>
                        </div>
                        <div addressId="4" class=" address">
                            <button class="address-item btn">李广帅</button>
                            <p class="address-item name">李广帅</p>
                            <p class="address-item address-content">江苏 徐州市 铜山经济技术开发区 蟠桃花园三期24号楼4单元101</p>
                            <p class="address-item address-phoneNum">134****8799</p>
                        </div>
                        <div addressId="5" class=" address">
                            <button class="address-item btn">李广帅</button>
                            <p class="address-item name">李广帅</p>
                            <p class="address-item address-content">江苏 徐州市 铜山经济技术开发区 蟠桃花园三期24号楼4单元101</p>
                            <p class="address-item address-phoneNum">134****8799</p>
                        </div>
                    </div>
                    <a href="#" class="show-more-address">更多地址>></a>
                </div>
            </div>
            <div class="form-item">
                <div class="hd"><h6>购物清单</h6></div>
                <div class="bd">
                    <c:forEach items="${goodsList}" var="goods">
                        <div goodsId="${goods}" class="goods-list">
                            <div class="goods-list-item clearfix">
                                <img src="${goods.goodsImage}"
                                     alt="">
                                <div class="goods-list-item-content">
                                    <div class="goods-content-item title">${goods.goodsName}</div>
                                    <div class="goods-content-item price">￥${goods.goodsSalesPrice}</div>
                                    <div class="goods-content-item nums">x${goods.quantity}</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="settlement-summary">
                <p>应付总额：￥202171.40</p>
                <p>寄送至：江苏 徐州市 金山桥开发区 蟠桃花园东贺A区阳光便利店收货人：李广帅 131****8799</p>
            </div>
            <button id="addOrder" class="submit-order">提交订单</button>
        </form>
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
        <p class="copyright">Copyright © 2020-2022 应急采购系统 <a class="beian" href="" target="_blank">京ICP备1234567890号</a>
        </p>
    </div>
</footer>
<script src="<%=path%>/js/jquery-3.5.0.min.js"></script>
<script src="<%=path%>/js/common.js"></script>
<script>
    console.log();
    let orderInfo = {
        goodsInfo: {},
        addressId: $('.address.current')[0].getAttribute('addressId')
    }
    <c:forEach items="${goodsList}" var="goods">
        orderInfo.goodsInfo['${goods.goodsId}'] = ${goods.quantity};
    </c:forEach>

    $(() => {
        $('#addOrder').on('click', () => {
            console.log(JSON.stringify(orderInfo));
            $.ajax({
                url: '<%=path%>/order/addOrder',
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify(orderInfo),
                type: 'post',
                dataType: 'json',
                success:(response)=>{
                    console.log(response);
                    if (response.success) {
                        window.location.href = "<%=path%>/order/orderList";
                    }
                }
            });
            console.log('helloworld');
            return false;
        })
    });
</script>
</body>
</html>