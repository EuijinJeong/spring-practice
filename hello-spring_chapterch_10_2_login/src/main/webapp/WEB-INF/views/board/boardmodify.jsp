<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="/css/boardview.css" />
    <title>게시글 수정 화면</title>
  </head>
  <body>
    <h1>게시글 수정</h1>
    <form
      method="post"
      action="/board/modify/${boardVO.id}"
      enctype="multipart/form-data"
    >
      <div class="grid">
        <label for="subject">제목</label>
        <input
          id="subject"
          type="text"
          name="subject"
          value="${boardVO.subject}"
        />

        <label for="file">첨부파일</label>
        <input id="file" type="file" name="file" />

        <label for="content">내용</label>
        <textarea name="content" id="content" style="height: 300px">
          ${boardVO.content}</textarea
        >

        <div class="btn-group">
          <div class="right-align">
            <input type="submit" value="수정" />
          </div>
        </div>
      </div>
    </form>
  </body>
</html>
