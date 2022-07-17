<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Register new institution</title>
</head>
<body>
<form:form method="post" modelAttribute="institution">
    <div>
        <label for="name">Name</label>
        <form:input path="name" id="name" type="text"/>
        <form:errors path="name"/>
    </div>
    <div>
        <label for="description">Description</label>
        <form:input path="description" id="description" type="text"/>
        <form:errors path="description"/>
    </div>
    <div>
        <input type="submit">
    </div>
    <form:errors path="*"/>
</form:form><br>

<div>
    <a class="block" href="<%= request.getContextPath()%>..//">Back to homepage</a>
</div>
</body>
</html>
