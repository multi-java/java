package subway;


/** 회원정보
 *  
 * 객체인 고객에 대한 정보를 멤버변수로 선언하고 캡슐화.
 * - 이름, 생년월일, 아이디, 비밀번호, 연락처
 * 
 * 작성자: 김보미
 * 작성일: 22-07-27
 * 버전: 1.1
 */

/**1.고객을 추상화하고 고객 데이터와 고객의 데이터들을 접근하기위한 메소드들을 캡슐화하는 클래스*/
public class Customer {
	
	
	/**회원정보를 멤버변수로 선언: 이름, 아이디, 비밀번호,생년월일, 연락처 */
	private int birthdate;
	private String name, id, password, phone  ;
		
	/**2.클래스에 선언된 멤버변수들을 초기화하는 생성자 */
	public Customer(String name, String id, String password, String phone, int birthdate){
		this.name = name;
		this.id = id;
		this.password = password;
		this.phone = phone;
		this.birthdate = birthdate;
	}
	
	
	
	/** 멤버변수의 캡술화*/
	public String getName() {
		return name;
	}
	public int getBirthdate() {
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
	

	
			
	
			
	
	
}
