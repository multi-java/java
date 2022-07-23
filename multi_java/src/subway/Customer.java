package subway;
import java.util.*;  
import java.io.*;
/** 
 * 
 * 작성자: 김보미
 * 작성일: 22-07-20
 * 버전: 1.1
 */
// 객체
public class Customer {
	
	
	//회원정보
	private int userNum, birthdate;//회원번호
	private String name, id, password, phone, email  ;//이름, 생년월일, 아이디, 비밀번호, 연락처, 이메일
		
	
	public int getNum() {
		return userNum;
	}
	public String getName() {
		return name;
	}
	public int getBirthday() {
		return birthdate;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}

	public void setNum(int userNum) {
		this.userNum = userNum;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthday(int birthdate) {
		this.birthdate = birthdate;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//기본생성자에 매개변수 기본값넣어줌
	public Customer() {
		this(0001,"정성훈", 880808, "hello123","world123", "01051236987","hello@good.com");
	}
	//매개변수 받는 생성자
	public Customer (int userNum, String name, int birthdate, String id, String password, String phone, String email) {
		this.userNum = userNum;
		this.name=name;
		this.birthdate = birthdate;
		this.id = id;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}
	
	//고객정보를 출력하는 메소드: 회원 정보 조회
	public void showInfo() {
		System.out.println("회원번호 : "+userNum);
		System.out.println("이   름 : "+name);
		System.out.println("아 이 디 : "+id);
		System.out.println("비밀번호 : "+password);
		System.out.println("생년월일 : "+birthdate);
		System.out.println("연 락 처 : "+phone);
		System.out.println("이 메 일 : "+email);
	}
			
	
			
	/*고객 정보를 입력받는 메소드: 회원 정보 수정*/
	public void inputInfo() {
		Scanner sc=new Scanner(System.in);
		System.out.println("회원번호를 입력하십시오.=>");
		userNum=sc.nextInt();
				
		System.out.println("이름을 입력하십시오.=>");
		name=sc.next();
				
		System.out.println("아이디를 입력하십시오.=>");
		id=sc.next();
				
		System.out.println("비밀번호를 입력하십시오.=>");
		password=sc.next();
				
		System.out.println("생년월일을 입력하십시오.=>");
		birthdate=sc.nextInt();
				
				
		System.out.println("연락처를 입력하십시오.=>");
		phone=sc.next();
				
		System.out.println("이메일을 입력하십시오.=>");
		email=sc.next();
				
			}
	
}
