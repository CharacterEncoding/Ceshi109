<%--
  Created by IntelliJ IDEA.
  User: 何锦淼
  Date: 2021/10/14
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>添加用户</title>
    <link rel="stylesheet" href="../../static/css/pintuer.css">
    <link rel="stylesheet" href="../../static/css/admin.css">
    <script src="../../static/js/jquery.js"></script>
    <script src="../../static/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>修改用户</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="update.do">
            <div class="form-group">
                <div class="label">
                    <label>用户名：</label>
                </div>
                <div class="field">
                    <input type="hidden" name="id" value="${sessionScope.person.id}">
                    <input type="text" class="input" name="name" placeholder="${sessionScope.person.name}"  style="width:30%"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>性别：</label>
                </div>
                <div class="field" style="padding-top:8px;">
                    男：<input type="radio"   name="sex" value="男" />
                    女：<input type="radio"   name="sex" value="女" />
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>年龄:</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="age" placeholder="${sessionScope.person.age}"  style="width:30%" required/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</body>
</html>
