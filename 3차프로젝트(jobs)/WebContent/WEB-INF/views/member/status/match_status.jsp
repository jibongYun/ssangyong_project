<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%


   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>
<!-- 적용CSS -->
<link rel="stylesheet" href="/yaneodo/css/member/member-main.css">
<link rel="stylesheet" href="/yaneodo/css/member/member-menu.css">
<style>

</style>
</head>
<body>
<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
<div class="container">

    <div class="title">제안받기 현황</div>
    <div class="content">
        <div class="aside-nav-group" style="border-bottom: 0px;">
            
            <div class="aside-nav-header">나를 원하는 회사</div>
            <div id="item1" class="aside-nav-item-selected">전체<div class="aside-nav-label">0</div></div>
            <div id="item2" class="aside-nav-item">원해요<div class="aside-nav-label">0</div></div>
            <div id="item3" class="aside-nav-item">프로필 열람<div class="aside-nav-label">0</div></div>
            <div id="item4" class="aside-nav-item">받은 제안<div class="aside-nav-label">0</div></div>

        </div>

        <div id="appliedPosition" class="appliedPosition">

            <div class="status-company">
                <div class="status-check">
                    <span>총 1건</span> 
                    <div id="status-search">
                    <span class="glyphicon glyphicon-search"></span><input type="text" placeholder="회사/지원자명 검색">
                    </div>
                    <div style="clear: both;"></div>
                </div>
                <table id="statusTable" class="table table-striped ">
                    <tr>
                        <th>회사명</th>
                        <th>지역</th>
                        <th>일자</th>
                        <th>상태</th>
                    </tr>
                    <tr class="tableSel">
                        <td>카카오</td>
                        <td>앱개발</td>
                        <td>앱개발</td>
                        <td>2020-12-30</td>
                    </tr>

                    <!-- <tr>
                        <td colspan="5" style="text-align: center; padding-top: 60px; color:#ccc;"> 요청하신 검색자료가 없습니다.</td>
                    </tr> -->

            </div>
        </div>
    </div>
</div>    
</body>
</html>
