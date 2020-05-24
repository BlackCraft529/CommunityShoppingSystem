<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liguangshuai
  Date: 2020/5/24
  Time: 10:18 下午
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
    <link href="<%=path%>/css/addressList.css" rel="stylesheet">
</head>
<body>
<header class="header">
    <div class="w">
        <div class="header_top clearfix">
            <h1 class="logo">
                <a class="prim_logo" href="<%=path%>/index">应急采购系统</a>
            </h1>
            <a class="sub_logo" href="#">用户中心</a>
            <div class="top_right">
                <ul class="system_link clearfix">
                    <li><a href="#">会员中心</a></li>
                    <li><a href="<%=path%>/order/orderList">我的订单</a></li>
                    <li><a href="#">后台管理</a></li>
                    <li><a href="#">使用帮助</a></li>
                </ul>
                <p class="user_info">
                    <span class="user_name">${sessionScope.user.nickname}</span>您好！欢迎登录应急采购系统！[<a
                        href="<%=path%>/user/logout">安全退出</a>]
                </p>
            </div>
        </div>
    </div>
</header>
<div class="main">
    <div class="w clearfix">
        <jsp:include page="sideNav.jsp"/>
        <div class="content fl">
            <div class="head">
                我的地址
            </div>
            <div class="content-address">
                <div class="hd clearfix">
                    <button id="addAddress">创建新地址</button>
                    <p>您已经创建3个地址，最多可以创建25个地址</p>
                </div>
                <div class="bd">
                    <c:if test="${empty addressList}">
                        <div class="none_list">
                            <p>暂无地址信息，请添加!!!</p>
                        </div>
                    </c:if>
                    <c:if test="${!empty addressList}">
                        <c:forEach items="${addressList}" var="address">
                            <div id="${address.addressId}" class="address-item">
                                <div class="item-head">
                                    <h4>${address.contact}</h4>
                                    <span class="delete" onclick="deleteAddress(${address.addressId})">X</span>
                                </div>
                                <table>
                                    <tr>
                                        <td class="key">收货人:</td>
                                        <td class="value">${address.contact}</td>
                                    </tr>
                                    <tr>
                                        <td class="key">所在地区:</td>
                                        <td class="value">${address.province} ${address.city} ${address.district}</td>
                                    </tr>
                                    <tr>
                                        <td class="key">详细地址:</td>
                                        <td class="value">${address.detailAddress}</td>
                                    </tr>
                                    <tr>
                                        <td class="key">联系电话:</td>
                                        <td class="value">${address.phoneNum}</td>
                                    </tr>
                                </table>
                                <span class="edit" onclick="editAddress('${address.addressId}')">编辑</span>
                            </div>
                        </c:forEach>
                    </c:if>
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
        <p class="copyright">Copyright © 2020-2022 应急采购系统 <a class="beian" href="" target="_blank">京ICP备1234567890号</a>
        </p>
    </div>
</footer>
<div class="shield" id="shield">
    <div class="address-dialog">
        <div class="dialog-title">
            <span>添加收货地址</span>
            <span class="close" id="close">X</span>
        </div>
        <div class="dialog-con">
            <form id="addressForm" action="" method="post">
                <div class="dialog-item">
                    <div class="hd">收件人</div>
                    <div class="bd">
                        <input id="contact" class="contact" type="text" name="contact">
                    </div>
                </div>
                <div class="dialog-item">
                    <div class="hd">请选择地区</div>
                    <div class="bd">
                        <div data-toggle="distpicker">
                            <select id="province" data-province="" name="province"></select>
                            <select id="city" data-city="" name="city"></select>
                            <select id="district" data-district="" name="district"></select>
                        </div>
                    </div>
                </div>
                <div class="dialog-item">
                    <div class="hd">详细地址</div>
                    <div class="bd">
                        <input id="detailAddress" class="address-detail" name="detailAddress" type="text">
                    </div>
                </div>
                <div class="dialog-item">
                    <div class="hd">联系电话</div>
                    <div class="bd">
                        <input id="phoneNum" class="phoneNum" name="phoneNum" type="text">
                    </div>
                </div>
                <div class="dialog-item">
                    <button class="submit" type="submit">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="<%=path%>/js/jquery-3.5.0.min.js"></script>
<script src="<%=path%>/js/distpicker.js"></script>
<script>
    $('#target').distpicker();
    $(() => {
        $('#close').on('click', () => {
            $('#shield').fadeOut();
        })
        $('#addAddress').on('click', () => {
            $('#addressForm').setAttribute('action', '<%=path%>/address/add');
            $('.dialog-title span').text('添加收货地址');
            $('#shield').fadeIn();
        });
        $('.dialog-title span')
    });

    function editAddress(id) {
        $('#addressForm').attr('action', '<%=path%>/address/update');
        $.ajax({
            url: '<%=path%>/address/getAddressInfo',
            data: {
                id: id
            },
            type: 'post',
            dataType: 'json',
            success: (response) => {
                if (response.success) {
                    console.log(response.address);
                    let address = response.address;
                    $('#contact').val(address.contact);
                    $('#province').val(address.province);
                    $('#city').val(address.city);
                    $('#district').val(address.district);
                    $('#detailAddress').val(address.detailAddress);
                    $('#phoneNum').val(address.phoneNum);
                    $('#shield').fadeIn();
                }
            }
        })
    }

    function deleteAddress(id) {
        $('#' + id).remove();
    }
</script>
</body>
</html>
