<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<a id="commentList"></a>
<c:forEach var="comment" items="${commentList }">
	<div class="UserComment">
		<span></span>
		<hr>
		<div>
			<br>
			<form method="post" action="/board/${boardName}/delete.do" class="commentContents${comment.id}">
				${comment.nickname}
				<div class="starScore">
					<c:choose>
						<c:when test="${comment.star == 1 }">
							<i class="fas fa-star"></i>
						</c:when>
						<c:when test="${comment.star == 2 }">
							<i class="fas fa-star"></i><i class="fas fa-star"></i>
						</c:when>
						<c:when test="${comment.star == 3 }">
							<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i>
						</c:when>
						<c:when test="${comment.star == 4 }">
							<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i>
						</c:when>
						<c:when test="${comment.star == 5 }">
							<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i>
						</c:when>
					</c:choose>
				</div>
				<input type="hidden" value="${comment.id}" name="id"> <!-- comment ID  -->
				<div>${comment.content}</div>
				<div>
					<fmt:parseDate value="${ comment.regDateTime }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
					<fmt:formatDate value="${parsedDateTime}" pattern="yyyy-MM-dd" />
				</div>
			</form>
		</div>
	</div>
</c:forEach>