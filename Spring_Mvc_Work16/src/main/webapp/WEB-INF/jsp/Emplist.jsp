<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.4.js" type="text/javascript"></script>
    <script type="text/javascript">
        function selectAll(ids) {
            $(".emps:checkbox").each(function () {
                $(this).prop("checked", $(ids).prop("checked"));
            });
        }
    </script>
    <title>Title</title>
    <style type="text/css">
        td {
            width: 120px;
        }
    </style>
</head>
</head>
<body>
<div align="center">
    <h1 align="center">员工信息</h1>
    <a href="${pageContext.request.contextPath}/toAddEdit">
        <button type="button" class="layui-btn layui-bg-blue">添加</button>
    </a>
    <a href="${pageContext.request.contextPath}/deleteEmp">
        <button type="button" class="layui-btn layui-bg-blue">批量删除</button>
    </a>
</div>
<form>

    <table border="2" align="center">
        <tr>
            <td><input type="checkbox" id="ids" onclick="selectAll(this)"/></td>
            <td>ID</td>
            <td>姓名</td>
            <td>职位</td>
            <td>入职日期</td>
            <td>业绩</td>
            <td>奖金</td>
            <td>部门</td>
            <td>操作</td>
        </tr>

        <c:choose>
            <c:when test="${list !=null}">
                <c:forEach items="${list}" var="emp">
                    <td><input type="checkbox" class="emps" value="${emp.empNo}" name="empons[]"/></td>
                    <td>${emp.empNo}</td>
                    <td>${emp.eName}</td>
                    <td>${emp.job}</td>
                    <td>${fn:substring(emp.hireDate,0,10)}</td>
                    <td>${emp.sal}</td>
                    <td>${emp.comm}</td>
                    <td>${emp.department.dName}</td>
                    &nbsp;<td><a href="${pageContext.request.contextPath}/toAddEdit?empNo=${emp.empNo}">编辑</a>&nbsp;<a
                    href="${pageContext.request.contextPath}/delete?empNo=${emp.empNo}">删除</a></td>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
    </table>
</form>
</body>
</html>
