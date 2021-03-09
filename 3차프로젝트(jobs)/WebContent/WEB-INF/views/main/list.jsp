<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp"%>
<%@include file="/WEB-INF/views/main/search.jsp"%>

<link rel="stylesheet" href="/yaneodo/css/member/mainheader.css">
<link rel="stylesheet" href="/yaneodo/css/main/list.css">
<link rel="stylesheet" href="/yaneodo/css/main/search.css">

<style>

</style>
</head>
<body>
	
	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/member/inc/header.jsp"%>
	<!-- ########## 상단 헤더 끝 -->
	
	
	
	<div id="content">
            <div id="submenu"><h1>${searchKey}</h1></div>

        <div id="searchCompany">

            <h3 id="ccount" style="font-size: 15px; float: left;">회사<span> ${clist.size()}</span></h3>
            <div class="arrowsSm" style="float: left;">
            </div>
            <div style="clear: both;"></div>

            <ul id="companyList" style="list-style: none;">
            
            <c:forEach items="${clist}" var="clist" varStatus="status">
            	<c:if test="${clist.companyPhoto.toLowerCase().endsWith('jpg') || clist.companyPhoto.toLowerCase().endsWith('gif') || clist.companyPhoto.toLowerCase().endsWith('png') }">
	                <li class="clist">
	                    <div class="">
	                        <img src="/yaneodo/images/company/${clist.companyPhoto}" style="float: left;" class="ppic">
	                        <div id=desc style="float:left; height:100px;">
	                        	<h2>${clist.companyName}</h2>
	                        	<h3>${clist.industry}</h3>
	                        </div>
	                        
	                        
	                    </div>
	                </li>
	                
	                <c:if test="${(status.index+1) % 2 == 0}">           
	                		<div style="clear: both;"></div>
					</c:if>

					</c:if>
            </c:forEach>
            
            	   <c:if test="${clist.size() % 2 == 1}">           
	                		<div style="clear: both;"></div>
					</c:if>
            

			</ul>
			
			
				<c:if test="${clist.size() == 0}">
					<div style="width: 400px; padding: 100px; margin: 0px auto; text-align: center;">검색 결과가 없습니다.</div>
                </c:if>

        </div>


        <div id="searchPosition">

            <h3 id="jcount" style="font-size: 15px;">포지션<span> ${jlist.size()}</span></h3>


			<ul id="positionList" style="list-style: none;">
				 <c:forEach items="${jlist}" var="jlist" varStatus="status">
				 	<c:if test="${jlist.jobPhoto.toLowerCase().endsWith('jpg') || jlist.jobPhoto.toLowerCase().endsWith('gif') || jlist.jobPhoto.toLowerCase().endsWith('png') }">
						
		                <li class="plist" style="float: left;">
		                	
		                    <div>
		                    <a href="/yaneodo/jobnotice/view.do?seq=${jlist.jobOpeningSeq}">
		                    <img src="/yaneodo/images/jobopening/${jlist.jobPhoto}" class="ppic">
		                    </a>
		                    </div>
		                    <div class="desc">${jlist.job}</div>
		                    <div class="desc sm">${jlist.companyName}</div>
			                <div class="desc sm">${jlist.place}</div>

		                </li>
		                
		                <c:if test="${(status.index+1) % 4 == 0}">           
	                		<div style="clear: both;"></div>

						</c:if>
	             	</c:if>
	            </c:forEach>
			</ul>


			<c:if test="${jlist.size() == 0}">
				<div style="width: 400px; padding: 100px; margin: 0px auto; text-align: center;">검색 결과가 없습니다.</div>
			</c:if>


		</div>

    </div>
    
	<script>
		
	</script>
</body>
</html>