<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	
	  <section class="container"> 
            
            <div class="title">MY야너두</div>
            <div id="customerInfo">
                <div id="customer">
                   
                    <dl id="info">
                      
                        <label for="customerPhoto" type="button" style="margin-top: -50px; margin-bottom: -30px;"> 
                            <div class="photoPic"" style="background-image: url('/yaneodo/images/member/man_01.png')">
                            	<div id="cameraIcon"> 
                                    <span class="glyphicon glyphicon-camera" style="margin-top: 5px;"></span>
                                </div>
                            </div>
                        </label>
                            <input type="file" id="customerPhoto" style="display: none;">
                           
                        <dt id="name">홍길동</dt>
                        <dd id="eamil">jhs9214@gmail.com</dd>
                        <dd id="tel">010-9388-9048</dd>
                    </dl>
                    <span class="edit">
                        <a class="editInfo" href="/yaneodo/member/myyaneodo/customer_edit.do">기본정보 수정</a>
                    </span>
                </div>
                
                <div class="secondMenu">
                        <a class="mMenus" href="#"><span>원해요</span> <strong>0</strong></a>
                        <a class="mMenus" href="#"><span>열람</span> <strong>0</strong></a>
                        <a class="mMenus" href="#"><span>받은 제안</span> <strong>0</strong></a>
                </div>
                <div id="account">
                    <a href="/yaneodo/member/myyaneodo/account.do">계정설정</a>
                </div>
            </div>

           

            <div id="right">
             
                <div id="status" class="table">
                    <div class="title2">지원현황</div>
                    <ul>
                    <li><a class="count" href="#">0<div class="state">지원 완료</div></a></li>
                    <li><a class="count" href="#">0<div class="state">서류 통과</div></a></li>
                    <li><a class="count" href="#">0<div class="state">최종 합격</div></a></li>
                    <li><a class="count" href="#">0<div class="state">불합격</div></a></li>

                    </ul>
                </div>
            </div>
            <div id="rightDown">
                <div id="recoPosition"  class="table">
                    <div class="title2">추천포지션</div>
               <div class="recoList">
                <div class="details">
                    <div><img src="snow.jpg" class="companyPic"></div>
                    <div class="desc">SCM 매니저</div>
                    <div class="desc sm">깃컴퍼니</div>
                </div>
                <div class="details">
                    <div><img src="snow.jpg" class="companyPic"></div>
                    <div class="desc">SCM 매니저</div>
                    <div class="desc sm">깃컴퍼니</div>
                </div>
                <div class="details">
                    <div><img src="snow.jpg" class="companyPic"></div>
                    <div class="desc">SCM 매니저</div>
                    <div class="desc sm">깃컴퍼니</div>
                </div>
                <div class="details">
                    <div><img src="snow.jpg" class="companyPic"></div>
                    <div class="desc">SCM 매니저</div>
                    <div class="desc sm">깃컴퍼니</div>
                </div>
                <div style="clear: both;"></div>
        	</div>
                </div>
            </div>
            <div style="clear: both;"></div>
         </div>
        </section>
	
	<scirpt>
	</scirpt>
</body>
</html>