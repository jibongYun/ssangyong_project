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
<link rel="stylesheet" href="/yaneodo/css/member/resume.css">
<style>

</style>
</head>
<body>
<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
   <div class="container">
            <div class="title">최근 문서</div>
            <div class="resume-item">
                <div class="resume-box">
                    <label class="resumeWrite btn btn-default" type="button">
                        <a class="wrapper linkFont" href="/yaneodo/member/resume/resume_writeok.do">
                            <div class="box blue">
                                <i class="far fa-clone"></i>
                            </div>
                            <p>이력서 작성</p>
                        </a>
                    </label>
                    </div>

                 
                    <div class="resume-box">
                        
                        <label class="resumeWrite btn btn-default" type="button" for="uploadCV" >
                            <!-- <label for="uploadCV"for="uploadCV"> -->
                            <div class="wrapper">
                                <div class="box">
                                   
                                </div>
                                <p style="font-weight: lighter;">파일업로드</p>
                        
                            <!-- </label> -->
                            </lable>
                                <input type="file" id="uploadCV" style="display: none;"> 
                             </div>
                        
        
                        </div>
                        <c:if test="${empty list.size()}">
                        <div>
                        	<span>이력서를 작성해주세요</span>
                        </div>
                        
                        </c:if>
						<c:forEach items="${list}" var="dto">
                        <div class="resume-box" style="cursor: pointer;"onclick ="location.href='/yaneodo/member/resume/resume_write.do?rseq=${dto.resumeSeq}'">
                            <div class="resume-preview notcompleted">

                                <h3 id="resume-name" class="resume-name">${dto.orgfileName}</h3>
                                <p class="resume-date">작성일 : ${dto.writeDate}</p>

                            </div>
                            <div class="resume-info">

                                <span class="notcompleted">최종 수정일 : ${dto.editDate} </span>
                                <input type="button" class="btn btn-default more" value="더보기">

                            </div>
                            <div id="drop-down-menu" class="drop-down-menu" style="display: none;"  >
                                <ul>
                                    <li>
                                        <a class="title-change">이름변경</a>
                                    </li>
                                    <li>
                                        <a href="">다운로드</a>
                                    </li>
                                    <li>
                                        <a class="resume-delete">삭제</a>
                                    </li>
    
                                </ul>
                            </div>
                        </div>
					</c:forEach>
                        

                  
            </div>

        </div>            



        <!-- <div id="delete-background" class="delete-background container" stype="position:absolute">

            <div style="text-align: center; width: 200px; height: 100px; border: 1px solid #ddd; margin: 0px auto;">
                <div style="margin-top: 30px;">정말 삭제하시겠습니까?</div>
                <div>
                    <button class="btn btn-default">아니요</button>
                    <button class="btn btn-primary">네</button>
                </div>
            </div> -->

            <!-- <div class="check-delete-box" style="" >
                <div width="50" class="Content-zwkXZ delete-box">
                    <div class="resume-delete-modal-body Div-hTZHGu fEVoGZ">
                        <div><h3><span>이력서 Hyeseung Cho 5<br>삭제하시겠습니까?</span></h3></div>
                    </div>
                    <div class="resume-delete-button">
                        <button>취소</button><button>삭제</button>
                    </div>
                </div>
                <div class="Overlay-iWuiZb emhpxA"></div>
            </div> -->


        <script>

            // $(".resume-delete").click(function(){
            //     $(".check-delete-box").css("display","block");
            //     $(".Overlay-iWuiZb").addClass("emhpxA");

            // });

            // function changeTitle(){
            //     $(this).parent().parent().next().children(".resume-name")
            // }
           /*  var rseq = ${rseq};
            window.onload=function(){
            	
				
            	if(rseq == null || rseq ==""){
            		return;
            	} else{
            		location.href="/yaneodo/member/resume/resume_write.do?rseq="${rseq} "&name=" ${name} "&phone="escape(${phone});
            	}
            	
            }; */
            
          

             var flag=true;
           


             //더보기메뉴보이기
            $(".more").click(function(){
                
               
                if(flag) {
                    $(this).parent().next().css("display","block");
                } else {
                    $(this).parent().next().css("display","none");
                }

                 flag = !flag;

                event.cancelBubble = true;
                
            });

            $(window).click(function() {
                    $(".more").parent().next().css("display","none");
                    // flag = !flag;
                });

               

        </script>
</body>
</html>
