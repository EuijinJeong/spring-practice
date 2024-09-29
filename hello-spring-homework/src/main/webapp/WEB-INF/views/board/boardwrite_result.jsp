<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/boardwrite_result.css" />
<title>게시글 등록 결과 페이지</title>
</head>
<body>
	<h1>게시글 등록 결과</h1>
	<div class="message">
		<c:out value="${message}" />
	</div>

<a href="/board/list" class="button">게시글 목록으로 돌아가기</a>
</body>
</html>