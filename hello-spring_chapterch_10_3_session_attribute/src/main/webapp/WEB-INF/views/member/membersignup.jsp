<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>회원가입 페이지</title>
    <link rel="stylesheet" href="/css/common.css" />
    <link rel="stylesheet" href="/css/signup.css" />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/member/memberregist.js"></script>
  </head>
  <body>
    <h1>회원가입</h1>
    <form method="post" action="/member/signup">
      <label for="email">이메일</label>
      <input id="email" type="email" name="email" />
      <div class="error_message"></div>

      <label for="name">이름</label>
      <input id="name" type="text" name="name" />
      <div class="error_message"></div>
      <label for="password">비밀번호</label>
      <input id="password" type="password" name="password" />
      <div class="error_message"></div>

      <label for="confirmPassword">비밀번호 확인</label>
      <input id="confirmPassword" type="password" name="confirmPassword" />
      <div class="error_message"></div>

      <div class="btn-group">
        <div class="right-align">
          <input type="submit" value="등록" />
        </div>
      </div>
    </form>
  </body>
</html>
