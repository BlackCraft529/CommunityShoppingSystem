<%--
  Created by IntelliJ IDEA.
  User: liguangshuai
  Date: 2020/5/6
  Time: 9:35 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品详情</title>
    <link href="css/base.css" rel="stylesheet">
    <link href="css/common.css" rel="stylesheet">
    <link href="css/goodsInfo.css" rel="stylesheet">
</head>
<body>
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

<div class="w">
    <div class="main">
        <div class="product-intro clearfix">
            <div class="preview-wrap">
                <img alt="" src="upload/9ecf0b5491ed4aa69c41de609d2ded30.jpg">
            </div>
            <div class="item-info">
                <div class="goods-title">
                    佳能（Canon） PowerShot SX700 HS 数码相机 红色（1610万像素 30倍光变 3英寸高清屏 25mm广角 WiFi/NFC）
                </div>
                <div class="news">推荐选择下方[移动优惠购],手机套餐齐搞定,不用换号,每月还有花费返</div>
                <div class="summary">
                    <dl class="price">
                        <dt>价格</dt>
                        <dd><i>￥1299.0</i>&nbsp;&nbsp;<del>￥1500.0</del>
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
                            以旧换新，闲置手机回收  4G套餐超值抢  礼品购
                        </dd>
                    </dl>
                    <dl class="remain">
                        <dt>库存</dt>
                        <dd>
                            1999+
                        </dd>
                    </dl>
                    <div class="chose-btn">
                        <div class="chose-amount">
                            <input type="text" value="1">
                            <a href="javascript:;" class="add">+</a>
                            <a href="javascript:;" class="reduce not-reduce">-</a>
                        </div>
                        <a href="#" class="addcar">加入购物车</a>
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

<script src="js/jquery-3.5.0.min.js"></script>
<script src="js/common.js"></script>
</body>
</html>
