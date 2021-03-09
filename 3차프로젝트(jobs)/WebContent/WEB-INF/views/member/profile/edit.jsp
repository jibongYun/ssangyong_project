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
            margin-bottom: 100px;
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
            height: 400px;
            margin-top: 0px;
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
            margin: 30px 0px;
     
        }

        #box4 {
            padding: 20px 20px;
            height: auto;
            margin-bottom: 30px;
          
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
         
			<form method="POST" action="/yaneodo/member/profile/editok.do">

            <div id="box2" class="rightbox">
            
                <div class="form-title">학교·직장 등록</div>

                
                <div class="form-subtitle">학교</div>
                <input type="text" placeholder="학교입력"  class="form-control" name="school" value="${dto.school }">
                 <input type="text" placeholder="전공입력"  class="form-control"  name="major" value="${dto.major }">  


                <div class="form-subtitle">직장</div>
                <input type="text" placeholder="직장입력"  class="form-control" name="company" value="${dto.company }">
                

                <!-- <select class="item">
                    <option>이력서1</option>
                </select> -->
                    


                <div class="form-subtitle">간단소개글</div>
                <span style="color:#999; font-size:14px;">직무 내용, 경험, 목표 등을 추가해서 더욱 멋진 소개글을 작성해보세요.</span>
                <textarea class="form-control" style="height:100px; resize: none;" placeholder="간단 소개글을 작성하세요." ></textarea>
			
            </div>
	

            <div id="box3" class="rightbox">

                <div class="form-title">전문분야설정</div>

                <div class="form-subtitle">직군</div>
                <select class="form-control">
                    <option>개발</option>
                    <option>기타</option>
                </select>
               
                <div class="form-subtitle">직무</div>
                <select class="form-control">
                    <option>웹개발자</option>
                    <option>서버개발자</option>
                    <option>프론트엔드개발자</option>
                </select>
            
                <div class="form-subtitle">경력</div>
                <select class="form-control">
                    <option>신입</option>
                    <option>1년</option>
                    <option>2년</option>
                    <option>3년</option>
                    <option>4년</option>
                    <option>5년</option>
                    <option>6년</option>
                    <option>7년</option>
                    <option>8년</option>
                    <option>9년</option>
                    <option>10년이상</option>
                </select>
            
            </div>


            <div id="box4" class="rightbox">

       

                <div class="form-subtitle">현재 연봉</div>
                <input type="text" placeholder="" class="form-control">
               
                <div class="form-subtitle">스킬</div>
                <select class="form-control">
                    <option>java</option>
                    <option>javascript</option>
                    
                </select>
            
       
            </div>

            <div style="clear: both;"></div>   

         
			<button type="submit" class="btn btn-primary" style="float: right;" >작성완료</button>
			
			<input type="hidden" name="customerSeq" value="${dto.customerSeq }">
			</form>

    </section>


    
    <script>

    var btn1 = document.getElementById("btn-school");
    var child;

    btn1.onclick = function() {

        child = window.open("p02-1_school.html", "child", "width=400, height=300, left=100, top=100");

    }
    </script>

    
</body>
</html>