<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="/css/common.css" />
    <link rel="stylesheet" href="/css/login.css" />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <title>로그인페이지</title>
  </head>
  <body>
    <h1>로그인</h1>
    <form:form modelAttribute="loginMemberVO" method="post">
      <div>
        <form:errors path="email" element="div" cssClass="error" />
        <form:errors path="password" element="div" cssClass="error" />
        <c:if test="${not empty message}">
          <div class="error">${message}</div>
        </c:if>
      </div>

      <div class="grid">
        <label for="email">이메일</label>
        <input
          id="email"
          type="email"
          name="email"
          value="${loginMemberVO.email}"
        />

        <label for="password">비밀번호</label>
        <input
          id="password"
          type="password"
          name="password"
          value="${loginMemberVO.password}"
        />

        <div class="btn-group">
          <div class="right-align">
            <input id="btn-regist" type="submit" value="로그인" />
          </div>
        </div>
      </div>
    </form:form>
  </body>
</html>
