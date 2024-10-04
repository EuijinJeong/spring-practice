<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="/css/common.css" />
    <title>게시글 작성</title>
  </head>
  <body>
    <h1>게시글 작성</h1>
    <form method="post" enctype="multipart/form-data">
      <div class="errors">
        <p>${error_subjects}</p>
      </div>
      <div class="grid">
        <label for="subject">제목</label>
        <input
          id="subject"
          type="text"
          name="subject"
          value="${writeBoardVO.subject}"
        />
        <label for="email">이메일</label>
        <input
          id="email"
          type="email"
          name="email"
          value="${writeBoardVO.email}"
        />
        <label for="content">내용</label>
        <textarea id="content" name="content" style="height: 300px"></textarea>
        <div class="btn-group">
          <div class="right-align">
            <input type="submit" value="저장" />
          </div>
        </div>
      </div>
    </form>

	<script type="text/javascript">window.onload = function(){}</script>
  </body>
</html>
