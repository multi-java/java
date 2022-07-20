package subway;
import java.util.*;
import java.io.*;
public class Customer {

HashMap<String, String> map=new HashMap<>();
	
	public void join(){ 
		map.put("hello123", "world123");
		System.out.println(" 로그인 해주십시오. ");
	}
	
	public void loginCheck() {//로그인 메소드
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
	
	public static void main(String[] args) {
		Customer c=new Customer();
		c.join();
		c.loginCheck(); 

	}

}
