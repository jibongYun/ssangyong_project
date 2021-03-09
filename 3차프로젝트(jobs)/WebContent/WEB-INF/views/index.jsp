<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>yaneodo</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp"%>
<%@include file="/WEB-INF/views/member/auth/login.jsp"%>
<%@include file="/WEB-INF/views/main/search.jsp"%>

<link rel="stylesheet" href="/yaneodo/css/main/main.css">
<link rel="stylesheet" href="/yaneodo/css/main/search.css">
<!-- <link rel="stylesheet" href="/yaneodo/css/member/member-main.css"> -->
<link rel="stylesheet" href="/yaneodo/css/member/mainheader.css">
<link rel="stylesheet" href="/yaneodo/css/member/mainfooter.css">
<link rel="stylesheet" href="/yaneodo/css/member/login.css">


<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<script>

	$(document).ready(function(){
	    $('.slider').bxSlider();
	});

</script>

<style>
</style>
</head>
<body>

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/member/inc/header.jsp"%>
	<!-- ########## 상단 헤더 끝 -->

	<div id="slider">
		<ul class="bxslider">
			<li><img src="/yaneodo/images/mainSlider/random1.jpg" class="images"></li>
			<li><img src="/yaneodo/images/mainSlider/random2.jpg" class="images"></li>
			<li><img src="/yaneodo/images/mainSlider/random3.jpg" class="images"></li>
		</ul>
	</div>

	<div id="section">
		<div id="recommend">
			<div class="title">추천 공고</div>
			
			<c:if test="${not empty id}">
			
				<c:if test="${reclist.jobphoto.toLowerCase().endsWith('jpg') || reclist.jobphoto.toLowerCase().endsWith('gif') || reclist.jobphoto.toLowerCase().endsWith('png') }">
				<c:forEach items="${reclist}" var="reclist" varStatus="status">
					<div class="details">
						<a href="/yaneodo/jobnotice/view.do?seq=${newlist.jobOpeningSeq}">
							<img src="/yaneodo/images/jobopening/${reclist.jobPhoto}" class="companyPic">
						</a>
						<div class="desc">${reclist.job}</div>
						<div class="desc sm">${reclist.companyName}</div>
					</div>
				
				</c:forEach>
				
				<div style="clear: both;"></div>
		
		
			</c:if>	  
	            
            </c:if>
            
            
            
            <c:if test="${empty id}">
            
	            <c:forEach items="${newlist}" var="newlist" varStatus="status">
					<c:if test="${newlist.jobPhoto.toLowerCase().endsWith('jpg') || newlist.jobPhoto.toLowerCase().endsWith('gif') || newlist.jobPhoto.toLowerCase().endsWith('png') }">			
						<div class="details">
						
							<a href="/yaneodo/jobnotice/view.do?seq=${newlist.jobOpeningSeq}">
								<img src="/yaneodo/images/jobopening/${newlist.jobPhoto}" class="companyPic">
							</a>
							<div class="desc">${newlist.job}</div>
							<div class="desc sm">${newlist.companyName}</div>


						</div>
	
					 </c:if>   
				</c:forEach>
				
				<div style="clear: both;"></div>
		
		
			</c:if>	
			
					

		</div>




		<div id="new">
			<div class="title">신규 채용 회사</div>
			
			<c:forEach items="${newlist}" var="newlist" varStatus="status">
				<c:if test="${newlist.jobPhoto.toLowerCase().endsWith('jpg') || newlist.jobPhoto.toLowerCase().endsWith('gif') || newlist.jobPhoto.toLowerCase().endsWith('png') }">			
					<div class="details">
					
						<a href="/yaneodo/jobnotice/view.do?seq=${newlist.jobOpeningSeq}">
							<img src="/yaneodo/images/jobopening/${newlist.jobPhoto}" class="companyPic">
						</a>
						<div class="desc">${newlist.job}</div>
						<div class="desc sm">${newlist.companyName}</div>

					</div>

				 </c:if>   
			</c:forEach>
			
			<div style="clear: both;"></div>
			
		</div>
		
		

		<div id="theme">
			<div class="title">
				테마별 채용
<!-- 				<div class="arrowsSm">
					<span class="glyphicon glyphicon-menu-left"></span> <span
						class="glyphicon glyphicon-menu-right"></span>
				</div> -->
			</div>
			<div class="details">
				<div>
					<img src="/yaneodo/images/mainSlider/4work.png" class="themePic">
				</div>
				<div class="desc">주말 3일! 주 4일 근무 기업</div>
				<div class="desc sm">일과 삶의 균형을 찾을 수 있는 기업을 소개합니다.</div>
			</div>

			<div class="details">
				<div>
					<img src="/yaneodo/images/mainSlider/jataek.png" class="themePic">
				</div>
				<div class="desc">재택/원격 근무 활발한 기업</div>
				<div class="desc sm">장소에 구애받지 않고, 효율적으로 일하는 기업을 소개합니다.</div>
			</div>

			<div style="clear: both;"></div>
		</div>
	</div>





	<!-- ########## 푸터 시작 -->
	<%@include file="/WEB-INF/views/member/inc/footer.jsp"%>
	<!-- ########## 푸터 끝 -->


	<script>

		/* 슬라이더 */
        $(document).ready(function () {

            $('.bxslider').bxSlider({ // 클래스명 주의!
                auto: true, // 자동으로 애니메이션 시작
                speed: 1000,  // 애니메이션 속도
                pause: 2000,  // 애니메이션 유지 시간 (1000은 1초)
                mode: 'horizontal', // 슬라이드 모드 ('fade', 'horizontal', 'vertical' 이 있음)
                // autoControls: true, // 시작 및 중지버튼 보여짐
                // pager: true, // 페이지 표시 보여짐
                // captions: true, // 이미지 위에 텍스트를 넣을 수 있음
            });

        });


        $("#bSearchClose").click(function() {
            $("#searchBox1").hide();
            $("#headerContainer").show();
        });

		/* 검색창 */
        $(function(){
            $(document).mousedown(function( e ){
                if( $("#searchBox1").is(":visible") ) {
                    $("#searchBox1").each(function(){
                        var l_position = $(this).offset();
                        l_position.right = parseInt(l_position.left) + ($(this).width());
                        l_position.bottom = parseInt(l_position.top) + parseInt($(this).height());

                        if( ( l_position.left <= e.pageX && e.pageX <= l_position.right )
                            && ( l_position.top <= e.pageY && e.pageY <= l_position.bottom ) ) {
                        } else {
                            $(this).hide();
                        }
                    });

                $("#container").css("opacity", "1");
                
                }
            });
            
            $("#search").click(function(){
                if( !$("#searchBox1").is(":visible") ) {
                    $("#searchBox1").show();

                    $("#container").css("opacity", ".7");
                }
            });
        });
	    
	    
	</script>
</body>
</html>