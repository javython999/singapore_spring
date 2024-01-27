<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>싱가포르</title>
	<script src="/resources/script/jquery-3.5.1.min.js" defer></script>
	<script src="/resources/script/main.js" defer></script>
	<script src="/resources/script/bannerSlide.js" defer></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<style>
		* {
			margin: 0 auto;
		}

		ul, li {
			list-style: none;
			padding: 0;
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
			padding-bottom: 10px;
		}
		#header > a {
			margin: 0 auto;
			display: flex;
		}
		#header > a > img {}
		#header > div {
			display: flex;
		}

		#banner {
			width: 100vw;
			display: block;
			position: relative;
		}

		ul {
			width: 100vw;
			display: flex;
			justify-content: space-evenly;
			padding-bottom: 10px;
		}

		ul > li {
			width: 25%;
			border: 1px solid #0e6a61;
			text-align: center;
			display: block;
		}

		ul > li:hover {
			background: #0e6a61;
			color: white;
		}

		ul > li > a {
			display: block;
		}

		#banner > img {
			display:block;
			width: 100%;
			position: absolute;
			top: 0;
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
			border-radius: 30px;
		}

		#contents > a > img,
		#contents > a > h1 {
			transition: transform 200ms ease-in, border-radius 200ms ease-in;
		}

		#contents > a > img {
			width: 100vw;
		}
		#contents > a > h1,
		#contents > a > h2 {
			font-size: 1.4rem;
			color: white;
			position: absolute;
			background: rgba(5, 5, 5, 0.3);
			border-radius: 5px;
			z-index: 10;
			left: 5vw;
			bottom: 5vw;
		}

		footer {
			text-align: center;
			padding: 100px 0 50px 0;
		}

		.upbtn {
			position: fixed;
			bottom: 50px;
			right: 50px;
			z-index: 100;
			font-size: 2rem;
			color: #0e6a61;
			opacity: 0;
			transition: opacity 250ms ease-in;
			pointer-events: none;
		}

		.upbtn.visible {
			opacity: 1;
			pointer-events: auto;
			cursor: pointer;
		}

	</style>
</head>
<body>
<section id="wrap">
	<i class="far fa-arrow-alt-circle-up upbtn"></i>
	<header id="header">
		<%@include file="/WEB-INF/views/common/header.jsp" %>
	</header>
	<nav>
		<%@include file="/WEB-INF/views/common/nav.jsp" %>
	</nav>
	<section id="banner">
		<img alt="banner1" src="/resources/img/banner/banner1.jpg">
		<img alt="banner2" src="/resources/img/banner/banner2.jpg">
		<img alt="banner3" src="/resources/img/banner/banner3.jpg">
		<img alt="banner4" src="/resources/img/banner/banner4.jpg">
		<img alt="banner5" src="/resources/img/banner/banner5.jpg">
	</section>
	<section id="contents">
		<c:forEach items="${boardList}" var="board" varStatus="loop">
			<a href="/board/${board.id}">
				<h1>${board.boardName}(${board.boardType}) <i class="fas fa-star"></i><fmt:formatNumber value="${MarinaStarAVG}" pattern=".00"/></h1>
				<img src="/resources/img/boardCover/boardCover${board.id}.jpg" alt="${board.boardName}"/>
			</a>
		</c:forEach>
	</section>
	<footer>
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
	</footer>
</section>
</body>
</html>