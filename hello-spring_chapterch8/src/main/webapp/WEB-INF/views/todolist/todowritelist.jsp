<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="/css/todolist_write.css" />
    <title>ToDo App</title>
  </head>
  <body>
    <h1>TODO LIST WRITE</h1>

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
          <input type="submit" value="새 아이템 추가" />
        </div>
      </form>
    </div>
  </body>
</html>
