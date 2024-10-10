<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 리스트 화면</title>
</head>
<body>
	게시글의 수: ${ boardListVO.boardCnt }
	<br /> 
	조회된 게시글의 수: ${boardListVO.boardList.size()}
</body>
</html>