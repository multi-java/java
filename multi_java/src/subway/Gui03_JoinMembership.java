package subway;
/** 
 * 회원가입 화면
 * 
 * 작성자: 김보미
 * 작성일: 22-07-23
 * 버전: 1.1
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Gui03_JoinMembership extends JFrame {
	JFrame f = new JFrame();
	JPanel p,pN,pC,pS; 
	JButton bJoin,bBack; 
	JTextField tId, tPwd, tName,tPhone, tBirthdate; 
	JLabel laId, laPwd, laName,laPhone, laBirthdate;
	JLabel laText;
	Icon iconBack;
	
	//JTabbedPane tabP; //지우기
	
		@Override
		public Insets getInsets () {
			Insets in=new  Insets(10,10,10,10);
			return in;
		}
		
		public Gui03_JoinMembership() {
			
			super(":: Toast House App v1.1 ");
			
			/**1.전체 패널(p)를  BorderLayout구성*/
			p=new JPanel(new BorderLayout()); 
			p.setBackground(Color.white);
			p.add(pC=new JPanel(),"Center");
			pC.setBackground(Color.white);
			p.add(pN=new JPanel(),"North"); 
			pN.setBackground(Color.white);
			p.add(pS=new JPanel(),"South"); 
			pS.setBackground(Color.white);
			
			/**2. 북쪽의 pN에 회원가입문구 */
			laText=new JLabel("회원가입");
			laText.setHorizontalTextPosition(JLabel.CENTER);
			laText.setVerticalTextPosition(JLabel.TOP);
			laText.setFont(new Font("sans-serif",Font.BOLD,28));
			pN.add(laText); 
			
			
			/**3. 중앙의 pC에 회원가입에 대한 정보 입력칸*/
			pC.setLayout(new GridLayout(7,2,30,50));
					
			laId=new JLabel("아이디");
			laPwd=new JLabel("비밀번호");
			laName=new JLabel("이름");
			laBirthdate=new JLabel("생년월일");
			laPhone=new JLabel("연락처");
			//laEmaie=new JLabel("이메일");
					
			tId=new JTextField(15);
			tId.setBackground(Color.white);
			tPwd=new JTextField(15);
			tPwd.setBackground(Color.white);
			tName=new JTextField(15);
			tName.setBackground(Color.white);
			tBirthdate=new JTextField(15);
			tBirthdate.setBackground(Color.white);
			tPhone=new JTextField(15);
			tPhone.setBackground(Color.white);
			//tEmaie=new JTextField(20);
			//tEmaie.setBackground(Color.white);
				
			pC.add(laId);
			pC.add(tId);
			pC.add(laPwd);
			pC.add(tPwd);
			pC.add(laName);
			pC.add(tName);
			pC.add(laBirthdate);
			pC.add(tBirthdate);
			pC.add(laPhone);
			pC.add(tPhone);
			//pC.add(laEmaie);
			//pC.add(tEmaie);
			
			/**4.남쪽의 pS에 회원가입, 뒤로 버튼*/
			bJoin=new JButton(" 회원가입 ");//회원가입 버튼
			bJoin.setBackground(Color.white);
			pS.add(bJoin);
			
			iconBack=new ImageIcon("icon_back.png");
			bBack=new JButton(iconBack);
			bBack.setBackground(Color.white);
			pS.add(bBack);
			
			/*지우기
			tabP=new JTabbedPane();
			add(tabP);
			tabP.add(p,"Main");
			tabP.setSelectedIndex(0);*/
			

			MyEventHandler handler = new MyEventHandler();
			bBack.addActionListener(handler);
			bJoin.addActionListener(handler);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.add(p);
			f.add(pN);
			f.add(pC);
			f.add(pS);
			f.setVisible(true);
			f.setSize(500,700);
			
		}
		
		/**5.회원가입 
		 *  뒤로 버튼을 누르면 로그인화면으로 이동
		 *  
		 * 회원가입 버튼을 누르면 고객정보 저장해서 회원가입하고, 메인화면으로 이동
		 * -중복x 사용자정의예외+메시지 "이미 가입한 고객님이십니다"
		 * -빈칸있으면 NullPointerException+메시지"고객님의 정보를 입력해주십시오"
		 * -생년월일은 6자리까지만. 7자리쓰면 사용자정의예외+메시지"생년월일은 6자리로 입력해주십시오."
		 * */
		
		/*해결해야할 것
		 *1. 화면창 안뜸 에러생김, JTabbedPane 지운 후로 셋 다 화면이 회색창만 떴음!!
		 *2. 해시코드 없애려면 오버라이드? day11 ObjectTest 
		 *3. 회원가입버튼의 이벤트 처리
		 * 
		 */
		
		
		class MyEventHandler implements ActionListener{
			ArrayList<Customer> customers = new ArrayList<Customer>();//ArrayList에 고객정보 저장하기 위해
			public void actionPerformed(ActionEvent e) {
				Object obj=e.getSource();
				if(obj==bBack) {//뒤로 버튼
					 System.out.println("ddd");
					new Gui01_Login();
					p.setVisible(false);
				}
				if(obj==bJoin) {//회원가입 버튼
					//입력한 값
					String id=tId.getText();
					String pwd=tPwd.getText();
					String name=tName.getText();
					String phone=tPhone.getText();
					int birthdate=Integer.parseInt(tBirthdate.getText());
			
					customers.add(new Customer(name,id,pwd,phone,birthdate));//새로운 정보 저장.
					
					System.out.println(customers.get(0));
					//저장했는지 확인하려는데 해시코드로 값이 나옴 문자로 나오게 바꿔야함!

					/*
					try {
					//빈칸 있는 경우 
					if (id.trim().isEmpty()||pwd.trim().isEmpty()||name.trim().isEmpty()||phone.trim()||birthdate.trim()){
					//((id=null)||(pwd=null)||(name=null)||(phone=null)||(birthdate=null))
					throw NullPointerException ("고객님의 정보를 입력해주십시오");
					}
					
					//생년월일이 6자리 초과인경우
					else if  birthdate>6 
					throw new NotSupportedNameException("생년월일은 6자리로 입력해주십시오.");
					
					//중복인 경우
					else if (id.equals(기존 아이디)){
					throw new NotSupportedNameException("이미 가입한 고객님이십니다.");
					
					else{ //회원가입버튼누르면 고객정보 저장해서 회원가입하고 메인화면으로 이동
					customers.add(new Customer(name,id,pwd,phone,birthdate));
					f.setVisible(false);
					new Gui02_MainHome();	
					
						}catch(NullPointerException  e) {
						String msg=e.getMessage();
						JOptionPane.showMessageDialog(p,msg);
					}catch(NotSupportedNameException  e) {
						String msg=e.getMessage();
						JOptionPane.showMessageDialog(p,msg);
					}*/
					
				}//if
					
					
			}// 보이드
		}//핸들러 클래스

}//클래스
