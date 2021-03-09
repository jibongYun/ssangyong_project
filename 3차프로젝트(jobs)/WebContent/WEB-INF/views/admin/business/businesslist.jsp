<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>

    <link rel="stylesheet" href="/yaneodo/css/admin/admin-business.css">

</head>
<body>
	<!-- header -->
	<div id="header">
	
		<%@include file="/WEB-INF/views/admin/form/header.jsp" %>
	
	</div>
	<div style="clear:both;"></div>

    <div id="pageAll">
    
    	<%@include file="/WEB-INF/views/admin/inc/sidemenu.jsp" %>

        <section id="contents">
            <div id="businessManager">
                <div id="subtitle">기업회원 승인목록</div>
            </div>
            <div>
                <table id="businessList">
                    <thead>
                        <tr>
                            <th>기업사진</th>
                            <th>기업명</th>
                            <th>기업번호</th>
                            <th>기업메일</th>
                            <th>기업주소</th>
                            <th>가입 날짜</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="profile"><img src="../images/man_03.png" alt="기업"></td>
                            <td class="business-name">네이버웹툰컴퍼니</td>
                            <td class="business-tel">012-34-56789</td>
                            <td class="business-email">naver@naver.com</td>
                            <td class="business-address">경기 성남시 분당구 분당내곡로 177 9층</td>
                            <td class="business-regdate">2021-02-04</td>
                        </tr>
                        <tr>
                            <td class="profile"><img src="../images/man_02.png" alt="기업"></td>
                            <td class="business-name">네이버웹툰컴퍼니</td>
                            <td class="business-tel">012-34-56789</td>
                            <td class="business-email">naver@naver.com</td>
                            <td class="business-address">경기 성남시 분당구 분당내곡로 177 9층</td>
                            <td class="business-regdate">2021-02-04</td>
                        </tr>
                        <tr>
                            <td class="profile"><img src="../images/man_01.png" alt="기업"></td>
                            <td class="business-name">(주)카카오</td>
                            <td class="business-tel">123-45-67890</td>
                            <td class="business-email">kakao@daum.com</td>
                            <td class="business-address">제주 제주시 첨단로242</td>
                            <td class="business-regdate">2021-02-04</td>
                        </tr>
                        <tr>
                            <td class="profile"><img src="../images/man_03.png" alt="기업"></td>
                            <td class="business-name">엔에이치엔</td>
                            <td class="business-tel">144-81-15549</td>
                            <td class="business-email">nhn@nhn.co.kr</td>
                            <td class="business-address">경기 성남시 분당구 대왕판교로645번길 16</td>
                            <td class="business-regdate">2021-02-04</td>
                        </tr>
                        <tr>
                            <td class="profile"><img src="../images/man_03.png" alt="기업"></td>
                            <td class="business-name">(주)네오게임즈</td>
                            <td class="business-tel">135-79-13579</td>
                            <td class="business-email">neo@neo.com</td>
                            <td class="business-address">서울 마포구 월드컵북로396 801호</td>
                            <td class="business-regdate">2021-02-04</td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div style="clear: both;"></div>

            <nav class="pagebar">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </section>
        
    </div>
</body>
</html>