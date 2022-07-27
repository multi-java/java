package subway;
/**
 *	마이페이지 개인정보 조회 화면
 *  작성자 정유진
 *  작성일 7:26 
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class MP02_Show extends JFrame {
	JFrame f=new JFrame();
	JPanel p,pC,pS,pN;
	JButton bbMypage, bbMenu, bbMymenu,bbLogout;
	JLabel laId, laPwd,laName,laPhone, laBirthdate;
	JLabel title;
	Icon titleLogo;
	Icon iconMenu, iconMymenu,iconMypage, iconLogout;
	
	
	@Override
	public Insets getInsets () { 
		Insets in=new  Insets(10,10,10,10);
		return in;
	}
	
	/**1. 정보 조회 화면 GUI*/
	public MP02_Show() {
		super(":: Toast House App v1.1 ");
		
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p=new JPanel(new BorderLayout(10,10)); 
		p.setBackground(Color.white);
		p.add(pC=new JPanel(),"Center"); 
		pC.setBackground(Color.white);
		p.add(pN=new JPanel(),"North"); 
		pN.setBackground(Color.white);
		p.add(pS=new JPanel(),"South"); 
		pS.setBackground(Color.white);
		
		/**1.1 마이페이지 타이틀*/
		titleLogo=new ImageIcon("image/MyPage.jpg");
		title=new JLabel(titleLogo);
		pN.add(title);

		
		/**1.2 하단 네비게이션바*/
		pS.setLayout(new GridLayout(1,4));
		
		iconMymenu=new ImageIcon("image/주문내역.jpg");
		iconMenu=new ImageIcon("image/mv주문하기.jpg");
		iconMypage=new ImageIcon("image/마이페이지.jpg");
		iconLogout=new ImageIcon("image/로그아웃.jpg");
		
		bbMypage=new JButton(iconMypage );
		bbMypage.setBackground(Color.white);
		bbMenu=new JButton( iconMenu);
		bbMenu.setBackground(Color.white);
		bbMymenu=new JButton(iconMymenu);
		bbMymenu.setBackground(Color.white);
		bbLogout=new JButton(iconLogout);
		bbLogout.setBackground(Color.white);
				
		pS.add(bbMypage);
		pS.add(bbMenu);
		pS.add(bbMymenu);
		pS.add(bbLogout);
		
		//1.3 중심 화면
		pC.setLayout(new GridLayout(6,1));
		
		/**
		 *  2. 회원 정보 출력
		 *  회원가입 시 배열에 저장된 개인 정보를 꺼내와서 출력한다.
		 *  
		 *  로그인 시 입력한 아이디 Gui01_Login.id 를
		 *  if문과 for루프를 통해 배열에 저장된 아이디들과 비교하여
		 *  동일한 아이디를 발견 시 해당 아이디의 정보들을 변수에 저장하여 출력한다.
		 */
		String a="";
		String b="";
		int c=0;
		String d="";
		int i=0;
		
		/**
		 * 2.1 로그인한 아이디와 일치하는 정보를 가진 배열을 탐색하는 for루프
		 */
		for(;i<Gui03_JoinMembership.getCustomers().size();i++) {
			if(Gui03_JoinMembership.getCustomers().get(i).getId().equals(Gui01_Login.id))
			{
				a=Gui03_JoinMembership.getCustomers().get(i).getPassword();
				b=Gui03_JoinMembership.getCustomers().get(i).getName();
				c=Gui03_JoinMembership.getCustomers().get(i).getBirthdate();
				d=Gui03_JoinMembership.getCustomers().get(i).getPhone();
			}
		}
			
		/** 2.2 해당 정보 출력
		 */
			laId=new JLabel("아이디 :  "+Gui01_Login.id);
			laId.setFont(new Font("NanumGothic",Font.BOLD,26));
			laPwd=new JLabel("패스워드 :  "+a);
			laPwd.setFont(new Font("NanumGothic",Font.BOLD,26));
			laName=new JLabel("이름 :  "+b);
			laName.setFont(new Font("NanumGothic",Font.BOLD,26));
			laBirthdate=new JLabel("생년월일 :  "+c);
			laBirthdate.setFont(new Font("NanumGothic",Font.BOLD,26));
			laPhone=new JLabel("연락처 :  "+d);
			laPhone.setFont(new Font("NanumGothic",Font.BOLD,26));

		pC.add(laId);
		pC.add(laPwd);
		pC.add(laName);
		pC.add(laBirthdate);
		pC.add(laPhone);
	
			f.add(p);
			f.setVisible(true);
				
			//버튼 활성화
			MyEventHandler handler = new MyEventHandler();

			bbMypage.addActionListener(handler);
			bbMenu.addActionListener(handler);
			bbMymenu.addActionListener(handler);
			bbLogout.addActionListener(handler);
		}
			class MyEventHandler implements ActionListener{
				
				public void actionPerformed(ActionEvent e) {
					Object obj = e.getSource();
					if(obj==bbLogout) {//로그아웃하고 로그인화면으로 이동
						f.setVisible(false);
						new Gui01_Login();			 
					}else if(obj==bbMenu) { //메뉴선택으로 이동
						f.setVisible(false);
						new ShowMenu();
					}else if(obj==bbMymenu) {//나만의 메뉴로 이동
						f.setVisible(false);
						new BookMark();
					}else if(obj==bbMypage) {//마이페이지로 이동
						f.setVisible(false);
						new MP01_Main();
				}
			
			}

	}
	}

