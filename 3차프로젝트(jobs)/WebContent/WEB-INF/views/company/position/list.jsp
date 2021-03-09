<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/company/inc/asset.jsp"%>
<link rel="stylesheet" href="/yaneodo/css/company/position/list.css">
<style>
</style>
</head>
<body>

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/company/inc/header.jsp"%>
	<!-- ########## 상단 헤더 끝 -->

	 <div id="container">
        <!-- section-heade -->
        <div id="section-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-5"><h1>등록된 모집 공고</h1></div>
                    <div class="btn btn-primary col-md-offset-5" onclick="location.href='/yaneodo/company/position/add.do'";>모집공고 등록하기</div>
                </div>
            </div>
        </div>
        <!-- section-heade end -->
    
    
        <!-- section-body -->
        <div id="section-body">
            <div class="row">
                <div class="col-md-4" >
                  <div class="thumbnail position-item" onclick="location.href='/yaneodo/company/position/view.do'">
                    <img src="/yaneodo/images/company/matchup_image.jpg" alt="...">
                    <div class="caption">
                      <h3>Android developer</h3>
                      <p>내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내</p>
                      <p><a href="#" class="btn btn-primary" role="button">수정하기</a> <a href="#" class="btn btn-default" role="button">삭제하기</a></p>
                    </div>
                  </div>
                </div>
                <div class="col-md-4" >
                  <div class="thumbnail position-item" onclick="location.href='/yaneodo/company/position/view.do'">
                    <img src="/yaneodo/images/company/matchup_image.jpg" alt="...">
                    <div class="caption">
                      <h3>Android developer</h3>
                      <p>내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내</p>
                      <p><a href="#" class="btn btn-primary" role="button">수정하기</a> <a href="#" class="btn btn-default" role="button">삭제하기</a></p>
                    </div>
                  </div>
                </div>
                <div class="col-md-4" >
                  <div class="thumbnail position-item" onclick="location.href='/yaneodo/company/position/view.do'">
                    <img src="/yaneodo/images/company/matchup_image.jpg" alt="...">
                    <div class="caption">
                      <h3>Android developer</h3>
                      <p>내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내</p>
                      <p><a href="#" class="btn btn-primary" role="button">수정하기</a> <a href="#" class="btn btn-default" role="button">삭제하기</a></p>
                    </div>
                  </div>
                </div>
                  <div class="col-md-4 position-item" >
                    <div class="thumbnail finished">
                      <img src="/project/views/image/matchup_image.jpg" alt="...">
                      <div class="caption">
                        <h3>Android developer</h3>
                        <p>내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내내용내</p>
                        <p><a href="#" class="btn btn-primary" role="button">수정하기</a> <a href="#" class="btn btn-default" role="button">삭제하기</a> </p>
                      </div>
                    </div>
                  </div>
              </div>
        </div>
        <!-- section-body end -->

    </div>



	<!-- ########## 푸터 시작 -->
	<%@include file="/WEB-INF/views/company/inc/footer.jsp"%>
	<!-- ########## 푸터 끝 -->

	<script>

	</script>
</body>
</html>