<%--
  Created by IntelliJ IDEA.
  User: 何锦淼
  Date: 2021/10/14
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="../../static/css/pintuer.css">
    <link rel="stylesheet" href="../../static/css/admin.css">
    <script src="../../static/js/jquery.js"></script>
    <script src="../../static/js/pintuer.js"></script>
</head>
<body>
<form method="post" action="selectlike.do" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 用户列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li>
                    用户名:
                    <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
                  <%--  手机号:
                    <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />--%>
<%--                    <input href="selectlike.do" class="button border-main icon-search" onclick="changesearch()" > 搜索</input>--%>
                    <input type="submit" class="button border-main icon-search" onclick="changesearch()" value="搜索">
                </li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">编号</th>
                <th width="10%">姓名</th>
<%--                <th>手机号</th>--%>
                <th>性别</th>
                <th>年龄</th>
                <th width="310">操作</th>
            </tr>
            <c:forEach items="${sessionScope.list}" var="list" varStatus="c">
                <tr>
                    <td style="text-align:left; padding-left:20px;">${c.count}</td>
                    <td>${list.name}</td>
                    <td>${list.sex}</td>
                    <td>${list.age}</td>

                    <td><div class="button-group">
                        <a class="button border-main" href="toUpdate.do?id=${list.id}"><span class="icon-edit"></span> 修改</a>
                        <a class="button border-red" href="#" onclick="del(${list.id})"><span class="icon-trash-o"></span> 删除</a>
                        </div>
                    </td>
                </tr>

            </c:forEach>
            <tr>
                <td colspan="8">
                    <div class="pagelist">
                        <a href="page.do?numpage=1">首页</a>
                        <c:if test="${sessionScope.numpage != 1}">
                            <a href="page.do?numpage=${(sessionScope.numpage)-1}">上一页</a>
                        </c:if>
                        <c:forEach begin="1" end="${sessionScope.zy}" varStatus="c">
                            <a href="page.do?numpage=${c.count}">${c.count}</a>
                        </c:forEach>
                       <%-- <a href="page.do?numpage=2">2</a>
                        <a href="page.do?numpage=3">3</a>
                        <a href="page.do?numpage=4">4</a>--%>
                        <c:if test="${sessionScope.numpage != sessionScope.zy}">
                            <a href="page.do?numpage=${(sessionScope.numpage)+1}">下一页</a>
                        </c:if>
                        <a href="page.do?numpage=${sessionScope.zy}">尾页</a>
                    </div>
                </td>
            </tr>

        </table>
    </div>
</form>
<script type="text/javascript">

    //搜索
    function changesearch(){

    }

    //单个删除
   /* function del(id,mid,iscid){
        if(confirm("您确定要删除吗?")){

        }
    }*/
    function del(id){
        if (window.confirm("您确定要删除吗？")) {
            location.href="delete.do?id="+id;
            alert("删除成功！！！")
        }
    }

    //全选
    $("#checkall").click(function(){
        $("input[name='id[]']").each(function(){
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })

    //批量删除
    function DelSelect(){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var t=confirm("您确认要删除选中的内容吗？");
            if (t==false) return false;
            $("#listform").submit();
        }
        else{
            alert("请选择您要删除的内容!");
            return false;
        }
    }

    //批量排序
    function sorts(){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");
            return false;
        }
    }


    //批量首页显示
    function changeishome(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量推荐
    function changeisvouch(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){


            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量置顶
    function changeistop(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }


    //批量移动
    function changecate(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量复制
    function changecopy(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var i = 0;
            $("input[name='id[]']").each(function(){
                if (this.checked==true) {
                    i++;
                }
            });
            if(i>1){
                alert("只能选择一条信息!");
                $(o).find("option:first").prop("selected","selected");
            }else{

                $("#listform").submit();
            }
        }
        else{
            alert("请选择要复制的内容!");
            $(o).find("option:first").prop("selected","selected");
            return false;
        }
    }

</script>
</body>
</html>
