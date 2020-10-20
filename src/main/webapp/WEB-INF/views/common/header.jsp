<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<header id="header">
	<a href="/"><img src="/resources/img/logo/logo.png" alt="logo" /></a>
	<div id="headerMenu">
		<c:if test="${sessionScope.user_nickname != null }">
			<span>${sessionScope.user_nickname}님 반갑습니다.</span>
			<button><a href="/member/logout.do">로그아웃</a></button>
		</c:if>
		<c:if test="${sessionScope.user_nickname == null }">
			<form method="post" action="/member/login_check.do">
				<input type="text" name="id" placeholder="아이디"><input type="password" name="pw" placeholder="비밀번호">
				<input type="submit" value="로그인">
				<button><a href="/member/register">회원가입</a></button>
				</form>
		</c:if>
	</div>
</header>