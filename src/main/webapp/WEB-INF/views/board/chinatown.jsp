<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>싱가포르</title>
<script src="/resources/script/jquery-3.5.1.min.js" defer></script>
<script src="/resources/script/main.js" defer></script>
<script src="/resources/script/board.js" defer></script>
<script src="/resources/script/video.js" defer></script>
<script src="https://kit.fontawesome.com/f87cacf99d.js" crossorigin="anonymous"></script>

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
	
	#banner {
		width: 100vw;
		height: 100%;
		display: block;
		position: relative;
	}
	
	#banner > div > img {
		display:block;
		width: 100vw;
	}
	#banner > div {
		width: 100vw;
	}
	
	#banner > div > .starAVG {
		z-index: 5rem;
		position: absolute;
		bottom: 10px;
		left: 6vw;
		font-size: 40px;
		color: white;
	}
	
	#contents {
		margin: 0 auto;
	}
	
	.dom {
		width: 50vw;
		float: left;
	}
	
	#contents > article {
		width: 100vw;
		padding-top: 80px;
		text-align: center;
	}
	
	#contents > article > img,
	#contents > article > div > img {
		width: 100vw;
		text-align: center;
	}
	
	.pic1 {
		width: 100vw;
		border-radius: 5px;
	}
	
	.pic1 > img {
		width: 50vw;
		float: left;
	}
	
	.clear {
		content: "";
		clear: both;
		display: block;s
	}
	
	#contents > article > h1,
	#contents > article > h3,
	#contents > article > div > h1,
	#contents > article > div > h3 {
		width: 90vw;
	}
	
	.reply {
		width: 70vw;
		height: 10vh;
	}
	
	.commentSection {
		padding-top: 30px;
		text-align: center;
	}
	
	.commentList {
		text-align: center;
	}
	
	
	.UserComment {	
		width: 70vw;
		padding-bottom: 10px;
	}
	
	.starScore {
		color: blue;
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
			<div>
			<img src="/resources/img/ChinaTown/ChinaTown.jpg" alt="ChinaTown"/>
			<span class="starAVG"><i class="fas fa-star"></i><fmt:formatNumber value="${starAVG}" pattern=".00"/> / 5</span>
			</div>
		</section>
		<section id="contents">
			<article>
				<%@include file="/WEB-INF/views/article/chinatown.jsp" %>
			</article>
			<section class="commentSection">
				<%@include file="/WEB-INF/views/common/CommentWrite.jsp" %>
			</section>	
			<section class="commentList">
				<%@include file="/WEB-INF/views/common/CommentList.jsp" %>
			</section>		
		</section>
		<footer>
			<%@include file="/WEB-INF/views/common/footer.jsp" %>
		</footer>
	</section>
</body>
</html>