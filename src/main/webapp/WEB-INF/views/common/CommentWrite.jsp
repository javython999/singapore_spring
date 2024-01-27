<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<hr>
<br>
	<c:choose>
		<c:when test="${sessionScope.user_nickname != null }">
			<form method="post" action="/board/${board.id}/comment">
				<div>
					<span>별점평가 : </span>
					<input type="radio" id="star1" name="star" value="1">
					<label for="star1"><i class="fas fa-star"></i></label>
					<input type="radio" id="star2" name="star" value="2">
					<label for="star2"><i class="fas fa-star"></i><i class="fas fa-star"></i></label>
					<input type="radio" id="star3" name="star" value="3">
					<label for="star3"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></label>
					<input type="radio" id="star4" name="star" value="4">
					<label for="star4"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></label>
					<input type="radio" id="star5" name="star" value="5" checked>
					<label for="star5"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></label>
				</div>
				<div>
					<textarea class="reply" name="content" placeholder="방문후기를 남겨주세요."></textarea>
				</div>
				<input type="submit" value="후기 남기기" onclick="checkValue()">
			</form>
		</c:when>
		<c:otherwise>
			<span>별점을 남기시려면 로그인하세요.</span>
			<br>
		</c:otherwise>
	</c:choose>
<br>