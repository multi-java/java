package subway;

import javax.swing.*;   
import java.awt.*;
import java.awt.event.*;


/** 
 * 다양한 선택이 가능한 소비자 중심의 토스트 판매 애플리케이션  
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
 * 작성일: 22-07-27
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
	
	/**2. 프레임에 여백을 주는 메서드*/
	@Override
	public Insets getInsets () {
		Insets in=new  Insets(10,10,10,10);
		return in;
	}

	/**3.로그인 화면구성에 대한 생성자 */
	public Gui01_Login() {
		
		super(":: Cafe7 App v1.1 ");
		
		/**3-1)전체 패널(p)를  BorderLayout구성: pC(중앙), pN(북쪽) 배치*/
		p=new JPanel(new BorderLayout(10, 10));
		p.setBackground(Color.white);
		p.add(pC=new JPanel(),"Center");
		pC.setBackground(Color.white);
		p.add(pN=new JPanel(),"North");
		pN.setBackground(Color.white);
		
		/**3-2) 북쪽의 pN에 로고 이미지 배치 */
		iconLogo=new ImageIcon("cafe7logo.png");
		laIcon=new JLabel(iconLogo); //
		pN.add(laIcon); 
		
		/**3-3) 중앙의 pC에 아이디, 비밀번호 입력칸 배치하고, 추가적인 패널배치로 여백 효과 */
		pC.setLayout(new BorderLayout());
			/**pC의 위, 아래, 왼쪽, 오른쪽에 여백을 넣을 수 있도록 BorderLayout으로 설정*/
		pC.add(new JLabel(" "), "North");
		pC.add(new JLabel(" "), "South");
		pC.add(new JLabel("   "), "East");
		pC.add(new JLabel("   "), "West");
				
			/** pC의 가운데에 pnPC 배치 */
		JPanel pnPC = new JPanel(new GridLayout(3,2,30,50));
		pnPC.setBackground(Color.white);
		pC.add(pnPC, "Center");
			/**로그인, 회원가입 버튼*/
		bLogin=new JButton(" 로그인 ");
		bLogin.setBackground(Color.white);
		bJoin=new JButton(" 회원가입 ");
		bJoin.setBackground(Color.white);
			/**아이디 입력칸*/
		textId=new JTextField(15);
		textId.setBackground(Color.white);
			/**비밀번호 입력칸: 로그인 시 비밀번호 가리는 효과*/
		textPwd=new JPasswordField(15);
		textPwd.setBackground(Color.white);
		laId=new JLabel("ID", JLabel.CENTER);
		laPwd=new JLabel("Password", JLabel.CENTER);

		
		/**pnPC의 GridLayout에 넣을 3줄, 2열의 첫 번째 JPanel*/
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.white);
		pn1.add(laId);
		pnPC.add(pn1);
		/**pnPC의 GridLayout에 넣을 3줄, 2열의 두 번째 JPanel*/
		JPanel pn2 = new JPanel();
		pn2.setBackground(Color.white);
		pn2.add(textId);
		pnPC.add(pn2);
		/**pnPC의 GridLayout에 넣을 3줄, 2열의 세 번째 JPanel*/
		JPanel pn3 = new JPanel();
		pn3.setBackground(Color.white);
		pn3.add(laPwd);
		pnPC.add(pn3);
		/***pnPC의 GridLayout에 넣을 3줄, 2열의 네 번째 JPanel*/
		JPanel pn4 = new JPanel();
		pn4.setBackground(Color.white);
		pn4.add(textPwd);
		pnPC.add(pn4);
		/**pnPC의 GridLayout에 넣을 3줄, 2열의 다섯 번째 JPanel*/
		JPanel pn5 = new JPanel();
		pn5.setBackground(Color.white);
		pn5.add(bJoin);
		pnPC.add(pn5);
		/**pnPC의 GridLayout에 넣을 3줄, 2열의 여섯 번째 JPanel*/
		JPanel pn6 = new JPanel();
		pn6.setBackground(Color.white);
		pn6.add(bLogin);
		pnPC.add(pn6);
			
		/**3-4)버튼에 이벤트핸들러 부착*/
		MyEventHandler handler = new MyEventHandler();
		bLogin.addActionListener(handler);
		bJoin.addActionListener(handler);
				
		/**3-5)전체 프레임 f에 전체 패널p를 배치. 크기설정, 시각화 구현 및 창닫기 처리*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		f.setVisible(true);
		f.setSize(500,700);
		
	}
	
	/**4. 앱의 시작인 로그인화면을 호출하는 main() 메서드*/
	public static void main(String[] args) { 
		Gui01_Login my=new Gui01_Login();
	}
			
	/**5.로그인 절차 및 회원가입화면 이동에 대한 이벤트 처리 담당 클래스*/
	class MyEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();

		/**5-1)회원가입 버튼을 누르면 회원가입 페이지 이동.*/
		if(obj==bJoin) {
		f.setVisible(false);
		new Gui03_JoinMembership();
		}

		/**5-2)로그인 버튼을 누르거나 엔터쳤을 경우 */
		if(obj==bLogin || (obj==textId || obj==textPwd)) 
		{
			String id=textId.getText().trim();
			String pwd=textPwd.getText().trim(); 
	
			try {
					/** 아이디나 비밀번호에 빈 칸 있을 경우=> NumberFormatException*/
				if (textId==null || textId.getText().equals("")) {
					throw new NullPointerException("아이디가 비었습니다.");
				}
				if (textPwd==null || textPwd.getText().equals("")) {
					throw new NullPointerException("비밀번호가 비었습니다.");
				}
					/** 입력 아이디가 저장된 아이디가 아닐 경우=>사용자정의 예외*/
				if (!Gui03_JoinMembership.findID(id)) { 
					textId.setText("");
					textPwd.setText("");
					textId.requestFocus();
					throw new NotSupportedNameException("아이디가 잘못 되었습니다.");
				}
					/** 아이디 맞지만, 비빌번로는 틀릴 경우=>사용자정의 예외*/
				else if ( Gui03_JoinMembership.findID(id) && !Gui03_JoinMembership.findID(pwd))
				{
					textId.setText("");
					textPwd.setText("");
					textId.requestFocus();
					throw new NotSupportedNameException("비밀번호가 잘못 되었습니다.");
				}
				/** 아이디와 비빌번호가 맞을 경우, 자동으로 메인홈 이동*/
				else { 
					f.setVisible(false);
					new Gui02_MainHome();
				}
				/** try~catch절로 예외처리*/
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

