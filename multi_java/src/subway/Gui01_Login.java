package subway;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;


/** 
 * 환경을 고려해 스마트팜을 통한 무농약 식재료로 만든 토스트 판매 애플리케이션

 * 
 * 로그인 화면: 앱의 첫 화면
 * 
 * 1) 첫 방문 고객은 회원가입 버튼을 클릭해 회원가입 페이지로 이동.
 * 2) 재방문 고객은 아이디와 비밀번호를 입력해 로그인
 * 	<1> 로그인 과정에서 공백으로 남을 경우, 메시지가 뜨고 다시 입력할 수 있음
 *  <2> 아이디, 비밀번호를 틀릴 경우, 메시지가 뜨고 다시 입력할 수 있음
 *  <3>로그인 완료 시 자동으로 메인페이지를 보여줌
 *  
 * 작성자: 김보미
 * 작성일: 22-07-26
 * 버전: 1.1
 */


/**1.로그인 화면에 대한 클래스*/
public class Gui01_Login  extends JFrame {
	JFrame f = new JFrame();
	JPanel p,pN,pC;
	JButton bLogin, bJoin;
	JTextField textId, textPwd;
	JLabel laId, laPwd;
	JLabel laIcon;
	Icon iconLogo;
	
	/**2. 오버라이드: 컨테이너의 바깥 여백을 주는 메서드*/
	@Override
	public Insets getInsets () {
		Insets in=new  Insets(10,10,10,10);
		return in;
	}

