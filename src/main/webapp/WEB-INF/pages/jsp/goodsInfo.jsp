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
    <title>商品详情</title>
    <link href="<%=path%>/css/base.css" rel="stylesheet">
    <link href="<%=path%>/css/common.css" rel="stylesheet">
    <link href="<%=path%>/css/goodsInfo.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="w">
    <div class="main">
        <div class="product-intro clearfix">
            <div class="preview-wrap">
                <img alt="" src="${goods.goodsImage}">
            </div>
            <div class="item-info">
                <div class="goods-title">
                    ${goods.goodsName}
                </div>
                <div class="news">推荐选择下方[移动优惠购],手机套餐齐搞定,不用换号,每月还有花费返</div>
                <div class="summary">
                    <dl class="price">
                        <dt>价格</dt>
                        <dd><i>￥${goods.goodsSalesPrice}</i>&nbsp;&nbsp;<del>￥${goods.goodsPrice}</del>
                        </dd>
                    </dl>
                    <dl class="promotion">
                        <dt>促销</dt>
                        <dd>
                            <span>加价购</span>满999.00另加20.00元，或满2999.00另加40.00元，即可在购物车换购热销商品 详情>
                        </dd>
                    </dl>
                    <dl class="support">
                        <dt>支持</dt>
                        <dd>
                            以旧换新，闲置手机回收 4G套餐超值抢 礼品购
                        </dd>
                    </dl>
                    <dl class="remain">
                        <dt>库存</dt>
                        <dd>
                            ${goods.goodsRemain}
                        </dd>
                    </dl>
                    <dl class="goodsId">
                        <dt>商品编号</dt>
                        <dd id="goodsId">${goods.goodsId}</dd>
                    </dl>
                    <div class="chose-btn">
                        <div class="chose-amount">
                            <input id="quantity" type="text" value="1">
                            <a href="javascript:;" class="add">+</a>
                            <a href="javascript:;" class="reduce not-reduce">-</a>
                        </div>
                        <a id="addCart" href="#" class="addcar">加入购物车</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="side-list"></div>
            <div class="goods-info"></div>
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

<script src="<%=path%>/js/jquery-3.5.0.min.js"></script>
<script src="<%=path%>/js/common.js"></script>
<script>
    $(() => {
        $('#addCart').on('click', () => {
            let goodsId = $('#goodsId').text();
            let quantity = parseInt($('#quantity').val());
            $.getJSON('<%=path%>/cart/addToShopCart', {
                'goodsId': goodsId,
                'quantity': quantity
            }, (response) => {
                if (response.status === true) {
                    console.log("加入购物车成功!!!")
                    $(location).attr('href', '<%=path%>/cart/shopCar');
                } else if (response.reason === 'notLogin') {
                    $(location).attr('href', '<%=path%>/user/toLogin');
                }
            })
        });
    });
</script>
</body>
</html>
