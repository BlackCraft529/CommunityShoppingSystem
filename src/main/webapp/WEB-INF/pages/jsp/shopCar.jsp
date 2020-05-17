<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liguangshuai
  Date: 2020/5/12
  Time: 6:29 下午
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
    <title>购物车</title>
    <link href="<%=path%>/css/base.css" rel="stylesheet">
    <link href="<%=path%>/css/common.css" rel="stylesheet">
    <link href="<%=path%>/css/shopCar.css" rel="stylesheet">
</head>
<body>
<!--Header Start-->
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
                <c:forEach items="${categories}" var="category">
                    <li><a class="nav_item" href="<%=path%>/goods/goodsListCate?cateId=${category.cateId}">${category.cateName}</a></li>
                </c:forEach>
            </ul>
        </nav>
    </div>
</header>
<!--Header End-->

<div class="main">
    <div class="w">
        <div class="cart-filter-bar">
            <a href="javascript:;">全部商品<span id="goodsNums">0</span></a>
        </div>
    </div>
    <div class="w">
        <div class="cart-wrap">
            <div class="cart-head">
                <div class="cart-head-item select-all">
                    <input id="selectAll" type="checkbox">全选
                </div>
                <div class="cart-head-item goods">商品</div>
                <div class="cart-head-item price">价格</div>
                <div class="cart-head-item quantity">数量</div>
                <div class="cart-head-item summery">小结</div>
                <div class="cart-head-item operation">操作</div>
            </div>
            <div class="cart-list clearfix">
                <c:forEach items="${goods}" var="item" step="1">
                    <div id="goods${item.goodsId}" class="goods-detail" goodsid="${item.goodsId}" price="${item.goodsSalesPrice}">
                        <div class="goods-detail-item">
                            <input class="goodsCheckBox" type="checkbox">
                        </div>
                        <div class="goods-detail-item goods">
                            <img alt="" src="${item.goodsImage}">
                            <p>${item.goodsName}</p>
                        </div>
                        <div class="goods-detail-item">¥${item.goodsSalesPrice}</div>
                        <div class="goods-detail-item quantity">
                            <input id="quantity${item.goodsId}" class="goods-num" type="text" value="${item.quantity}">
                            <a class="reduce" onclick="decreasement('${item.goodsId}')">-</a>
                            <a class="add" onclick="increasement('${item.goodsId}')">+</a>
                        </div>
                        <div class="goods-detail-item summery">¥${item.goodsSalesPrice}</div>
                        <div class="goods-detail-item">
                            <a onclick="deleteGoods('${item.goodsId}')">删除</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="settlement">
        <div class="settlement-wrap w">
            <div class="settlement-item select-all">
                <input id="selectAllTwo" type="checkbox">全选
            </div>
            <a class="settlement-item delete-selected" href="#">删除选中商品</a>
            <p class="settlement-item num-selected">已选择<span id="selectedGoodsNums">0</span>件商品</p>
            <button id="settle-up" class="settlement-item settlement-btn">去结算</button>
            <p class="settlement-item sum-price">总价<span id="sum-price">¥0.0</span></p>
        </div>
    </div>
</div>

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

<script>
    let selectedGoodsList = [];
    let goodsList = $('.goods-detail');
    let goodsNumList = $('.goods-num');
    let checkBoxList = $('.goodsCheckBox');

    $(() => {

        /**/
        $('#settle-up').on('click', () => {

        })

        $('#settle-up').on('click', () => {

        });

        /* 设置复选框监听事件 */
        let list = checkBoxList;
        for (let i = 0; i < list.length; i++) {
            $(list[i]).on('click', () => {
                checkSelectedAll();
            });
        }

        /* 设置商品数量输入框事件监听 */
        let numsInput = goodsNumList;
        for (let i = 0; i < goodsNumList.length; i++) {
            $(goodsNumList[i]).on('input propertychange', () => {
                if ($(goodsNumList[i]).val() <= 0) {
                    $(goodsNumList[i]).val(1);
                }
                calculatePrice();
            })
        }

        /* 设置商品总数 */
        $('#goodsNums').text($('.goods-detail').length);

        /* 全选按钮一 */
        $('#selectAllTwo').on('click', () => {
            let checked = $('#selectAllTwo')[0].checked;
            selectedAllFun(checked);
            checkSelectedAll();
            $('#selectAll')[0].checked = checked;
        });

        /* 全选按钮二 */
        $('#selectAll').on('click', () => {
            let checked = $('#selectAll')[0].checked;
            selectedAllFun(checked);
            checkSelectedAll();
            $('#selectAllTwo')[0].checked = checked;
        })
    });

    /* 全选 */
    function selectedAllFun(checked) {
        let remark = true;
        let checkBoxes = $('.goodsCheckBox');
        if (checked) {
            $('#selectedGoodsNums').text(checkBoxes.length);
            remark = true;
        } else {
            $('#selectedGoodsNums').text(0);
            remark = false;
        }
        for (let i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i].checked = remark;
        }
    }

    /* 检查是否全选 */
    function checkSelectedAll() {
        let mark = true;
        let count = 0;
        let list = checkBoxList
        for (let i = 0; i < list.length; i++) {
            if (!list[i].checked) {
                mark = false;
                delete selectedGoodsList[$(goodsList[i]).attr('goodsid')]
            } else {
                count += 1;
            }
        }

        /* 设置两个全选框 */
        $('#selectAll')[0].checked = mark;
        $('#selectAllTwo')[0].checked = mark;

        /* 设置选中商品数量 */
        $('#selectedGoodsNums').text(count);
        calculatePrice();
    }

    /*商品增加*/
    function increasement(id) {
        let quantityId = '#quantity' + id;
        let numsInput = $(quantityId);
        numsInput.val(parseInt(numsInput.val()) + 1);
        let quantity = parseInt($(quantityId).val());
        updateQuantity(id, quantity);
        calculatePrice();
    }

    /*商品减少*/
    function decreasement(id) {
        let quantityId = '#quantity' + id;
        let numsInput = $(quantityId);
        numsInput.val(parseInt(numsInput.val()) - 1);
        if (numsInput.val() <= 0) {
            numsInput.val(1);
        }
        let quantity = parseInt($(quantityId).val());
        updateQuantity(id, quantity);
        calculatePrice();
    }

    function updateQuantity(goodsId, quantity) {
        $.getJSON('<%=path%>/cart/updateGoodsQuantity', {
            'goodsId': goodsId,
            'quantity': quantity
        }, (response) => {
            if (response.status === true) {
                console.log("修改成功!")
            }
        })
    }

    function deleteGoods(id) {
        $('#goods' + id).remove();
        $.get({
            url:'<%=path%>/cart/deleteGoods',
            data: {
                'goodsId':id
            }
        });
    }

    function calculatePrice() {
        let price = 0;
        for (let i = 0; i < checkBoxList.length; i++) {
            if (checkBoxList[i].checked) {
                price += $(goodsList[i]).attr('price') * $(goodsNumList[i]).val();
            }
        }
        if (price === 0) {
            $('#sum-price').text('¥0.0');
        } else {
            $('#sum-price').text('¥' + price);
        }
    }
</script>
</body>
</html>
