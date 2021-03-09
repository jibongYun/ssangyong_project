<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/company/inc/asset.jsp"%>
<link rel="stylesheet" href="/yaneodo/css/company/position/add.css">
<style>
</style>
</head>
<body>

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/company/inc/header.jsp"%>
	<!-- ########## 상단 헤더 끝 -->

	<div id="container">
		<!-- section-heade -->
		<div class="section-header">
			<div class="container">
				<div class="row">
					<div class="col-md-9">
						<h1>모집공고 등록</h1>
					</div>
				</div>
			</div>
		</div>
		<!-- section-head end -->

		<!-- section-body -->
		<div class="section-body">
			<div class="container">
				<div class="row">
					<div class="col-md-2 title">제목</div>
					<div class="col-md-3 content">
						<input type="text" class="form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 title">공고 이미지</div>
					<div class="col-md-3 content">
						<input type="file" id="image" onchange="setThumbnail(event);">
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 title"></div>
					<div class="col-md-3 content">
						<div class="col-md-3" id="imageContainer"></div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 title">채용 직무</div>
					<div class="col-md-2 content">
						<select class="form-control" name="" id="">
							<option value="테스트">테스트</option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 title">태그 등록</div>
					<div class="col-md-3 content">
						<input type="button" class="btn btn-primary" value="태그 등록하기"
							data-toggle="modal" data-target="#addTag">
					</div>
				</div>
				<div class="row">
					<div class="col-md-9 tag">
						<span class="label label-primary">#선택<sapn
								class="glyphicon glyphicon-remove remove"></sapn>
						</span> <span class="label label-primary">#선택태<sapn
								class="glyphicon glyphicon-remove remove"></sapn>
						</span> <span class="label label-primary">#선택태그<sapn
								class="glyphicon glyphicon-remove remove"></sapn>
						</span> <span class="label label-primary">#선택태그명<sapn
								class="glyphicon glyphicon-remove remove"></sapn>
						</span> <span class="label label-primary">#선택된태그명<sapn
								class="glyphicon glyphicon-remove remove"></sapn>
						</span>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 title">마감일</div>
					<div class="col-md-3 content">
						<input type="text" class="form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 title">근무 지역</div>
					<div class="col-md-3 content">
						<input type="text" class="form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 title">모집 상세 내용</div>
				</div>
				<div class="row">
					<div class="col-md-11">
						<textarea class="form-control" name="" id="" cols="30" rows="10"></textarea>
					</div>
				</div>
			</div>
		</div>
		<!-- section-body end -->


		<div class="section-footer">
			<div>
				<a class="btn btn-primary">등록하기</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
					class="btn btn-default" onclick="history.back();">돌아가기</a>
			</div>
		</div>
	</div>
	<!-- container 끝 -->

	<!-- 태그등록 modal -->
	<div class="modal modal-center fade" id="addTag" tabindex="-1"
		role="dialog">
		<div class="modal-dialog modal-center modal-60size " role="document">
			<div class="modal-content modal-60size">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">태그 등록하기</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-5 input-group search">
							<input type="text" class="form-control"
								placeholder="검색할 태그명을 입력하세요" aria-describedby="basic-addon2"
								id="search" name="search" required> <span
								class="input-group-addon" style="cursor: pointer;"
								id="basic-addon2"><span
								class="glyphicon glyphicon-search"></span></span>
						</div>
					</div>
					<div class="row">
						<div class="search-result">
							<div class="title">검색 결과</div>
							<span class="label label-primary">#칼퇴보장</span> <span
								class="label label-primary">#간식</span> <span
								class="label label-primary">#커피</span> <span
								class="label label-primary">#50명이내</span> <span
								class="label label-primary">#스타트업</span> <span
								class="label label-primary">#중식</span> <span
								class="label label-primary">#이벤트</span> <span
								class="label label-primary">#태그입니다1</span> <span
								class="label label-primary">#태그입니다2</span>
						</div>
					</div>
					<div class="row">
						<div class="title">선택한 태그(최대 10개)</div>
						<div class="seleted-tag">
							<span class="label label-primary">#선택명<sapn
									class="glyphicon glyphicon-remove remove"> </sapn></span> <span
								class="label label-primary">#선택태<sapn
									class="glyphicon glyphicon-remove remove"> </sapn></span> <span
								class="label label-primary">#선택<sapn
									class="glyphicon glyphicon-remove remove"></sapn>
							</span> <span class="label label-primary">#선택태그<sapn
									class="glyphicon glyphicon-remove remove"> </sapn></span> <span
								class="label label-primary">#선택태그명<sapn
									class="glyphicon glyphicon-remove remove"> </sapn></span> <span
								class="label label-primary">#선택태그<sapn
									class="glyphicon glyphicon-remove remove"> </sapn></span> <span
								class="label label-primary">#선택태<sapn
									class="glyphicon glyphicon-remove remove"> </sapn></span> <span
								class="label label-primary">#선택<sapn
									class="glyphicon glyphicon-remove remove"></sapn>
							</span> <span class="label label-primary">#선택태<sapn
									class="glyphicon glyphicon-remove remove"> </sapn></span> <span
								class="label label-primary">#선택태그<sapn
									class="glyphicon glyphicon-remove remove"> </sapn></span>

						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-primary">등록완료</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->





	<!-- ########## 하단 푸터 시작 -->
	<%@include file="/WEB-INF/views/company/inc/footer.jsp"%>
	<!-- ########## 하단 푸터 끝 -->

	<script>

        var thumbnail = document.getElementById("imageContainer");

        function setThumbnail(event) {

            // alert(thumbnail.hasChildNodes())

            // 이미 선택된 이미지가 존재 한다면?
            if (thumbnail.hasChildNodes()) {
                // 삭제
                thumbnail.removeChild(thumbnail.firstChild);
            }
            ;
            var reader = new FileReader();

            reader.onload = function (event) {

                var img = document.createElement("img");
                img.setAttribute("src", event.target.result);
                img.style.width = 250 + "px";
                img.style.height = 250 + "px";
                img.style.border = "solid 1px #CCC"

                document.querySelector("div#imageContainer").appendChild(img);
            };

            reader.readAsDataURL(event.target.files[0]);
        }

    </script>
</body>
</html>