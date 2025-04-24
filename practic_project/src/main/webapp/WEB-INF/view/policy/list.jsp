<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
 body {
  font-family: "Helvetica Neue", Arial, sans-serif;
  color: #333;
  margin: 20px;
}
/* 헤딩 간격 */
h2 {
  margin-bottom: 16px;
}

/* —————————— 필드셋 스타일 —————————— */
fieldset {
  border: 1px solid #ccc;
  border-radius: 4px;
  padding: 12px 16px;
  margin-bottom: 24px;
}
legend {
  font-weight: bold;
}
label {
  margin-right: 12px;
}
input[type="number"],
input[type="text"] {
  width: 80px;
  padding: 4px 6px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

/* —————————— 버튼 스타일 —————————— */
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

/* —————————— 표 스타일 —————————— */
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
/* 첫 열(선택) 너비 고정 */
table.policy-table td:first-child {
  width: 40px;
}
</style>


<h2>연체 기준 설정</h2>

<form action="${pageContext.request.contextPath}/Policy/insert" method="post" >
	<fieldset>
		<legend> 새 연체 기준 추가</legend>
		연체 일수 : <input type="number" name="days"  required />
		
		<!-- 주말적용버튼 -->
		<label>
			<input type="checkbox" name="excludeWeekend" value="Y"/>주말 적용
		</label>
		<input type="hidden" name="excludeWeekend" value="N"/>
		
		<!-- 바로적용여부  -->
		<label>
			<input type="checkbox" name="isActive" value="Y"/> 적용시작
		</label>
		<input type="hidden" name="isActive" value="N"/>
		
		<button type="submit" class="btn btn-add">저장</button>
		</fieldset>
</form>

<br>
<br>

<table class="policy-table">
	<thead>
		<tr>
			<th>연체번호</th>
			<th>연체 판정 기준일</th>
			<th>주말제외여부</th>
			<th>정책 생성일</th>
			<th>현재 적용 중인 여부</th>
			<th>비고</th>
	        <th>액션</th>
		</tr>
	</thead>
    <tbody>
		<c:forEach var="p" items="${list}">
	      <c:set var="isDeleted" value="${not empty p.endDate}" />
	      <tr class="${p.isActive=='Y' ? 'active' : ''}">
	        <td>${p.policyNo}</td>
	        <td>${p.days}</td>
	        <td><c:out value="${p.excludeWeekend=='Y' ? 'O' : 'X'}"/></td>
	        <td><c:out value="${p.isActive=='Y'      ? 'O' : 'X'}"/></td>
	        <td>
	          <form action="${pageContext.request.contextPath}/Policy/activate" method="post" style="display:inline">
	            <input type="hidden" name="policyNo" value="${p.policyNo}"/>
	            <button
	              type="submit"
	              class="btn btn-apply"
	              ${p.isActive=='Y' ? 'disabled' : ''}
	              ${isDeleted      ? 'disabled' : ''}>
	              적용
	            </button>
	          </form>
	        </td>
	        <td>${p.note}</td>
	        <td>
	          <form action="${pageContext.request.contextPath}/Policy/delete" method="post" style="display:inline">
	            <input type="hidden" name="policyNo" value="${p.policyNo}"/>
	            <button
	              type="submit"
	              class="btn btn-delete"
	              ${isDeleted ? 'disabled' : ''}>
	              삭제
	            </button>
	          </form>
	          <form action="${pageContext.request.contextPath}/Policy/update" method="get" style="display:inline">
	            <input type="hidden" name="policyNo" value="${p.policyNo}"/>
	            <button
	              type="submit"
	              class="btn btn-edit"
	              ${isDeleted ? 'disabled' : ''}>
	              수정
	            </button>
	          </form>
	        </td>
	      </tr>
	    </c:forEach>
  	</tbody>
</table>