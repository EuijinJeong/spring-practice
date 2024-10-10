<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="/css/common.css" />
    <title>게시글 작성 페이지</title>
  </head>
  <body>
    <div class="membermenu">
      <jsp:include page="../member/membermenu.jsp"></jsp:include>
    </div>
    <h1>게시글 작성</h1>
    <form method="post" enctype="multipart/form-data">
      <div class="grid">
        <label for="subject">제목</label>
        <input id="subject" type="text" name="subject" />

        <label for="file">첨부파일</label>
        <input id="file" type="file" name="file" />

        <label for="content">내용</label>
        <textarea id="content" name="content" style="height: 300px"></textarea>
        <div class="btn-group">
          <div class="right-align">
            <input type="submit" value="저장" />
          </div>
        </div>
      </div>
    </form>
  </body>
</html>
