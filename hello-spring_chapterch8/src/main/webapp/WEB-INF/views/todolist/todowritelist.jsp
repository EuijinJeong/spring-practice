<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="/css/todolist_write.css" />
    <title>ToDo App</title>
  </head>
  <body>
    <div>
      <h1>TODO LIST WRITE</h1>
    </div>
    <div class="todo-list-area">
      <form action="/todolist/writelist" method="post">
        <div class="todo-list-grid">
          <div>제목</div>
          <div>
            <input type="text" name="subject" id="subject" />
          </div>
          <div>기한</div>
          <div>
            <input
              type="date"
              name="deadLine"
              id="deadLine"
              value="기한날짜선택"
            />
          </div>
        </div>
        <div class="error_subject">
          <c:if test="${not empty error_subject}">
            <span>${error_subject}</span>
          </c:if>
        </div>
        <div class="btn-area">
          <input type="submit" value="등록하기" />
        </div>
      </form>
    </div>
  </body>
</html>
