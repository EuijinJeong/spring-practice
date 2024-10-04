<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="/css/todolist.css" />
    <title>ToDo App</title>
  </head>
  <body>
    <h1>TODO LIST</h1>
    <div class="todo-list-area">
      <div class="todo-list-grid">
        <div>번호</div>
        <div>완료?</div>
        <div>TODO SUBJECT</div>
        <div>기한</div>
        <div>완료버튼</div>
        <div>삭제버튼</div>
      </div>
      <c:choose>
        <c:when test="${not empty toDoList}">
          <c:forEach items="${toDoList}" var="todolist">
            <div class="todo-list-grid">
              <div>${todolist.id}</div>
              <div>
                <c:choose>
                  <c:when test="${todolist.isFinished == 1}">DONE</c:when>
                </c:choose>
              </div>
              <div>${todolist.subject}</div>
              <div>${todolist.deadLine}</div>
              <div>
                <c:choose>
                  <c:when test="${todolist.isFinished == 0}">
                    <form
                      action="/todolist/modify/${todolist.id}"
                      method="post"
                    >
                      <button type="submit">완료</button>
                    </form>
                  </c:when>
                </c:choose>
              </div>
              <div>
                <form action="/todolist/delete/${todolist.id}" method="post">
                  <button type="submit">삭제</button>
                </form>
              </div>
            </div>
          </c:forEach>
        </c:when>
      </c:choose>

      <div class="btn-area">
        <a href="/todolist/writelist">새 아이템 추가</a>
      </div>
    </div>
  </body>
</html>