	/**3.Gui 화면구성에 대한 생성자 */
	public Gui01_Login() {
		
		super(":: Toast House App v1.1 ");
		
		/**3-1)전체 패널(p)를  BorderLayout구성: pC(중앙), pN(북쪽) 배치*/
		p=new JPanel(new BorderLayout(10, 10));
		p.setBackground(Color.white);
		p.add(pC=new JPanel(),"Center");
		pC.setBackground(Color.white);
		p.add(pN=new JPanel(),"North");
		pN.setBackground(Color.white);
		
		/**3-2) 북쪽의 pN에 로고 이미지 배치 */
		iconLogo=new ImageIcon("toastlogo.png");
		laIcon=new JLabel(iconLogo); //
		pN.add(laIcon); 
		
		/**3-3) 중앙의 pC에 아이디, 비밀번호 입력칸 배치*/
		// 중앙의 pC의 위, 아래, 왼쪽, 오른쪽에 여백을 넣을 수 있도록 BorderLayout으로 설정한다.
				pC.setLayout(new BorderLayout());
				
				// 중앙의 pC의 위, 아래, 왼쪽, 오른쪽에 여백이 생기도록 한다.
				pC.add(new JLabel(" "), "North");
				pC.add(new JLabel(" "), "South");
				pC.add(new JLabel("   "), "East");
				pC.add(new JLabel("   "), "West");
				
				// 3줄과 2열의 패널을 넣기 위해서 5, 2로 설정한다.
				JPanel pnPC = new JPanel(new GridLayout(3,2,30,50));
				pnPC.setBackground(Color.white);
				
				// pC의 가운데에 pnPC가 오도록 한다.
				pC.add(pnPC, "Center");
				
				bLogin=new JButton(" 로그인 ");

				bLogin.setBackground(Color.white);

				bJoin=new JButton(" 회원가입 ");

				bJoin.setBackground(Color.white);

				textId=new JTextField(15);

				textId.setBackground(Color.white);

				textPwd=new JPasswordField(15);

				textPwd.setBackground(Color.white);

				laId=new JLabel("ID", JLabel.CENTER);

				laPwd=new JLabel("Password", JLabel.CENTER);

				JPanel pn1 = new JPanel();
				pn1.setBackground(Color.white);
				pn1.add(laId);
				pnPC.add(pn1);
				
				// 3줄, 2열의 GridLayout에 넣을 두 번째 패널
				// textId를 GridLayout에 넣지 않고 패널을 통하여 넣으면 텍스트필드가 통통해 보이지 않도록 설정이 가능하다.
				JPanel pn2 = new JPanel();
				pn2.setBackground(Color.white);
				pn2.add(textId);
				pnPC.add(pn2);
				
				JPanel pn3 = new JPanel();
				pn3.setBackground(Color.white);
				pn3.add(laPwd);
				pnPC.add(pn3);
				
				// 3줄, 2열의 GridLayout에 넣을 네 번째 패널
				// txtPwd를 GridLayout에 넣지 않고 패널을 통하여 넣으면 텍스트필드가 통통해 보이지 않도록 설정이 가능하다.
				JPanel pn4 = new JPanel();
				pn4.setBackground(Color.white);
				pn4.add(textPwd);
				pnPC.add(pn4);
				
				JPanel pn5 = new JPanel();
				pn5.setBackground(Color.white);
				pn5.add(bJoin);
				pnPC.add(pn5);
				
				JPanel pn6 = new JPanel();
				pn6.setBackground(Color.white);
				pn6.add(bLogin);
				pnPC.add(pn6);
			
		/*버튼에 이벤트핸들러 부착*/
		MyEventHandler handler = new MyEventHandler();
		bLogin.addActionListener(handler);
		bJoin.addActionListener(handler);
				
		/**3-4) 전체 프레임 f에 전체 패널p를 배치. 
		 * 크기설정, 시각화 구현 및 창닫기 처리*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		f.setVisible(true);
		f.setSize(500,700);
		
	}
	
	/**4. main() 메서드*/
	public static void main(String[] args) { 
		Gui01_Login my=new Gui01_Login();
	}
		
	 /**이벤트처리로 로그인 확인 절차 및 회원가입 화면 이동
	 * 
	 * 1)회원가입 버튼(bJoin)을 누르면 회원가입 페이지 이동.
	 * 
	 * 2)로그인 버튼(bLogin)을 누르거나 엔터쳤을 때, 
	 *  <1>빈 칸 있을 경우 : NumberFormatException을 try~catch절로 예외처리
	 * 		-둘 다 빈칸이거나 아이디를 입력하지 않았을 경우, "아이디가 비었습니다."
	 * 		-비밀번호를 입력하지 않았을 경우 "비밀번호가 비었습니다.
	 * 
	 *  <2>아이디 틀릴경우, 사용자정의예외+ 메시지"아이디가 잘못 되었습니다."
	 * 	<3>아이디 맞을 경우, 비번 틀릴 때 사용자 정의 예외+ 메시지"비밀번호가 잘못 되었습니다."
	 * 	<4>		  		 비번 맞을 때 로그인 후 메인화면으로 이동.
	 * */
	
	/**5.로그인 절차 및 화면 이동에 대한 이벤트 처리하는 클래스*/
	class MyEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();

		/*5-1)회원가입 버튼을 누르면 회원가입 페이지 이동.*/
		if(obj==bJoin) {
		f.setVisible(false);
		new Gui03_JoinMembership();
		}

		/*5-2)로그인 버튼을 누르거나 엔터쳤을 경우 */
		if(obj==bLogin || (obj==textId || obj==textPwd)) 
		{
			String id=textId.getText().trim();
			String pwd=textPwd.getText().trim(); 
	
			try {
					/*2-1 빈 칸 있을 경우*/
				if (textId==null || textId.getText().equals("")) {
					throw new NullPointerException("아이디가 비었습니다.");
					}
					if (textPwd==null || textPwd.getText().equals("")) {
					throw new NullPointerException("비밀번호가 비었습니다.");
					}
					/*2-2입력 아이디가 저장된 아이디가 아닐 경우=>사용자정의 예외*/
				if (!Gui03_JoinMembership.findID(id)) { 
					textId.setText("");
					textPwd.setText("");
					textId.requestFocus();
					throw new NotSupportedNameException("아이디가 잘못 되었습니다.");
				}
					/*2-3 아이디 맞지만, 비빌번로는 틀릴 경우=>사용자정의 예외*/
				else if ( Gui03_JoinMembership.findID(id) && !Gui03_JoinMembership.findID(pwd))
				{
					textId.setText("");
					textPwd.setText("");
					textId.requestFocus();
			
					throw new NotSupportedNameException("비밀번호가 잘못 되었습니다.");
				}
				/*2-4 아이디와 비빌번로가 맞을 경우, 자동으로 메인홈 이동*/
				else { 
					f.setVisible(false);
					new Gui02_MainHome();
				}
				/*2-5 try~catch절로 예외처리*/
			}catch(NullPointerException e1) {
				String msg=e1.getMessage();
				JOptionPane.showMessageDialog(p,msg);
			}catch(NotSupportedNameException e1) {
				String msg=e1.getMessage();
				JOptionPane.showMessageDialog(p,msg);
			}catch(Exception e1) {
				String msg=e1.getMessage();
				JOptionPane.showMessageDialog(p,"예상치 못한 예외 발생");
	
			}

		}

		}

	}
	
}

