<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- JSTL을 위한 Directive 선언 -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>게시글 리스트 화면</title>
  </head>
  <body>
    <div class="grid">
      <div class="right-align">
        <ul class="horizontal-list">
          <c:choose>
            <c:when test="${empty sessionScope._LOGIN_USER_.name}">
              <li>
                <a href="/member/signup">회원가입</a>
              </li>
              <li>
                <a href="/member/login">로그인</a>
              </li>
            </c:when>
            <c:otherwise>
              <li style="margin-right: 1rem">
                ${sessionScope._LOGIN_USER_.name}
                (${sessionScope._LOGIN_USER_.email})
                <a href="/member/logout">로그아웃</a>
              </li>
              <li>
                <a href="/member/delete-me">탈퇴</a>
              </li>
            </c:otherwise>
          </c:choose>
        </ul>
        총 ${boardListVO.boardCnt}건의 게시글이 검색되었습니다.
      </div>

      <table class="table">
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>이메일</th>
            <th>조회수</th>
            <th>등록일</th>
            <th>수정일</th>
          </tr>
        </thead>
        <tbody>
          <!-- 
				BoardListVO boardListVO = new BoardListVO();
				List<BoardVO> boardList = boardListVO.getBoardList();
				for(BoardVO board : boardList) {
					...
				}
				 -->
          <!-- 
				 	${boardListVO.boardList}가 비어있지않음.
				 	forEach를 통해 목록을 보여주고
				 	아니라면
				 	"게시글이 없습니다."를 보여준다.
				  -->
          <c:choose>
            <c:when test="${not empty boardListVO.boardList}">
              <c:forEach items="${boardListVO.boardList}" var="board">
                <tr>
                  <td>${board.id}</td>
                  <td>
                    <a href="/board/view?id=${board.id}">${board.subject}</a>
                  </td>
                  <td>${board.email}</td>
                  <td>${board.viewCnt}</td>
                  <td>${board.crtDt}</td>
                  <td>${board.mdfyDt}</td>
                </tr>
              </c:forEach>
            </c:when>
            <c:otherwise>
              <tr>
                <td colspan="6">게시글이 없습니다.</td>
              </tr>
            </c:otherwise>
          </c:choose>
        </tbody>
      </table>
      <c:if test="${not empty sessionScope._LOGIN_USER_}">
        <div class="right-align">
          <a href="/board/write">게시글 등록</a>
        </div>
      </c:if>
    </div>
  </body>
</html>
