<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<a name="commentList" />
<c:forEach var="list" items="${list }">
				<div class="UserComment">
					<span></span>
					<hr>
					<div>
					<br>
						<form method="post" action="/board/${boardName}/delete.do" class="commentContents${list.id}">
							${list.nickname}
							<div class="starScore">
								<c:choose>
								<c:when test="${list.star == 1 }">
									<i class="fas fa-star"></i>							
								</c:when>
								<c:when test="${list.star == 2 }">
									<i class="fas fa-star"></i><i class="fas fa-star"></i>						
								</c:when>
								<c:when test="${list.star == 3 }">
									<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i>						
								</c:when>
								<c:when test="${list.star == 4 }">
									<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i>					
								</c:when>
								<c:when test="${list.star == 5 }">
									<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i>						
								</c:when>
								</c:choose>
							</div>
							<input type="hidden" value="${list.id}" name="id"> <!-- comment ID  -->
							<div>${list.content}</div>
							<div><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd" /></div>
						</form>
						<c:if test="${sessionScope.user_nickname == list.nickname}">
						<br>
						<input type="button" value="수정" name="a" onclick="cmtModify(${list.id}, '${boardName}')"/>
						<input type="button" value="삭제" onclick="askDelete(${list.id})"/>
					</c:if>
						<div class="modify${list.id}"></div>
					</div>
				</div>
				</c:forEach>