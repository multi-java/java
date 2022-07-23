package subway;

import java.io.Console;
import java.util.HashMap;

public class Login {
	HashMap<String, String> map=new HashMap<>();
	public void join(){ //로그인 메소드
		map.put("hello123", "world123");
		map.put("momentum07", "power789");
		map.put("yoo0101", "gigi2580");
		System.out.println(" 로그인 해주십시오. ");
	}//join()
	
	
		public void loginCheck() { //로그인 확인 메소드
			Console console=System.console(); 
			while(true) {
				System.out.print("아이디: ");
				String userid=console.readLine();//여기서 NullPointerException 발생...
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
		}//loginCheck()
		
	public static void main(String[] args) {
		Login my=new Login();
				
		my.join();
		my.loginCheck(); 
	}

}
