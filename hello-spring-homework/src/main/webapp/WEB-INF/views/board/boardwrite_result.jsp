<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록 결과</title>
</head>
<body>
    <h1>게시글 등록 결과</h1>
    <div>
        <p>제목: ${board.subject}</p>
        <p>아이디: ${board.email}</p>
        <p>내용: ${board.content}</p>
    </div>
    <a href="/board/list">게시글 목록으로 돌아가기</a>
</body>
</html>