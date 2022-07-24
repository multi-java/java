package subway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Console;
import java.util.HashMap;

import subway.Login;
/** 
 *  환경을 고려해 스마트팜을 통한 무농약 식재료로 만든 토스트 판매 애플리케이션
 * 
 * 앱의 첫 화면: 아이디와 비밀번호를 입력해 로그인
 * 
 * 작성자: 김보미
 * 작성일: 22-07-20
 * 버전: 1.1
 */

public class Gui01_Login  extends JFrame {
	JFrame f = new JFrame();
	JPanel p,pN,pC; 
	JPanel myPage; 
	JButton bLogin, bJoin; 
	JTextField textId, textPwd;
	JLabel laId, laPwd;
	JLabel laIcon;
	Icon iconLogo;
	
	@Override
	public Insets getInsets () {
		Insets in=new  Insets(10,10,10,10);
		return in;
	}

	public Gui01_Login() {
		
		super(":: Toast House App v1.1 ");
		
		/**1.전체 패널(p)를  BorderLayout구성*/
		p=new JPanel(new BorderLayout());
		p.setBackground(Color.white);
		p.add(pC=new JPanel(),"Center");
		pC.setBackground(Color.white);
		p.add(pN=new JPanel(),"North");
		pN.setBackground(Color.white);
		
		/**2. 북쪽의 pN에 로고 이미지 배치 */
		iconLogo=new ImageIcon("toastlogo.png");
		laIcon=new JLabel(iconLogo); //
		pN.add(laIcon); 
		
		/**3. 중앙의 pC에 아이디, 비밀번호 입력칸*/
		pC.setLayout(new GridLayout(3,2,30,50));
				
		bLogin=new JButton(" 로그인 ");
		bLogin.setBackground(Color.white);
				
		bJoin=new JButton(" 회원가입 ");
		bJoin.setBackground(Color.white);
				
		textId=new JTextField(20);
		textId.setBackground(Color.white);
		textPwd=new JTextField(20);
		textPwd.setBackground(Color.white);
		
		laId=new JLabel("      ID");
		laPwd=new JLabel("Password");
		
		pC.add(laId);
		pC.add(textId);
		pC.add(laPwd);
		pC.add(textPwd);
		pC.add(bJoin);
		pC.add(bLogin);
		
		
		MyEventHandler handler = new MyEventHandler();
		bLogin.addActionListener(handler);
		bJoin.addActionListener(handler);
				
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		f.add(pN);
		f.add(pC);
		f.setVisible(true);
		f.setSize(500,700);
		
	}//
	
	/*로그인 절차 HashmapTest참고
	 * 
	 * public class Login {
	HashMap<String, String> map=new HashMap<>();
	public void members(){ //로그인 메소드
		map.put("hello123", "world123");
		map.put("momentum07", "power789");
		map.put("yoo0101", "gigi2580");
		System.out.println(" 로그인 해주십시오. ");
	}////저장된 아이디들
	
	
	나는 ArrayList저장 day10 ArrayList참고
	
	
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
	}//loginCheck()*/
	 
	
	
	/**4.로그인 확인 절차
	 * 회원가입 버튼을 누르면 회원가입 페이지 전환.
	 * 
	 * 로그인 버튼을 누르거나 엔터쳤을 때, 
	 * -아이디 틀릴경우, 사용자정의예외+메시지 "아이디가 잘못 되었습니다."
	 * -아이디 맞을 경우, 비번 틀릴 때 사용자정의예외+메시지 "비밀번호가 잘못 되었습니다."
	 * -			  비번 맞을 때 로그인 후 메인화면으로 전환.
	 * */
	/*해결해야할 것
	 * 1. 화면창 안뜸 에러생김, JTabbedPane 지운 후로 셋 다 화면이 회색창만 떴음!!
	 * 
	 * 2. 로그인버튼의 이벤트처리
	 */
	
	class MyEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource();
			if(obj==bJoin) {	//회원가입 버튼누르면 이동
				f.setVisible(false);
				new Gui03_JoinMembership();
				
			}
			
			if(obj==bJoin || (obj==textId && obj==textPwd)) {//로그인 버튼 누르거나 엔터치면
				String id=textId.getText();
				String pwd=textPwd.getText(); //입력한 id,pwd
				/*try {
					if(id!=){//아이디가 틀릴때 메시지  equals??
						
						throw new NotSupportedNameException("아이디가 잘못 되었습니다.");
					textId.setText("");// 이름칸이 지워지고 포커스.
					textPwd.setText("");
					textId.requestFocus();
					
				}else if(id==) {
						if(id.equals(기존아이디)&&pwd!=)//아이디 맞고 비번은 틀림
						throw new NotSupportedNameException("비밀번호가 잘못 되었습니다.");
						textId.setText("");
						textPwd.setText("");
						textId.requestFocus();//
						
				}else {			//아이디 맞고 비번 맞으면 다음페이지 메인 페이지 넘어감	
						
						
					}
				}catch(NullPointerException  e) {//아무것도 입력안했을때
					String msg=e.getMessage();
					JOptionPane.showMessageDialog(p,msg);//패널p에 메시지박스를 띄움
				}catch(NotSupportedNameException e) {
					String msg=e.getMessage();
					JOptionPane.showMessageDialog(p,msg);
				}*/
				
				
			}//if
			
		}// 보이드
	}//핸들러 클래스
}//클래스
