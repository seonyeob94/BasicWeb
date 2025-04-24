<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>연체 기준 설정</title>
  <style>
    /* — 전체 페이지 폰트/여백 설정 — */
    body {
      font-family: "Helvetica Neue", Arial, sans-serif;
      color: #333;
      margin: 20px;
    }
    h2 { margin-bottom: 16px; }

    /* — 필드셋 스타일 — */
    fieldset {
      border: 1px solid #ccc;
      border-radius: 4px;
      padding: 12px 16px;
      margin-bottom: 24px;
    }
    legend { font-weight: bold; }
    label { margin-right: 12px; }

    input[type="number"],
    input[type="text"] {
      width: 80px;
      padding: 4px 6px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    /* — 버튼 스타일 — */
    .btn {
      padding: 6px 12px;
      margin-right: 4px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 0.9em;
    }
    .btn-add    { background: #28a745; color: #fff; }
    .btn-apply  { background: #17a2b8; color: #fff; }
    .btn-edit   { background: #007bff; color: #fff; }
    .btn-delete { background: #dc3545; color: #fff; }
    .btn:disabled {
      background: #ccc;
      cursor: not-allowed;
    }

    /* — 표 스타일 — */
    table.policy-table {
      width: 100%;
      border-collapse: collapse;
    }
    table.policy-table th,
    table.policy-table td {
      border: 1px solid #ddd;
      padding: 8px;
      text-align: center;
      vertical-align: middle;
    }
    table.policy-table th {
      background-color: #f8f9fa;
    }
    table.policy-table tr:nth-child(even) {
      background-color: #f2f2f2;
    }
    table.policy-table tr:hover {
      background-color: #e9ecef;
    }
    /* 현재 적용 중인 행 강조 */
    table.policy-table tr.active {
      background-color: #d1ecf1;
    }
  </style>
</head>
<body>


<h2>연체 기준 수정</h2>
<form action="${pageContext.request.contextPath}/Policy/update" method="post">
  <fieldset>
    <legend>기준 정보</legend>
    <input type="hidden" name="policyNo" value="${vo.policyNo}" />

    <label>
      연체일수:
      <input type="number" name="days" value="${vo.days}" required />
    </label>

    <label>
      <input type="checkbox" name="excludeWeekend" value="Y"
             <c:if test="${vo.excludeWeekend == 'Y'}">checked</c:if>
      /> 주말 제외
      <input type="hidden" name="excludeWeekend" value="N"/>
    </label>

    <label>
      비고:
      <input type="text" name="note" value="${vo.note}" />
    </label>

    <button type="submit" class="btn btn-edit">수정완료</button>
  </fieldset>
</form>

</body>
</html>