<%--
  Created by IntelliJ IDEA.
  User: liguangshuai
  Date: 2020/5/25
  Time: 12:00 下午
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
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
    <link href="<%=path%>/css/userInfo.css" rel="stylesheet">
</head>
<body>
<jsp:include page="userCenterHeader.jsp"/>
<div class="main">
    <div class="w clearfix">
        <jsp:include page="sideNav.jsp"/>
        <div class="content fl">
            <form action="<%=path%>/user/update">
                <div class="item">
                    <div class="hd">用户ID:</div>
                    <div class="bd">${sessionScope.user.userId}</div>
                </div>
                <div class="item">
                    <div class="hd">手机号:</div>
                    <div class="bd">
                        <input type="text" name="phoneNum" value="${sessionScope.user.phoneNum}">
                    </div>
                </div>
                <div class="item">
                    <div class="hd">昵称:</div>
                    <div class="bd">
                        <input type="text" name="nickname" value="${sessionScope.user.nickname}">
                    </div>
                </div>
                <div class="item">
                    <div class="hd">邮箱:</div>
                    <div class="bd">${sessionScope.user.email}</div>
                </div>
                <div class="item">
                    <button type="submit">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>

<footer class="footer">
    <div class="w">
        <p class="copyright">Copyright © 2020-2022 应急采购系统 <a class="beian" href="" target="_blank">京ICP备1234567890号</a>
        </p>
    </div>
</footer>
</body>
</html>