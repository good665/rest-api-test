<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/basic.js"></script>
    <title>shop</title>
	<jsp:include page="layouts/header.jsp"></jsp:include>
</head>

<body>
	<c:choose>
	<c:when test="${not empty email}">
		<jsp:include page="layouts/user-navigation.jsp"></jsp:include>
		<jsp:include page="layouts/user-menu.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<jsp:include page="layouts/navigation-bar.jsp"></jsp:include>
		<jsp:include page="layouts/menu.jsp"></jsp:include>
	</c:otherwise>
</c:choose>
	<!-- banner-2 -->
	<div class="page-head_agile_info_w3l"></div>
	<!-- //banner-2 -->
	<!-- page -->
	<div class="services-breadcrumb">
		<div class="agile_inner_breadcrumb">
			<div class="container">
				<ul class="w3_short">
					<li>
						<a href="${pageContext.request.contextPath}/home">Home</a>
						<i>|</i>
					</li>
					<li>Select Shop</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- //page -->
<!-- log in -->
	<br>
<!-- about -->
	<div class="welcome py-sm-5 py-4">
		<div class="container py-xl-4 py-lg-2">
			<!-- tittle heading -->
			<h3 class="tittle-w3l text-center mb-lg-5 mb-sm-4 mb-3">

			<!-- //tittle heading -->
			<div class="header">
				Select Shop
				<div class="site-info">
					<p>원하는 상품을 검색하고 나의 최저가를 설정하세요!🙌</p>
					<p>상품 가격이 나의 최저가 보다 낮을 경우 최저가 표시로 알려드려요😊</p>
				</div>
			</div>
			<div class="nav">
				<div class="nav-see active">
					모아보기
				</div>
				<div class="nav-search">
					탐색하기
				</div>
			</div>
			<div id="see-area">
				<div id="product-container">
				</div>
			</div>
			<div id="search-area">
				<div>
					<input type="text" id="query">
					<!-- <img src="${pageContext.request.contextPath}/images/icon-search.png" alt=""> -->
				</div>
				<div id="search-result-box">
				</div>
				<div id="container" class="popup-container">
					<div class="popup">
						<button id="close" class="close">
							X
						</button>
						<h1>⏰최저가 설정하기</h1>
						<p>최저가를 설정해두면 선택하신 상품의 최저가가 떴을 때<br/> 표시해드려요!</p>
						<div>
							<input type="text" id="myprice" placeholder="200,000">원
						</div>
						<button class="cta" onclick="setMyprice()">설정하기</button>
					</div>
				</div>
			</div>


		</div>
	</div>
	<!-- //about -->
	<jsp:include page="layouts/footer.jsp"></jsp:include>
</body>
</html>