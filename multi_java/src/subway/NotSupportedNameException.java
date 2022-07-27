package subway;
/** 사용자정의 예외처리
 * 
 * 로그인화면에서 입력 아이디가 저장된 아이디가 아닐 경우, 
 * 입력 비밀번호가 저장된 비밀번호가 아닐 경우, 
 * NotSupportedNameException을 발생시켜 로그인하지 못하도록 막는다
 * 
 * 작성자: 김보미
 * 작성일: 22-07-27
 * 버전: 1.1
 */
/**로그인 화면에서 아이디나 비밀번호가 틀릴 경우, 로그린 실패로 발생하는 사용자 정의 예외 클래스 */
public class NotSupportedNameException extends Exception { 
	
	public NotSupportedNameException() {
		super("NotSupportedNameException");
	}
	
	public NotSupportedNameException(String msg){ 
		super(msg);
	}

}
