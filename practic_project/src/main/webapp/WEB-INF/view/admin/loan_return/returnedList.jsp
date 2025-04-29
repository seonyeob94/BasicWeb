<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!-- CSS 포함 -->  
<link rel="stylesheet"  
      href="${pageContext.request.contextPath}/resource/css/admin/loan_return/returnedList.css" />  

<h2>반납 완료 목록</h2>  

<table class="returned-table">  
  <thead>  
    <tr>  
      <th>대출번호</th>  
      <th>이름</th>  
      <th>도서명</th>  
      <th>대출일</th>  
      <th>반납일</th>  
      <th>연체여부</th>  
    </tr>  
  </thead>  
  <tbody>  
    <c:forEach var="v" items="${list}">  
      <tr>  
        <td><c:out value="${v.loanNo}"/></td>  
        <td><c:out value="${v.name}"/></td>  
        <td><c:out value="${v.bookTitle}"/></td>  
        <td><c:out value="${v.loanDate}"/></td>  
        <td><c:out value="${v.returnDate}"/></td>  
        <!-- selectReturnedList 에서 만든 statusText 사용 -->  
        <td><span class="status"><c:out value="${v.statusText}"/></span></td>  
      </tr>  
    </c:forEach>  
  </tbody>  
</table>  
