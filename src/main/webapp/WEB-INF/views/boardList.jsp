<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-02-12
  Time: 오전 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>list</title>
</head>
<body>
<table>
  <tr>
    <th>id</th>
    <th>title</th>
    <th>writer</th>
    <th>date</th>
    <th>hits</th>
    <th>delete</th>
  </tr>
  <c:forEach items="${boardList}" var="board">
    <tr>
      <td>${board.id}</td>
      <td>
        <a href="/board?id=${board.id}">${board.boardTitle}</a>
      </td>
      <td>${board.boardWriter}</td>
      <td>${board.boardCreatedTime}</td>
      <td>${board.boardHits}</td>
      <td>
        <button onclick="deleteBoard('${board.id}')">삭제</button>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
<script>
  const deleteBoard = (id) => {
    console.log(id);
    location.href = "/board/deleteBoard?id="+id;
  }
</script>
</html>
