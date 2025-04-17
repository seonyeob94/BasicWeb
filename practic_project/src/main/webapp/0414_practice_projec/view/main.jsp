<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DDIT 도서관</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        .main-banner {
            background: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url('${pageContext.request.contextPath}/resource/img/library-banner.jpg');
            background-size: cover;
            background-position: center;
            color: white;
            padding: 100px 0;
            margin-bottom: 30px;
        }
        
        .feature-box {
            padding: 20px;
            border-radius: 5px;
            transition: transform 0.3s;
            height: 100%;
        }
        
        .feature-box:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
        }
        
        .book-card {
            transition: transform 0.3s;
        }
        
        .book-card:hover {
            transform: translateY(-5px);
        }
        
        .footer {
            background-color: #343a40;
            color: white;
            padding: 30px 0;
            margin-top: 50px;
        }
        
        .notification {
            position: fixed;
            top: 60px;
            right: 10px;
            z-index: 1000;
        }
    </style>
</head>
<body>
    <!-- 네비게이션 바 -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">
                <i class="fas fa-book-open me-2"></i>DDIT 도서관
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/books/search.do">
                            <i class="fas fa-search me-1"></i>도서검색
                        </a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">
                            <i class="fas fa-list me-1"></i>게시판
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/board/notice.do">공지사항</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/board/free.do">자유게시판</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/board/recommend.do">도서추천</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/board/bookReport.do">독후감</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/board/faq.do">FAQ</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/board/qna.do">Q&A</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/facilities/readingRoom.do">
                            <i class="fas fa-chair me-1"></i>시설이용
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/events/list.do">
                            <i class="fas fa-calendar-alt me-1"></i>행사/교육
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/volunteer/apply.do">
                            <i class="fas fa-hands-helping me-1"></i>자원봉사
                        </a>
                    </li>
                </ul>
                
                <!-- 로그인 상태에 따른 메뉴 표시 -->
                <c:choose>
                    <c:when test="${empty member}">
                        <!-- 로그인하지 않은 경우 -->
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/member/login.do">
                                    <i class="fas fa-sign-in-alt me-1"></i>로그인
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/member/register.do">
                                    <i class="fas fa-user-plus me-1"></i>회원가입
                                </a>
                            </li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <!-- 로그인한 경우 -->
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">
                                    <i class="fas fa-user-circle me-1"></i>${member.memberName}님
                                </a>
                                <ul class="dropdown-menu dropdown-menu-end">
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/member/mypage.do">
                                        <i class="fas fa-id-card me-1"></i>마이페이지
                                    </a></li>
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/books/myLoans.do">
                                        <i class="fas fa-book me-1"></i>대출현황
                                    </a></li>
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/books/myReservations.do">
                                        <i class="fas fa-bookmark me-1"></i>예약현황
                                    </a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/member/logout.do">
                                        <i class="fas fa-sign-out-alt me-1"></i>로그아웃
                                    </a></li>
                                </ul>
                            </li>
                        </ul>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </nav>

    <!-- 알림 메시지 표시 -->
    <c:if test="${not empty message}">
        <div class="notification">
            <div class="alert alert-${status eq 'success' ? 'success' : status eq 'warning' ? 'warning' : 'danger'} alert-dismissible fade show" role="alert">
                ${message}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </div>
    </c:if>

    <!-- 메인 배너 -->
    <div class="main-banner text-center">
        <div class="container">
            <h1 class="display-4 fw-bold">DDIT 도서관에 오신 것을 환영합니다</h1>
            <p class="lead">지식의 바다에서 새로운 경험을 시작하세요</p>
            <div class="mt-4">
                <form action="${pageContext.request.contextPath}/books/search.do" method="get" class="row justify-content-center">
                    <div class="col-md-6">
                        <div class="input-group">
                            <input type="text" name="keyword" class="form-control form-control-lg" placeholder="도서명, 저자, ISBN으로 검색">
                            <button class="btn btn-primary btn-lg" type="submit">
                                <i class="fas fa-search"></i> 검색
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- 주요 서비스 -->
    <div class="container mb-5">
        <h2 class="text-center mb-4">주요 서비스</h2>
        <div class="row g-4">
            <div class="col-md-3">
                <div class="feature-box bg-light">
                    <div class="text-center mb-3">
                        <i class="fas fa-book fa-3x text-primary"></i>
                    </div>
                    <h4 class="text-center">도서 대출/반납</h4>
                    <p class="text-center">다양한 도서를 대출하고 반납하세요.</p>
                    <div class="text-center">
                        <a href="${pageContext.request.contextPath}/books/search.do" class="btn btn-outline-primary btn-sm">도서 찾기</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="feature-box bg-light">
                    <div class="text-center mb-3">
                        <i class="fas fa-chair fa-3x text-success"></i>
                    </div>
                    <h4 class="text-center">열람실 예약</h4>
                    <p class="text-center">편안한 공간에서 학습하세요.</p>
                    <div class="text-center">
                        <a href="${pageContext.request.contextPath}/facilities/readingRoom.do" class="btn btn-outline-success btn-sm">좌석 예약</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="feature-box bg-light">
                    <div class="text-center mb-3">
                        <i class="fas fa-calendar-alt fa-3x text-danger"></i>
                    </div>
                    <h4 class="text-center">교육/행사</h4>
                    <p class="text-center">다양한 교육과 행사에 참여하세요.</p>
                    <div class="text-center">
                        <a href="${pageContext.request.contextPath}/events/list.do" class="btn btn-outline-danger btn-sm">행사 보기</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="feature-box bg-light">
                    <div class="text-center mb-3">
                        <i class="fas fa-heart fa-3x text-info"></i>
                    </div>
                    <h4 class="text-center">희망도서 신청</h4>
                    <p class="text-center">원하는 도서를 신청하세요.</p>
                    <div class="text-center">
                        <a href="${pageContext.request.contextPath}/books/request.do" class="btn btn-outline-info btn-sm">도서 신청</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 신규 도서 -->
    <div class="container mb-5">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2>신규 도서</h2>
            <a href="${pageContext.request.contextPath}/books/newArrivals.do" class="btn btn-outline-primary">더보기</a>
        </div>
        <div class="row g-4">
            <!-- 신규 도서 목록 (예시) -->
            <c:forEach var="i" begin="1" end="4">
                <div class="col-md-3">
                    <div class="card book-card h-100">
                        <img src="${pageContext.request.contextPath}/resource/img/book-placeholder.jpg" class="card-img-top" alt="도서 이미지">
                        <div class="card-body">
                            <h5 class="card-title">도서 제목 ${i}</h5>
                            <p class="card-text">저자 이름</p>
                            <p class="card-text text-muted">출판사명 | 2023</p>
                        </div>
                        <div class="card-footer bg-transparent">
                            <a href="${pageContext.request.contextPath}/books/detail.do?id=${i}" class="btn btn-sm btn-primary w-100">상세정보</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- 인기 대출 도서 -->
    <div class="container mb-5">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2>인기 대출 도서</h2>
            <a href="${pageContext.request.contextPath}/books/popular.do" class="btn btn-outline-primary">더보기</a>
        </div>
        <div class="row g-4">
            <!-- 인기 대출 도서 목록 (예시) -->
            <c:forEach var="i" begin="1" end="4">
                <div class="col-md-3">
                    <div class="card book-card h-100">
                        <img src="${pageContext.request.contextPath}/resource/img/book-placeholder.jpg" class="card-img-top" alt="도서 이미지">
                        <div class="card-body">
                            <h5 class="card-title">인기 도서 제목 ${i}</h5>
                            <p class="card-text">저자 이름</p>
                            <p class="card-text text-muted">출판사명 | 2023</p>
                        </div>
                        <div class="card-footer bg-transparent">
                            <a href="${pageContext.request.contextPath}/books/detail.do?id=${i}" class="btn btn-sm btn-primary w-100">상세정보</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- 공지사항 및 행사 소식 -->
    <div class="container mb-5">
        <div class="row g-4">
            <!-- 공지사항 -->
            <div class="col-md-6">
                <div class="card h-100">
                    <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
                        <h4 class="mb-0">공지사항</h4>
                        <a href="${pageContext.request.contextPath}/board/notice.do" class="btn btn-sm btn-light">더보기</a>
                    </div>
                    <div class="card-body">
                        <ul class="list-group list-group-flush">
                            <!-- 공지사항 목록 (예시) -->
                            <c:forEach var="i" begin="1" end="5">
                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                    <a href="${pageContext.request.contextPath}/board/noticeDetail.do?id=${i}" class="text-decoration-none text-dark">
                                        도서관 이용 안내 ${i}
                                    </a>
                                    <span class="badge bg-secondary">2023-06-${10+i}</span>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            
            <!-- 행사 소식 -->
            <div class="col-md-6">
                <div class="card h-100">
                    <div class="card-header bg-success text-white d-flex justify-content-between align-items-center">
                        <h4 class="mb-0">교육/행사</h4>
                        <a href="${pageContext.request.contextPath}/events/list.do" class="btn btn-sm btn-light">더보기</a>
                    </div>
                    <div class="card-body">
                        <ul class="list-group list-group-flush">
                            <!-- 행사 목록 (예시) -->
                            <c:forEach var="i" begin="1" end="5">
                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                    <a href="${pageContext.request.contextPath}/events/detail.do?id=${i}" class="text-decoration-none text-dark">
                                        독서 문화 행사 ${i}
                                    </a>
                                    <span class="badge bg-success">2023-07-${10+i}</span>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 푸터 -->
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-md-4 mb-4 mb-md-0">
                    <h5>DDIT 도서관</h5>
                    <p>
                        <i class="fas fa-map-marker-alt me-2"></i>대전광역시 중구 계룡로 846<br>
                        <i class="fas fa-phone me-2"></i>042-222-8202<br>
                        <i class="fas fa-envelope me-2"></i>info@dditlibrary.or.kr
                    </p>
                </div>
                <div class="col-md-4 mb-4 mb-md-0">
                    <h5>이용시간</h5>
                    <p>
                        <strong>자료실</strong>: 평일 09:00~18:00<br>
                        <strong>열람실</strong>: 매일 07:00~23:00<br>
                        <strong>휴관일</strong>: 법정공휴일, 매월 첫째 월요일
                    </p>
                </div>
                <div class="col-md-4">
                    <h5>빠른 링크</h5>
                    <ul class="list-unstyled">
                        <li><a href="${pageContext.request.contextPath}/board/notice.do" class="text-white">공지사항</a></li>
                        <li><a href="${pageContext.request.contextPath}/board/faq.do" class="text-white">자주 묻는 질문</a></li>
                        <li><a href="${pageContext.request.contextPath}/info/privacyPolicy.do" class="text-white">개인정보처리방침</a></li>
                        <li><a href="${pageContext.request.contextPath}/info/termsOfService.do" class="text-white">이용약관</a></li>
                    </ul>
                </div>
            </div>
            <hr class="my-4 bg-light">
            <div class="text-center">
                <p class="mb-0">© 2023 DDIT 도서관. All rights reserved.</p>
            </div>
        </div>
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- 커스텀 스크립트 -->
    <script>
        // 알림 메시지 자동 닫기
        window.setTimeout(function() {
            document.querySelectorAll('.alert').forEach(function(alert) {
                var bsAlert = new bootstrap.Alert(alert);
                bsAlert.close();
            });
        }, 5000);
    </script>
</body>
</html>