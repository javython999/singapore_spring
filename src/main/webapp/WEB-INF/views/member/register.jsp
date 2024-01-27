<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>싱가포르</title>
<script src="/resources/script/jquery-3.5.1.min.js" defer></script>
<script src="/resources/script/main.js" defer></script>
<style>
	* {
		margin: 0 auto;
	}
	
	a {
		text-decoration: none;
		color: inherit;
	}
	
	#wrap {
		width: 100vw;
		height: 100%;
		margin: 0 auto;
	}
	
	#header {
		padding-bottom: 50px;
	}
	#header > a {
		margin: 0 auto;
		display: flex;
	}
	#header > a > img {}
	#header > div {
		display: flex;
	}
	
	#regForm > form {
		width: 100vw;
		display: flex;
		flex-direction: column;
	}
	
	
	#contents {
		padding-top: 35%;
	}
	
	#contents> a {
		position: relative;
		padding-top: 20px;
	}
	
	
	#contents> a:hover > img,
	#contents> a:hover > h1 {
		transform: scale(0.9);
	}
	
	#contents > a > img,
	#contents > a > h1 {
		transition: transform 200ms ease-in;
	}
	
	#contents > a > img {
		width: 100vw;		
	}
	#contents > a > h1 {
		font-size: 1.4rem;
		color: white;
		position: absolute;
		left: 5vw;
		bottom: 5vw;
		background: rgba(5, 5, 5, 0.3);
		border-radius: 5px;
		z-index: 10;
	}
	
	footer {
		text-align: center;
		padding: 100px 0 50px 0;
	}
	
</style>
</head>
<body>
	<section id="wrap">
		<header id="header">
			<%@include file="/WEB-INF/views/common/header.jsp" %>
		</header>
		<section id="regForm">
			<form method="post" action="/member/insert" onsubmit="checkValue();">
				<input type="text" placeholder="아이디를 입력하세요." name="loginId" class="loginId">
				<div>　</div>
				<input type="password" placeholder="비밀번호를 입력하세요." name="loginPw" class="loginPw">
				<div>　</div>
				<input type="password" placeholder="비밀번호 확인." name="pwCheck" class="pwCheck">
				<div>　</div>
				<input type="text" placeholder="닉네임을 입력하세요." name="nickname" class="nickname">
				<div>　</div>
				<div>
				<input type="submit" value="가입">
				<button><a href="/index">취소</a></button>
				</div>
			</form>			
			
		</section>
		<footer>
			<%@include file="/WEB-INF/views/common/footer.jsp" %>
		</footer>
	</section>
</body>
</html>