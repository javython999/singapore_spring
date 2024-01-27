<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<ul>
	<c:forEach items="${boardList}" var="board" varStatus="loop">
		<li><a href="/board/${board.id}">${board.boardName}</a></li>
	</c:forEach>
</ul>