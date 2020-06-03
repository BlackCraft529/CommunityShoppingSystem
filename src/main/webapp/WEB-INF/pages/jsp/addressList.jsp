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
<jsp:include page="userCenterHeader.jsp"/>
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
                    <p>您已经创建${addressList.size()}个地址，最多可以创建25个地址</p>
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
                                    <span class="delete" onclick="deleteAddress('${address.addressId}')">X</span>
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
        <p class="copyright">Copyright © 2020-2022 应急采购系统 <a class="beian" href="" target="_blank">京ICP备1234567890号</a>
        </p>
    </div>
</footer>
<div class="shield" id="shield">
    <div class="address-dialog">
        <div class="dialog-title">
            <span class="dialog-title-con">添加收货地址</span>
            <span class="close" id="close" style="font-family: iconfont">&#xe63a;</span>
        </div>
        <div class="dialog-con">
            <form id="addressForm" action="" method="post">
                <div class="dialog-item" style="display: none;">
                    <div class="hd">编号</div>
                    <div class="bd">
                        <input id="addressId" class="addressId" type="text" name="addressId">
                    </div>
                </div>
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
<script src="<%=path%>/js/common.js"></script>
<script src="<%=path%>/js/distpicker.js"></script>
<script>
    $('#target').distpicker();
    $(() => {
        $('#close').on('click', () => {
            $('#shield').fadeOut();
        })
        $('#addAddress').on('click', () => {
            $('#addressForm').attr('action', '<%=path%>/address/add');
            $('.dialog-title-con').text('添加收货地址');
            $('#contact').val('');
            $('#province').val('');
            $('#city').val('');
            $('#district').val('');
            $('#detailAddress').val('');
            $('#phoneNum').val('');
            $('#shield').fadeIn();
        });
        $('.dialog-title span')
    });

    function editAddress(id) {
        $('.dialog-title-con').text('修改收货地址');
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
                    let address = response.address;
                    $('#addressId').val(address.addressId);
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
        $.ajax({
            url: '<%=path%>/address/delete',
            data: {
                'addressId': id
            },
            type: 'get',
            dataType: 'json',
            success: (response) => {
                if (response.success) {
                    showAlert('删除成功!!!')
                    $('#' + id).remove();
                }
            }
        })
    }
</script>
</body>
</html>
