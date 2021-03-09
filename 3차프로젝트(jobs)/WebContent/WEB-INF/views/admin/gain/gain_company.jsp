<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수익 관리</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>

<link rel="stylesheet" href="/yaneodo/css/admin/admin.css">
    

<style>

  	

        #tbl {
            width: 850px;
            height: 40px;
            text-align: center;
            margin : 90px auto;
        }
        
        #tbl th, #tbl td { 
            border-bottom: 2px solid #ccc;
            text-align: center;            
        }

        #content #search {
            width: 250px;
            float : right;
        }

        .searchbar {
            height: 30px;
            display:inline-block;
            float: left;
            line-height: 5px;
        }

	
	
</style>

</head>
<body>
	<!-- header -->
	<div id="header">
	<%@include file="/WEB-INF/views/admin/form/header.jsp" %>
	</div>
	<div style="clear:both;"></div>
	
	<div id = "outline">
	
			<div id="leftSide" style="float:left; background-color: white;">
			<%@include file="/WEB-INF/views/admin/inc/sidemenu.jsp" %>
			</div>
		
         <div id="content">

            <form method="GET" action="/yaneodo/admin/gain/gain_company_search.do" id="search">
                <input type="text" class="searchbar" name ="searchname" id="searchname" placeholder=" 이름">
                <input type="submit" value="검색" class="searchbar">
            </form>

            <table id=tbl>
                <thead>
                    <tr>
                        <th>순서</th>
                        <th>이름</th>
                        <th>a타입</th>
                        <th>b타입</th>
                        <th>c타입</th>
                        <th>d타입</th>
                        <th>e타입</th>
                        <th>사용한 열람 횟수</th>
                        <th>잔여 열람 가능 횟수</th>
                    </tr>
                </thead>
                <tbody id="tbd">
                <c:forEach items="${list}" var="one" varStatus="index">
                    <tr>
                        <td>${index.index+1}</td>
                        <td>${one.name}</td>
                        <c:choose>
						<c:when test="${empty one.a}"> 
	                        <td>0</td>
	                    </c:when>
	                    <c:otherwise>
	                    <td>${one.a}</td>	                    
	                    </c:otherwise>
	                    </c:choose>
	                    <c:choose>
						<c:when test="${empty one.b}"> 
	                        <td>0</td>
	                    </c:when>
	                    <c:otherwise>
	                    <td>${one.b}</td>	                    
	                    </c:otherwise>
	                    </c:choose>
                        <c:choose>
						<c:when test="${empty one.c}"> 
	                        <td>0</td>
	                    </c:when>
	                    <c:otherwise>
	                    <td>${one.c}</td>	                    
	                    </c:otherwise>
	                    </c:choose>
                        <c:choose>
						<c:when test="${empty one.d}"> 
	                        <td>0</td>
	                    </c:when>
	                    <c:otherwise>
	                    <td>${one.d}</td>	                    
	                    </c:otherwise>
	                    </c:choose>
                        <c:choose>
						<c:when test="${empty one.e}"> 
	                        <td>0</td>
	                    </c:when>
	                    <c:otherwise>
	                    <td>${one.e}</td>	                    
	                    </c:otherwise>
	                    </c:choose>
                        <c:choose>
						<c:when test="${empty one.used}"> 
	                        <td>0</td>
	                    </c:when>
	                    <c:otherwise>
	                    <td>${one.used}</td>	                    
	                    </c:otherwise>
	                    </c:choose>
                        <td>${(one.a*50)+(one.b*110)+(one.c*170)+(one.d*270)+(one.e*400) - (one.used)}</td>
                    </tr>
                </c:forEach>
                    
                </tbody>
            </table>

  
        </div>

    </div>

	
	<!-- footer -->
	<div id="footer" >
	<%@include file="/WEB-INF/views/admin/form/footer.jsp" %>
	</div>

</body>
</html>