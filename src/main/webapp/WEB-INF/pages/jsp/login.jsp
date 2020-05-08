<%--
  Created by IntelliJ IDEA.
  User: liguangshuai
  Date: 2020/5/6
  Time: 12:01 上午
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
    <title>登录</title>
    <link rel="stylesheet" href="<%=path%>/css/base.css">
    <link rel="stylesheet" href="<%=path%>/css/common.css">
    <link rel="stylesheet" href="<%=path%>/css/login.css">
</head>
<body>
<!--Header Start-->
<jsp:include page="header.jsp"/>
<!--Header End-->

<!--Main Start-->
<div class="main">
    <div class="w">
        <div class="info">
            <h3>已有账号,请登录!</h3>
            <p>欢迎使用应急采购系统,如果您已是本站用户,请登录.</p>
        </div>
        <form class="login_form" action="<%=path%>/user/login" method="post">
            <div class="form_group">
                <label for="phoneNum">手机号:</label>
                <input type="text" class="text" id="phoneNum" name="phoneNum" placeholder="请输入手机号...">
                <p class="tips" id="phoneNumTips">请输入手机号!</p>
            </div>
            <div class="form_group">
                <label for="password">密码:</label>
                <input type="password" class="text" id="password" name="password" placeholder="请输入密码...">
                <p class="tips" id="passwordTips">请输入密码!</p>
            </div>
            <div class="form_group">
                <button type="submit" id="loginBtn">登录</button>
                <button type="reset">重置</button>
            </div>
        </form>
    </div>
</div>
<!--Main End-->

<!--Footer Start-->
<jsp:include page="footer.jsp"/>
<!--Footer End-->

<script src="<%=path%>/js/jquery-3.5.0.min.js"></script>
<script src="<%=path%>/js/common.js"></script>
<script>
    $(()=>{
        $('#loginBtn').on('click', ()=>{
            if ($('#phoneNum').val() === '') {
                $('#phoneNumTips').show();
                return false;
            }
            if ($('#password').val() === '') {
                $('#passwordTips').show();
                return false;
            }
        });

        $('#phoneNum').on('keypress', ()=>{
            if ($('#phoneNum').val() !== '') {
                $('#phoneNumTips').hide();
            }
        });
        $('#password').on('keypress', ()=>{
            if ($('#password').val() !== '') {
                $('#passwordTips').hide();
            }
        });
    });
</script>
</body>
</html>