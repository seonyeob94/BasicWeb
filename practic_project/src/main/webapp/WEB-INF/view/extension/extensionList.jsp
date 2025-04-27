<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>연장 요청 목록(ADM07)</title>
  
  <style>
    table {
      width: 100%;
      border-collapse: collapse;
    }
    th, td {
      padding: 0.75em;
      border: 1px solid #ddd;
      text-align: center;
    }
    th {
      background-color: #f5f5f5;
    }
    form {
      display: inline;
    }
    button {
      margin: 0 2px;
      padding: 0.4em 1em;
      border: 1px solid #666;
      background: #fff;
      cursor: pointer;
    }
    button:hover {
      background: #eee;
    }
  </style>
</head>
<body>
  <h1>연장 요청 목록(ADM07)</h1>
  
  <c:if test="${not empty sessionScope.msg}">
    <div style="color: green; margin-bottom: 1em;">
      ${sessionScope.msg}
    </div>
  </c:if>
  
  <table>
    <thead>
      <tr>
        <th>대출번호</th>
        <th>사용자명</th>
        <th>도서명</th>
        <th>처리일자</th>
        <th>처리</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${list}">
        <tr>
          <!-- loanNo -->
          <td><c:out value="${item.loanNo}"/></td>
          <!-- user name -->
          <td><c:out value="${item.name}"/></td>
          <!-- book title -->
          <td><c:out value="${item.bookTitle}"/></td>
          <!-- request date (approved_date 에 초기 요청시 삽입된 SYSDATE 를 사용) -->
          <td><c:out value="${item.approvedDate}"/></td>
          <!-- 승인/거절 버튼 -->
          <td>
            <form action="${pageContext.request.contextPath}/Extension/approve" method="post">
              <input type="hidden" name="approvalNo" value="${item.approvalNo}"/>
              <button type="submit">승인</button>
            </form>
            <form action="${pageContext.request.contextPath}/Extension/reject" method="post">
              <input type="hidden" name="approvalNo" value="${item.approvalNo}"/>
              <button type="submit">거절</button>
            </form>
          </td>
        </tr>
      </c:forEach>
      <c:if test="${empty list}">
        <tr>
          <td colspan="6">등록된 연장 요청이 없습니다.</td>
        </tr>
      </c:if>
    </tbody>
  </table>
</body>
</html>
