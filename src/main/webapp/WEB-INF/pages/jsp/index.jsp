<%--
  Created by IntelliJ IDEA.
  User: liguangshuai
  Date: 2020/5/6
  Time: 12:00 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <link href="css/base.css" rel="stylesheet">
    <link href="css/common.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    <title>商城</title>
</head>
<body>
<header class="header">
    <div class="w">
        <div class="header_top clearfix">
            <h1 class="logo">
                <a href="/index">应急采购系统</a>
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
<!--<div class="side_list">
	<div class="flexslider">
		<ul class="slides">
			<li style="background:url(upload/side_list1.jpg) 50% 0 no-repeat;"></li>
			<li style="background:url(upload/side_list1.jpg) 50% 0 no-repeat;"></li>
			<li style="background:url(upload/side_list1.jpg) 50% 0 no-repeat;"></li>
			<li style="background:url(upload/side_list1.jpg) 50% 0 no-repeat;"></li>
			<li style="background:url(upload/side_list1.jpg) 50% 0 no-repeat;"></li>
		</ul>
	</div>
</div>-->
<div class="main clearfix">
    <div class="w">
        <div class="goods_view">
            <div class="new_goods_box clearfix">
                <h3 class="new_goods_title">最新商品</h3>
                <div class="new_goods">
                    <div class="goods">
                        <a href="#"><img alt="" class="goods_img" src="upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                        <p class="goods_name">小米4 2GB内存版 白色 移动4G</p>
                        <p class="new_price">优惠价：<span>￥1299.0</span></p>
                        <p class="old_price">市场价：
                            <del>￥1300.0</del>
                        </p>
                    </div>
                    <div class="goods">
                        <a href="#"><img alt="" class="goods_img" src="upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                        <p class="goods_name">小米4 2GB内存版 白色 移动4G</p>
                        <p class="new_price">优惠价：<span>￥1299.0</span></p>
                        <p class="old_price">市场价：
                            <del>￥1300.0</del>
                        </p>
                    </div>
                    <div class="goods">
                        <a href="#"><img alt="" class="goods_img" src="upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                        <p class="goods_name">小米4 2GB内存版 白色 移动4G</p>
                        <p class="new_price">优惠价：<span>￥1299.0</span></p>
                        <p class="old_price">市场价：
                            <del>￥1300.0</del>
                        </p>
                    </div>
                    <div class="goods">
                        <a href="#"><img alt="" class="goods_img" src="upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                        <p class="goods_name">小米4 2GB内存版 白色 移动4G</p>
                        <p class="new_price">优惠价：<span>￥1299.0</span></p>
                        <p class="old_price">市场价：
                            <del>￥1300.0</del>
                        </p>
                    </div>
                    <div class="goods">
                        <a href="#"><img alt="" class="goods_img" src="upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                        <p class="goods_name">小米4 2GB内存版 白色 移动4G</p>
                        <p class="new_price">优惠价：<span>￥1299.0</span></p>
                        <p class="old_price">市场价：
                            <del>￥1300.0</del>
                        </p>
                    </div>
                    <div class="goods">
                        <a href="#"><img alt="" class="goods_img" src="upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                        <p class="goods_name">小米4 2GB内存版 白色 移动4G</p>
                        <p class="new_price">优惠价：<span>￥1299.0</span></p>
                        <p class="old_price">市场价：
                            <del>￥1300.0</del>
                        </p>
                    </div>
                    <div class="goods">
                        <a href="#"><img alt="" class="goods_img" src="upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                        <p class="goods_name">小米4 2GB内存版 白色 移动4G</p>
                        <p class="new_price">优惠价：<span>￥1299.0</span></p>
                        <p class="old_price">市场价：
                            <del>￥1300.0</del>
                        </p>
                    </div>
                    <div class="goods">
                        <a href="#"><img alt="" class="goods_img" src="upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                        <p class="goods_name">小米4 2GB内存版 白色 移动4G</p>
                        <p class="new_price">优惠价：<span>￥1299.0</span></p>
                        <p class="old_price">市场价：
                            <del>￥1300.0</del>
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="side_bar">
            <h3 class="hot_goods_title">最热商品</h3>
            <div class="hot_goods_box">
                <div class="hot_goods">
                    <a href="#"><img alt="mi4" class="goods_img" src="upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                    <p class="goods_name">小米4 2GB内存</p>
                    <p class="new_price">￥1299.0</p>
                </div>
                <div class="hot_goods">
                    <a href="#"><img alt="mi4" class="goods_img" src="upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                    <p class="goods_name">小米4 2GB内存</p>
                    <p class="new_price">￥1299.0</p>
                </div>
                <div class="hot_goods">
                    <a href="#"><img alt="mi4" class="goods_img" src="upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                    <p class="goods_name">小米4 2GB内存</p>
                    <p class="new_price">￥1299.0</p>
                </div>
                <div class="hot_goods">
                    <a href="#"><img alt="mi4" class="goods_img" src="upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                    <p class="goods_name">小米4 2GB内存</p>
                    <p class="new_price">￥1299.0</p>
                </div>
                <div class="hot_goods">
                    <a href="#"><img alt="mi4" class="goods_img" src="upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                    <p class="goods_name">小米4 2GB内存</p>
                    <p class="new_price">￥1299.0</p>
                </div>
                <div class="hot_goods">
                    <a href="#"><img alt="mi4" class="goods_img" src="upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                    <p class="goods_name">小米4 2GB内存</p>
                    <p class="new_price">￥1299.0</p>
                </div>
                <div class="hot_goods">
                    <a href="#"><img alt="mi4" class="goods_img" src="upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                    <p class="goods_name">小米4 2GB内存</p>
                    <p class="new_price">￥1299.0</p>
                </div>
                <div class="hot_goods">
                    <a href="#"><img alt="mi4" class="goods_img" src="upload/e5adbeeb36534140b50c327f6fd71a6b.jpg"></a>
                    <p class="goods_name">小米4 2GB内存</p>
                    <p class="new_price">￥1299.0</p>
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

<script src="js/jquery-3.5.0.min.js"></script>
<script src="js/common.js"></script>
</body>
</html>
