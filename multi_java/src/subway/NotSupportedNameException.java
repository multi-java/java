package subway;
/** 사용자정의 예외처리
 * 
 * 로그인화면에서 아이디와 비밀번호의 확인에 쓰이는 사용자 예외처리
 * 작성자: 김보미
 * 작성일: 22-07-25
 * 버전: 1.1
 */
public class NotSupportedNameException extends Exception { 

	public NotSupportedNameException() {
		super("NotSupportedNameException");
	}
	public NotSupportedNameException(String msg){ 
		super(msg);
	}
}
