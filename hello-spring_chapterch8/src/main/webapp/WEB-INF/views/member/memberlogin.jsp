<%-- Created by IntelliJ IDEA. User: jeong-uijin Date: 2024/10/07 Time: 5:14 PM
To change this template use File | Settings | File Templates. --%> <%@ page
contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>로그인화면</title>
  </head>
  <body>
    <h1>로그인</h1>
    <form method="post" action="/member/login">
      <label for="email">이메일</label>
      <input id="email" type="email" name="email" />
      <div class="error_message"></div>

      <label for="password">비밀번호</label>
      <input id="password" type="password" name="password" />
      <div class="error_message"></div>

      <div class="btn-group">
        <div class="right-align">
          <input type="submit" value="로그인" />
        </div>
      </div>
    </form>
  </body>
</html>
