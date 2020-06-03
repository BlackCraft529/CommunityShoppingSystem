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
                <a class="prim_logo" href="<%=path%>/index">应急采购系统</a>
            </h1>
            <div class="top_right">
                <ul class="system_link clearfix">
                    <li><a href="<%=path%>/user/info">会员中心</a></li>
                    <li><a href="<%=path%>/order/orderList">我的订单</a></li>
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
                    <div id="${addressList.get(0).addressId}" class=" address current">
                        <button type="button" class="address-item btn"
                                onclick="changeAddress('${addressList.get(0).addressId}')">${addressList.get(0).contact}</button>
                        <p class="address-item name">${addressList.get(0).contact}</p>
                        <p class="address-item address-content">${addressList.get(0).province} ${addressList.get(0).city} ${addressList.get(0).district} ${addressList.get(0).detailAddress}</p>
                        <p class="address-item address-phoneNum">${addressList.get(0).phoneNum}</p>
                        <p class="address-item default-address">默认地址</p>
                    </div>
                    <div id="more-address" class="more-address">
                        <c:forEach items="${addressList}" var="address" begin="1">
                            <div id="${address.addressId}" class=" address">
                                <button type="button" onclick="changeAddress('${address.addressId}')"
                                        class="address-item btn">${address.contact}</button>
                                <p class="address-item name">${address.contact}</p>
                                <p class="address-item address-content">${address.province} ${address.city} ${address.district} ${address.detailAddress}</p>
                                <p class="address-item address-phoneNum">${address.phoneNum}</p>
                            </div>
                        </c:forEach>
                    </div>
                    <a id="showMoreAddress" class="show-more-address">更多地址>></a>
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
                <p id="settlement-summary-money">应付总额：￥${money}</p>
                <p id="settlement-summary-address">寄送至：${addressList.get(0).province} ${addressList.get(0).city} ${addressList.get(0).district} ${addressList.get(0).detailAddress}</p>
            </div>
            <button id="addOrder" class="submit-order">提交订单</button>
        </form>
    </div>
</div>
<footer class="footer">
    <div class="w">
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
        addressId: '${addressList.get(0).addressId}'
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
                success: (response) => {
                    console.log(response);
                    if (response.success) {
                        window.location.href = "<%=path%>/order/orderList";
                    }
                }
            });
            console.log('helloworld');
            return false;
        })

        $('#showMoreAddress').on('click', () => {
            $('#more-address').fadeIn();
        })
    });

    function changeAddress(id) {
        console.log(id);
        $.ajax({
            url: '<%=path%>/address/getAddressInfo',
            data: {'id': id},
            dataType: 'json',
            success: (response) => {
                if (response.success) {
                    let address = response.address;
                    let addressString = '寄送至：' + address.province + address.city + address.district + address.detailAddress + ' 收货人：' + address.contact + ' ' + address.phoneNum;
                    $('#settlement-summary-address').text(addressString);

                    let addressList = $('.address');
                    for (let i = 0; i < addressList.length; i++) {
                        $(addressList[i]).attr('class', 'address');
                    }
                    $('#' + address.addressId).attr('class', 'address current');
                    orderInfo['addressId'] = address.addressId;
                }
            }
        })
    }
</script>
</body>
</html>