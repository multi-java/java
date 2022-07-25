package subway;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;


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
	
	Gui02_MainHome mainHome;
	Gui03_JoinMembership join;
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
		
		mainHome=new Gui02_MainHome();
		join=new Gui03_JoinMembership();
		mainHome.setCustomers(join.customers);
		
		MyEventHandler handler = new MyEventHandler();
		bLogin.addActionListener(handler);
		bJoin.addActionListener(handler);
				
		/**4.전체 프레임 f에 모든 패널을 배치. 
		 * 크기설정, 시각화 구현 및 창닫기 처리*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		//f.add(pN);
		//f.add(pC);
		f.setVisible(true);
		f.setSize(500,700);
		
	}//
	
	/*로그인 절차 HashmapTest참고//나는 ArrayList저장 day10 ArrayList참고

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
	 
	
	
	/**5.이벤트처리로 로그인 확인 절차 
	 * 회원가입 버튼을 누르면 회원가입 페이지 이동.
	 * 
	 * 로그인 버튼을 누르거나 엔터쳤을 때, 
	 * -아이디 틀릴경우, 사용자정의예외+메시지 "아이디가 잘못 되었습니다."
	 * -아이디 맞을 경우, 비번 틀릴 때 사용자정의예외+메시지 "비밀번호가 잘못 되었습니다."
	 * -			  비번 맞을 때 로그인 후 메인화면으로 이동.
	 * */
	/*해결해야할 것
	 * 1. 로그인버튼의 이벤트처리
	 */
	
	public static void main(String[] args) {
		Gui01_Login my=new Gui01_Login();
	}
	
	class MyEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource();
			if(obj==bJoin) {//회원가입 버튼누르면 이동
				//System.out.println("bjoin");
				//setTitle("JOIN");
				join.f.setLocation(300,300);
				join.f.setSize(500,700);
				join.f.setVisible(false);
			//	new Gui03_JoinMembership();
			}
			if(obj==bLogin || (obj==textId && obj==textPwd)) {//로그인 버튼 누르거나 엔터치면
				String id=textId.getText();
				String pwd=textPwd.getText(); //입력한 id,pwd
				
				
				/*ArrayList에 저장된 정보를 꺼내서 입력값과 비교해야함
				 * getId, getPassword
				 * customers.get(0).getName()
				 * 
				 * try {
					if(id!=getId){						
						throw new NotSupportedNameException("아이디가 잘못 되었습니다.");
					textId.setText("");
					textPwd.setText("");
					textId.requestFocus();
					}else if(id==getId) {
						if((id==getId)&&(pwd!=getPassword))//아이디 맞고 비번은 틀림id.
						throw new NotSupportedNameException("비밀번호가 잘못 되었습니다.");
						textId.setText("");
						textPwd.setText("");
						textId.requestFocus();
						
				}else {			//아이디 맞고 비번 맞으면 다음페이지 메인 페이지 넘어감	
						
						
					}
				}catch(NullPointerException  e) {//아무것도 입력안했을때
					String msg=e.getMessage();
					JOptionPane.showMessageDialog(p,msg);//패널p에 메시지박스를 띄움
				}catch(NotSupportedNameException e) {
					String msg=e.getMessage();
					JOptionPane.showMessageDialog(p,msg);
				}*/
				
				mainHome.f.setSize(500,700);
				mainHome.f.setVisible(true);//메인홈 보여주
				f.setVisible(false);//로그인 프레임 감추
				
			}//if
			
		}// 보이드
	}//핸들러 클래스
}//클래스
