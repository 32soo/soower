<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${employee!=null?'修改':'添加'}员工</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/${employee!=null?'editemp':'addemp'}" method="post">
    <p>${employee!=null?'修改':'添加'}员工</p>
    <input type="hidden" name="employee" value="${employee.empNo}">
    姓名&nbsp;<input type="text" value="${employee!=null?(employee.eName):''}" name="eName"
                     placeholder="请输入姓名"><br>
    职位&nbsp;<select name="job">
    <option value="销售员" ${employee!=null?(employee.job=='销售员'?"selected":""):""}>销售员</option>
    <option value="文员" ${employee!=null?(employee.job=='文员'?"selected":""):""}>文员</option>
    <option value="分析师" ${employee!=null?(employee.job=='分析师'?"selected":""):""}>分析师</option>
    <option value="经理" ${employee!=null?(employee.job=='经理'?"selected":""):""}>经理</option>
</select><br>
    <fmt:formatDate value="${now }" type="date" var="today" pattern="yyyy-MM-dd"/>
    入职时间&nbsp;<input type="datetime-local" name="hireDate" value="${employee!=null?(employee.hireDate):today}"><br>
    工资&nbsp;<input type="text" name="sal" value="${employee!=null?(employee.sal):''}" placeholder="请输入薪水"><br>
    奖金&nbsp;<input type="text" name="comm" value="${employee!=null?(employee.comm):''}" placeholder="请输入奖金"><br>
    部门&nbsp;<select name="deptno">
    <c:forEach items="${lists}" var="department">
        <option value="${department.deptNo}" ${employee!=null?(employee.department.dName==department.dName?"selected":""):""}>${department.dName}</option>
    </c:forEach>
</select><br>
    <input type="submit" value="提交">&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/list"><input type="button"
                                                                                                           value="取消"></a>
</form>
</body>
</html>
