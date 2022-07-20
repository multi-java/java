package subway;
import java.util.*; 
import java.io.*;
/** 
 * 바쁜 일상에서 건강하고 간편한 한끼 식사를 위해 만든 토스트 애플리케이션
 * 
 * 회원 정보에 대한 클래스 생성
 * 회원정보를 각각 변수로 설정 : 회원번호, 성명, 아이디, 비밀번호, 생년월일, 이메일, 연락처
 * 회원정보를 캡슐화하여 private 설정
 * 로그인과정에 대한 join()메소드 작성 
 * 로그인절차에 대한 loginCheck()메소드 작성
 * - id, password가 맞으면 환영메시지
 * - 잘못된 아이디나 비밀번호에 대해 다시 확인하는 절차
 * 메인메소드에서 위의 메소드 호출
 * 
 * 작성자: 김보미
 * 작성일: 22-07-20
 * 버전: 1.1
 */

public class Customer {
	
	//회원정보
	int userNum;//회원번호
	String name;//성명
	String id;//아이디
	String password;//비밀번호
	String birthdate;//생년월일
	String email;//이메일
	String phone;//연락처
	
	//캡슐화: getter
	public int getNum() {
		return userNum;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getBirthday() {
		return birthdate;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	//캡슐화: setter
	public void setNum(int userNum) {
		this.userNum = userNum;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setBirthday(String birthdate) {
		this.birthdate = birthdate;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	HashMap<String, String> map=new HashMap<>();
	//로그인 메소드
	public void join(){ 
		map.put("hello123", "world123");
		map.put("momentum07", "power789");
		map.put("yoo0101", "gigi2580");
		System.out.println(" 로그인 해주십시오. ");
	}
	
	//로그인 확인 메소드
	public void loginCheck() {
		Console console=System.console(); 
		while(true) {
			System.out.print("아이디: ");
			String userid=console.readLine();
			System.out.print("비밀번호: ");
			char[] pwd=console.readPassword(); 
			if (!map.containsKey(userid)) {
				System.out.println("아이디를 다시 확인해주십시오.");
			} else {
				String realPwd=map.get(userid);
				if (realPwd.equals(new String(pwd))) {
					System.out.println(userid + "님 환영합니다.");
					break;// 
				} else {
					System.out.println("비밀번호를 다시 확인해주십시오.");
					continue;
				}
			}
			}
	}
	
	//메소드 호출
	public static void main(String[] args) {
		Customer c=new Customer();
		c.join();
		c.loginCheck(); 

	}

}
