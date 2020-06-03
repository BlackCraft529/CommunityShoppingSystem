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
                            <a id="add" class="add">+</a>
                            <a id="reduce" class="reduce not-reduce">-</a>
                        </div>
                        <a id="addCart" class="addcar">加入购物车</a>
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

<jsp:include page="footer.jsp"></jsp:include>

<script src="<%=path%>/js/jquery-3.5.0.min.js"></script>
<script src="<%=path%>/js/common.js"></script>
<script>
    $(() => {
        $('#addCart').on('click', () => {
            let goodsId = $('#goodsId').text();
            let quantity = parseInt($('#quantity').val());
            $.ajax({
                url: '<%=path%>/cart/addToShopCart',
                data: {
                    'goodsId': goodsId,
                    'quantity': parseInt(quantity)
                },
                type:'post',
                dataType:'json',
                success: (response) => {
                    if (response.success) {
                        showAlert("加入购物车成功！！！")
                        /*$(location).attr('href', '<%=path%>/cart/shopCar');*/
                    } else {
                        $(location).attr('href', '<%=path%>/user/toLogin');
                    }
                }
            });
        });

        $('#add').on('click', () => {
            $('#quantity').val(parseInt($('#quantity').val()) + 1);
        })

        $('#reduce').on('click', () => {
            $('#quantity').val(parseInt($('#quantity').val()) - 1);
            if (parseInt($('#quantity').val()) <= 0) {
                $('#quantity').val(1);
                $('#reduce').attr('class', 'reduce not-reduce');
            } else {
                $('#reduce').attr('class', 'reduce');
            }
        })


    });
</script>
</body>
</html>
