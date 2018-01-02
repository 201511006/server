<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>로그인</title>
</head>
<body>
	<form:form commandName="loginCommand">
	<form:errors element="div" />
		<label for="email"> 이메일 </label>: 
		<input type="text" name="email" id="email" value ="${loginCommand.email}">
		<form:errors path ="email" />
		</br>
		<label for="password"> 패스워드 </label>:
		<input type="password" name="password" id="password">
		<form:errors path ="password" />
		</br>
		<input type="submit" value="로그인" >
	</form:form>


</body>
</html>