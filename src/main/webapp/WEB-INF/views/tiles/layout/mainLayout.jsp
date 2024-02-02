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
                <img alt="banner1" src="/resources/img/banner/banner1.jpg">
                <img alt="banner2" src="/resources/img/banner/banner2.jpg">
                <img alt="banner3" src="/resources/img/banner/banner3.jpg">
                <img alt="banner4" src="/resources/img/banner/banner4.jpg">
                <img alt="banner5" src="/resources/img/banner/banner5.jpg">
            </section>
            <section id="contents">
                <tiles:insertAttribute name="content"/>
            </section>
            <tiles:insertAttribute name="footer"/>
        </section>
    </body>
</html>