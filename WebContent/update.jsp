<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
<input type="hidden" name="student.id" value="${student.id }">
		<input type="hidden" name="currentPage" value="${currentPage }">
		<input type="hidden" name="qname" value="${qname }">
		<input type="hidden" name="qusername" value="${qusername }">
		<input type="hidden" name="qsex" value="${qsex }">
		姓名：<input type="text" name="student.name" value="${student.name}"><br/>
		用户：<input type="text" name="student.username" value="${student.username}"><br/>
		密码：<input type="password" name="student.password" value="${student.password}"><br/>
		性别：<input type="radio" value="1" name="student.sex" value="${student.sex}" checked="checked" >男
			<input type="radio" value="0" name="student.sex" value="${student.sex}"  >女<br/>
		年龄：<input type="text" name="student.age" value="${student.age}"><br/>
		生日：<input type="date" name="student.birthday" value="<fmt:formatDate value="${student.birthday }" pattern="yyyy-MM-dd"/>"><br/>
			<input type="submit" value="提交"><br/>
	</form>
</body>
</html>