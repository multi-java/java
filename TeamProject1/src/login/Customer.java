package login;


/** 회원정보
 * 
 * 작성자: 김보미
 * 작성일: 22-07-20
 * 버전: 1.1
 */
// 객체
public class Customer {
	
	
	//회원정보
	private int birthdate;//생년월일
	private String name, id, password, phone  ;//이름, 아이디, 비밀번호, 연락처
		
	//생성자 
	public Customer(String name, String id, String password, String phone, int birthdate){
		this.name = name;
		this.id = id;
		this.password = password;
		this.phone = phone;
		this.birthdate = birthdate;
	}
	
	
	
	
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