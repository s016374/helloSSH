<%--
  Created by IntelliJ IDEA.
  User: s016374
  Date: 15/8/5
  Time: 上午9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<h3>employee list</h3>
<s:if test="#employee.id == null">
    No result.
</s:if>
<s:else>
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <td>ID</td>
            <td>Birth</td>
            <td>CreateTime</td>
            <td>email</td>
            <td>department</td>
            <td>DELETE</td>
        </tr>

        <s:iterator value="employeeList" var="employee">
            <tr>
                <td><s:property value="#employee.id" /></td>
                <td><s:property value="#employee.birth" /></td>
                <td><s:property value="#employee.createTime" /></td>
                <td><s:property value="#employee.email" /></td>
                <td><s:property value="#employee.department.departmentName" /></td>
                <td><a href="emp-delete.action?id=${employee.id}">delete</a></td>
            </tr>
        </s:iterator>
        <%--<s:iterator value="#employeeList">--%>
            <%--<tr>--%>
                <%--<td>${id}</td>--%>
                <%--<td>${birth}</td>--%>
                <%--<td>${createTime}</td>--%>
                <%--<td>${email}</td>--%>
                <%--<td>${department.departmentName}</td>--%>
                <%--<td><a href="emp-delete.action?id=${id}">delete</a> </td>--%>
            <%--</tr>--%>
        <%--</s:iterator>--%>
    </table>
</s:else>
</body>
</html>
