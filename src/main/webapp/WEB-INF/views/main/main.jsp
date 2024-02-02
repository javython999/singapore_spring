<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach items="${boardList}" var="board" varStatus="loop">
    <div>
        <a href="/board/${board.id}">
            <h1>
                    ${board.boardName}(${board.boardType})
                <i class="fas fa-star"></i>
                <fmt:formatNumber value="${starAvgList[loop.index]}" pattern=".00"/>
            </h1>
            <img src="/resources/img/boardCover/boardCover${board.id}.jpg" alt="${board.boardName}"/>
        </a>
    </div>
</c:forEach>
