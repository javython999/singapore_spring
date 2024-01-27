<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<header id="header">
	<a href="/"><img src="/resources/img/logo/logo.png" alt="logo" /></a>
	<div id="headerMenu">
		<c:choose>
			<c:when test="${sessionScope.user_nickname != null }">
				<span>${sessionScope.user_nickname}님 반갑습니다.</span>
				<button><a href="/member/logout">로그아웃</a></button>
			</c:when>
			<c:otherwise>
				<form method="post" action="/member/login">
					<input type="text" name="loginId" placeholder="아이디"><input type="password" name="loginPw" placeholder="비밀번호">
					<button type="submit">로그인</button>
					<button type="button"><a href="/member/register">회원가입</a></button>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</header>