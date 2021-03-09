<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp"%>

<!-- 적용CSS -->
<link rel="stylesheet" href="/yaneodo/css/member/member-main.css">
<link rel="stylesheet" href="/yaneodo/css/member/member-menu.css">
<link rel="stylesheet" href="/yaneodo/css/member/layout-profile.css">

    
    <style>
        
      
        /*메인내용*/
        #container{
            width:1050px;
            margin: 0px auto;
            margin-top: 80px;
        }

        #container .title{
            margin: 20px 0px;
            font-weight: bold;
            font-size: 20px;
        }

       
        #customerInfo{
            width: 250px;
            height: 700px;
            background-color:white;
            float: left;

        }

        /*왼쪽 회원정보(프로필)*/
        #info{
            text-align: center;
            margin-top: 60px;
            margin-bottom: 60px;
        }

        #info dt{
            font-size: 18px;
            margin-top: 50px;
            margin-bottom: 30px;
        }

        #info dd{
            color:#999999;
        }

       
        .edit #editInfo{
            font-size: 1.1em;
            color:black;
            padding: 10px 50px;
            border: 1px solid #eee;
            border-radius: 30px;
            margin:0px 30px;
        }
        .edit #editInfo:hover {
            color: black;
            text-decoration: none;
            background-color: #eee;
        }
        #customer{
            width: 250px;
            height: 300px;
            border-bottom:1px solid #eee ;

        }

        #secondMenu{
            width: 250px;
            height: 200px;
            margin-top: 50px;
            border-bottom:1px solid #eee ;
        }

        .mMenus{
            width: 200px;
            height: 30px;
            margin: 30px 30px;
            display: block;
            font-size: 16px;
            color: #999999;
          
        }

        .mMenus:hover{
            color: #999999;
            text-decoration: none;
        }


        .mMenus strong{
            /* display: inline-block; */
            float: right;
            color:black;
        }

        #account{
            margin: 30px 30px;
        }

        #account a{
            color: black;
            font-size: 16px;
        }

        #account a:hover{
            color:black;
            text-decoration: none;
        }


        
        /*내용*/

        .rightbox {
            width: 770px;
            background-color: white;
            float:right;
            font-size: 15px;
        }

        #box1{
            height: 70px;
            padding: 20px 20px;
        }

        #box1>span {
            color: red;
        }

 
        #box2{
            height: 350px;
            margin-top: 30px;
            padding: 20px 20px;
        }

        .form-title {
            font-size: 1.2em;
            font-weight: bold;
            margin-bottom: 20px;
            
        }

        .form-subtitle {
            margin: 10px 0px;
        }

        .item {
            margin-left: 30px;
            margin-bottom: 10px;
        }
        
        .underline-box {
            display: inline-block;
            border-bottom: 1px solid #444;
            width : 100px;
            text-align: center;
        }


        #box3 {
            padding: 20px 20px;
     
            height: auto;
  
            margin: 20px 0px;
     
        }

        #box4 {
            padding: 20px 20px;

            height: auto;
            
            margin: 20px 0px;
          
        }



 
    </style>



</head>
<body>

  	  
	<!-- 상단헤더 -->
	<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
	<!-- 상단헤더 -->

  	



   	<section id="container"> 


		<!-- 왼쪽 사이드 메뉴 -->
		
       <div class="title">프로필</div>

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

		<!-- 왼쪽 사이드 메뉴 -->
      



       <div id="rightContainer">
        
           <div id="box1" class="rightbox"> 

               <span>입력을 완료하면 매치업 등록이 가능합니다. </span>
               <input type="button" value="입력하기" style="float:right;" class="btn btn-default" 
               onclick="location.href='/yaneodo/member/profile/edit.do?seq=${dto.customerSeq}'">
               
           </div>
      

           <div id="box2" class="rightbox">

               <div class="form-title">기본 이력서</div>
               
               <div class="form-subtitle">기본 이력서 선택</div>

               <div>
                   <select class="item">
                       <option>이력서1</option>
                   </select>
               </div>

               <div class="form-subtitle">학교</div>
                   <div class="item underline-box" style="color:red">${dto.school }</div>
                   <div class="item underline-box" style="color:red">${dto.major }</div>
               <div class="form-subtitle">직장</div>
                   <div class="item underline-box">${dto.company }</div>
                   
               <div class="form-subtitle">간단소개글</div>
                   <div class=item> </div>

           </div>



           <div id="box3" class="rightbox">

               <div class="form-title">전문분야설정</div>

               <div class="form-subtitle">직군</div>
               <div class="item underline-box">학교 미입력</div>
  
               <div class="form-subtitle">직무</div>
               <div class="item underline-box">직장 미입력</div>
           
               <div class="form-subtitle">경력</div>
               <div class="item underline-box">직장 미입력</div>
           
           </div>


           <div id="box4" class="rightbox">

               <div>
                   <div class="form-subtitle" style="float:left; margin-right:30px;">제외기업 설정</div>
                   <input type="button" value="선택하기" style="margin-top:6px;">

                   <div style="clear: both;"></div>
               </div>


               <div style="float:left;">
                   <div class="form-subtitle" style="float:left; margin-right:30px;">구직여부 설정</div>
                  
                   <select class="item form-control" style="width: 300px; margin: 6px 0px; margin-right: 30px; float:left;">
                       <option>관심없음</option>
                       <option>관심있음</option>
                       <option>현재 구직중</option>
                   </select>

                   <div style="float:left; margin-top: 10px;">이력서 비공개</div>           
               </div>

           </div>


           <div style="clear: both;"></div>

       </div>

       




   </section>

    
</body>
</html>