<%--
  Created by IntelliJ IDEA.
  User: liguangshuai
  Date: 2020/5/15
  Time: 6:34 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<button id="button">Test</button>

<script src="js/jquery-3.5.0.min.js"></script>
<script>
    $(() => {
        $('#button').on('click', () => {
            let data = new Map();
            data.set('0', 'value0');
            data.set('1', 'value1');
            data.set('2', 'value2');
            data.set('3', 'value3');
            data.set('4', 'value4');
            data.set('5', 'value5');
            data.set('6', 'value6');
            data.set('7', 'value7');
            data.set('8', 'value8');
            data.set('9', 'value9');
            let obj= Object.create(null);
            for (let[k,v] of data) {
                obj[k] = v;
            }
            $.ajax({
                url: 'indexText',
                type: 'post',
                dataType: 'json',
                data: JSON.stringify(obj),
                contentType : 'application/json;charset=utf-8',
                success: (response) => {
                    console.log(response);
                }
            });
        })
    });
</script>
</body>
</html>
