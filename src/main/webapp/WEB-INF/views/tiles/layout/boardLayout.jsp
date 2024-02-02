<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title><tiles:insertAttribute name="title" /></title>
        <tiles:insertAttribute name="style"/>
        <tiles:insertAttribute name="script"/>
    </head>
    <body>
        <section id="wrap">
            <i class="far fa-arrow-alt-circle-up upbtn"></i>
            <tiles:insertAttribute name="header"/>
            <tiles:insertAttribute name="nav"/>
            <section id="banner">
                <div>
                    <img src="/resources/img/boardCover/boardCover${board.id}.jpg" alt="ChinaTown"/>
                    <span class="starAVG"><i class="fas fa-star"></i><fmt:formatNumber value="${starAVG}" pattern=".00"/> / 5</span>
                </div>
            </section>
            <section id="contents">
                <tiles:insertAttribute name="content"/>
                <tiles:insertAttribute name="commentWrite"/>
                <tiles:insertAttribute name="commentList"/>
            </section>
            <tiles:insertAttribute name="footer"/>
        </section>
    </body>
</html>