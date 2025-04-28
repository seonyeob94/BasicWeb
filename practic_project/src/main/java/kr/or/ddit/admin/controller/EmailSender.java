package kr.or.ddit.admin.controller;

/**
 * 외부 이메일/SMS API 호출 스텁(더미) 클래스
 * 실제 연동 전까지는 send()가 항상 성공(true)하도록 합니다.
 */

public class EmailSender {
	
	 // singleton
    private static final EmailSender INSTANCE = new EmailSender();
    private EmailSender() {}

    public static EmailSender getInstance() {
        return INSTANCE;
    }

    /**
     * 이메일(또는 SMS) 전송
     * @param to      받는 사람 주소(이메일 또는 전화번호)
     * @param subject 이메일 제목(또는 SMS 타이틀)
     * @param body    메시지 본문
     * @return 전송 성공 여부(스텁이므로 항상 true)
     */
    public boolean send(String to, String subject, String body) {
        // TODO: 실제 API 연동 로직(EmailJS, JavaMail, Solapi 등)으로 교체
        System.out.printf("[Stub] Sending message to %s: %s - %s%n",
                          to, subject, body);
        return true;
    }
    
}
