<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-02-11
  Time: 오전 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>save</title>
</head>
<body>
<form action="/board/saveBoard" method="post">
  <input type="text" name="boardWriter" placeholder="작성자">
  <input type="text" name="boardPass" placeholder="비밀번호">
  <input type="text" name="boardTitle" placeholder="제목">
  <br>
  <textarea name="boardContents" cols="30" rows="10" placeholder="내용을 입력하세요"></textarea>
  <input type="submit" value="작성">
</form>
</body>
</html>