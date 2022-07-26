package subway;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;


/** 
 * 환경을 고려해 스마트팜을 통한 무농약 식재료로 만든 토스트 판매 애플리케이션
 * 
 * 앱의 첫 화면: 아이디와 비밀번호를 입력해 로그인
 * -로그인
 * 
 * 작성자: 김보미
 * 작성일: 22-07-26
 * 버전: 1.1
 */

public class Gui01_Login  extends JFrame {
	JFrame f = new JFrame();
	JPanel p,pN,pC;
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
		
		/**1.전체 패널(p)를  BorderLayout구성: pC(중앙), pN(북쪽) 배치*/
		p=new JPanel(new BorderLayout(10, 10));
		p.setBackground(Color.white);
		p.add(pC=new JPanel(),"Center");
		pC.setBackground(Color.white);
		p.add(pN=new JPanel(),"North");
		pN.setBackground(Color.white);
		
		/**2. 북쪽의 pN에 로고 이미지 배치 */
		iconLogo=new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\toastlogo.png");
		laIcon=new JLabel(iconLogo); //
		pN.add(laIcon); 
		
		/**3. 중앙의 pC에 아이디, 비밀번호 입력칸 배치*/
		pC.setLayout(new GridLayout(3,2,30,50));
				
		bLogin=new JButton(" 로그인 ");
		bLogin.setBackground(Color.white);
				
		bJoin=new JButton(" 회원가입 ");
		bJoin.setBackground(Color.white);
				
		textId=new JTextField(20);
		textId.setBackground(Color.white);
		textPwd=new JTextField(20);
		textPwd.setBackground(Color.white);
		
		laId=new JLabel("ID", JLabel.CENTER);
		laPwd=new JLabel("Password", JLabel.CENTER); 
		
		pC.add(laId);
		pC.add(textId);
		pC.add(laPwd);
		pC.add(textPwd);
		pC.add(bJoin);
		pC.add(bLogin);
			
		MyEventHandler handler = new MyEventHandler();
		bLogin.addActionListener(handler);
		bJoin.addActionListener(handler);
				
		/**4.전체 프레임 f에 전체 패널p를 배치. 
		 * 크기설정, 시각화 구현 및 창닫기 처리*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		f.setVisible(true);
		f.setSize(500,700);
		
	}//생성자
	
		
	/**5.이벤트처리로 로그인 확인 절차 
	 * 회원가입 버튼(bJoin)을 누르면 회원가입 페이지 이동.
	 * 
	 * 로그인 버튼(bLogin)을 누르거나 엔터쳤을 때, 
	 * -아이디 틀릴경우, 사용자정의예외+메시지 "아이디가 잘못 되었습니다."
	 * -아이디 맞을 경우, 비번 틀릴 때 사용자정의예외+메시지 "비밀번호가 잘못 되었습니다."
	 * -			  비번 맞을 때 로그인 후 메인화면으로 이동.
	 * */
	
	
	
	
	class MyEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();

		//회원가입 버튼누르면 이동
		if(obj==bJoin) {
		f.setVisible(false);
		new Gui03_JoinMembership();
		}

		//로그인 버튼 누르거나 엔터칠 경우
		if(obj==bLogin || (obj==textId || obj==textPwd)) 
		{
			String id=textId.getText().trim();
			String pwd=textPwd.getText().trim(); 
	
			try {
				//입력 아이디가 저장된 아이디가 아닐 경우
				if (!Gui03_JoinMembership.findID(id)) { 
					textId.setText("");
					textPwd.setText("");
					textId.requestFocus();
					throw new NotSupportedNameException("아이디가 잘못 되었습니다.");
				}
				//아이디 맞고 비번은 틀림
				else if ( Gui03_JoinMembership.findID(id) && !Gui03_JoinMembership.findID(pwd))
				{
					textId.setText("");
			
					textPwd.setText("");
			
					textId.requestFocus();
			
					throw new NotSupportedNameException("비밀번호가 잘못 되었습니다.");
			
		
				//아이디 맞고 비번 맞으면 다음페이지 메인홈 넘어감
				}else {   
					f.setVisible(false);
			
					new Gui02_MainHome();
		
				}
	
			}catch(NullPointerException e1) {//아무것도 입력안했을때
	
				String msg=e1.getMessage();
		
				JOptionPane.showMessageDialog(p,msg);
	
			}catch(NotSupportedNameException e1) { //사용자정의 예외처리:아이디나 비밀번호 틀림
	
				String msg=e1.getMessage();
		
				JOptionPane.showMessageDialog(p,msg);
		
			}catch(Exception e1) {
	
				String msg=e1.getMessage();
		
				JOptionPane.showMessageDialog(p,"예상치 못한 예외 발생");
	
			}



		}//if

		}// 보이드

	}//핸들러 클래스
	
}//클래스
