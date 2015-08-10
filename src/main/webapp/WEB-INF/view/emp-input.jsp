<%--
  Created by IntelliJ IDEA.
  User: s016374
  Date: 15/8/6
  Time: 下午2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input Info</title>
</head>
<body>
<s:debug/>
<h4>Input Info</h4>

<s:form action="emp-save" method="POST">
  <s:textfield name="lastName" label="Last Name"></s:textfield>
  <s:textfield name="email" label="Email"></s:textfield>
  <s:textfield name="birth" label="BirthDay"></s:textfield>
  <%--<s:select list="#request.departments" listKey="id" listValue="departmentName" name="department.id" label="Department"></s:select>--%>
  <s:select list="#request.departments" label="Department" name="department.id"></s:select>
  <%--<s:select list="#{1:'aa',2:'bb',3:'cc'}"  label="abc" listKey="key" listValue="value"  headerKey="0" headerValue="aabb"/>--%>
  <s:submit></s:submit>
</s:form>
</body>
</html>
