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
 <section class="container" > 
        <div class="title">프로필</div>
        <div id="customerInfo" style="height: 640px;">
            <div id="customer">
                <dl id="info">
  					<label for="customerPhoto" type="button" style="margin-top: -50px; margin-bottom: -30px;">
  					${dto.photo}
  					    <c:if test="${empty dto.photo}">
                            <div class="photoPic"" style="background-image: url('/yaneodo/images/member/man_01.png')">a
                        </c:if> 
  						<c:if test="${not empty dto.photo}">
                            <div class="photoPic"" style="background-image: url('/yaneodo/images/member/${dto.photo}')">b
                         </c:if>

                         
                            	<div id="cameraIcon"> 
                                    <span class="glyphicon glyphicon-camera" style="margin-top: 5px;"></span>
                                </div>
                            </div>
                        </label>
                            <input type="file" id="customerPhoto" style="display: none;">
                         
                        <dt id="name">${dto.name}</dt>
                        <dd id="eamil">${dto.email}</dd>
                        <dd id="tel">${dto.phone}</dd>
                    </dl>
                    <span class="edit">
                        <a class="editSel" href="/yaneodo/member/myyaneodo/myyaneodo.do">기본정보 수정</a>
                    </span>
                </div>
                
                <div class="secondMenu">
                        <a class="mMenus" href="#"><span>원해요</span> <strong>0</strong></a>
                        <a class="mMenus" href="#"><span>열람</span> <strong>0</strong></a>
                        <a class="mMenus" href="#"><span>받은 제안</span> <strong>0</strong></a>
                </div>
               
            </div>

       

        <div id="infoEditContainer">
         
            <div id="infoEdit" class="table">
                <div class="title2">기본정보 수정</span></div>
                <form id="editForm" method ="GET" action ="/yaneodo/member/myyaneodo/customer_editok.do" >
		            <div class="FormBlock-content content">
		                <label for="name" class="infomations"><h6>이름</h6><input style="width:200px;" id="name" name="name" type="text" autocomplete="off" value="${dto.name}">
		                </label> 
		                <label for="nickName" class="infomations"><h6>별명</h6><input style="width:200px;" id="nickName" name="nickName" type="text" autocomplete="off" value="${dto.nickName}">
		                </label><input type="button" id="btnNick" class="btn btn-default" value="중복확인"><span id="checkNick"></span>
		                <label for="birth" class="infomations"><h6>생년월일</h6><input style="width:200px;" id="birth" name="birth" type="date" autocomplete="off" value="${dto.birth}">
		                </label>
		                <div class="infomations"><h6>연락처</h6><div class="MobileInput-body">
		                   <input  style="width:200px;" id="phone" name="phone" class="MobileInput-text" type="text" placeholder="(예시) 01034567890" value="${dto.phone}">
		                        </div>
		                    </div>
		                </div>
		                <div class="footerButton">
		                    <button id="btnSubmit" type="submit" >확인</button>
		             </div>
                </form>
            </div>
            
        </div>
       
    </section>

	<script>
	
 	$("#btnNick").click(function(){
		
		$.ajax({
			type:"GET",
			url:"/yaneodo/member/myyaneodo/customer_editdata.do",
			//data:"key=value & key=value & key=value"
			data:"nickName=" + $("#nickName").val(),
			success:function(checkNick){
				//콜백 함수
				//console.log(checkNick);
				if(checkNick == 1){
					$("#checkNick").css("color","red");
					$("#checkNick").text("이미 사용중인 닉네임 입니다.");
					$("#btnSubmit").attr("disabled",true);
					$("#btnSubmit").css("background-color","#DDD");
				} else{
					$("#checkNick").css("color","blue");
					$("#checkNick").text("사용가능한 닉네임 입니다.");
					$("#btnSubmit").attr("disabled",false);
					$("#btnSubmit").css("background-color","#258bf7");
				}
			},
			error : function(a,b,c){
				console.log(a,b,c);
			}
		});
		
	});
 	
 
	 
	</script>
</body>
</html>