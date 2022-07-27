package subway;
/**
 * 	마이페이지 기본 화면
 * 	작성자 정유진
 * 	작성일 7:26 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MP01_Main extends JFrame {
	JFrame f=new JFrame();
	JPanel p,pN,pC,pS;
	JButton bbMypage, bbMenu, bbMymenu,bbLogout,sMember,cMember,dMember;
	JLabel title;
	Icon titleLogo;
	Icon iconMenu, iconMymenu,iconMypage, iconLogout;
	
	@Override
	public Insets getInsets () { 
		Insets in=new  Insets(10,10,10,10);
		return in;
	}
	
	/** 1. 마이페이지 GUI 화면
	 */
	public MP01_Main() {
		super(":: Toast House App v1.1 ");
		
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.getContentPane().setLayout(null);
		
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
		
		/**1.3 중심 화면*/
		pC.setLayout(new GridLayout(3,1));

		sMember = new JButton("회원정보 조회");
		sMember.setFont(new Font("NanumGothic",Font.BOLD,35));
		cMember = new JButton("회원정보 수정");
		cMember.setFont(new Font("NanumGothic",Font.BOLD,35));
		dMember = new JButton("회원 탈퇴");
		dMember.setFont(new Font("NanumGothic",Font.BOLD,35));

			pC.add(sMember);
			pC.add(cMember);
			pC.add(dMember);
		
		f.add(p);
		f.setVisible(true);
			
		//버튼 활성화
		MyEventHandler handler = new MyEventHandler();
			sMember.addActionListener(handler);
			cMember.addActionListener(handler);
			dMember.addActionListener(handler);
			bbMypage.addActionListener(handler);
			bbMenu.addActionListener(handler);
			bbMymenu.addActionListener(handler);
			bbLogout.addActionListener(handler);
		}
			class MyEventHandler implements ActionListener{
				
				public void actionPerformed(ActionEvent e) {
					Object obj = e.getSource();
					if(obj==sMember)
					{
						new MP02_Show();	
						f.setVisible(false);
					
					}else if(obj==cMember)
					{
						 new MP03_Change();	
						f.setVisible(false);
					}else if(obj==dMember)
					{ 
						new MP04_Delete();	
						f.setVisible(false);
					}else if(obj==bbLogout) {//로그아웃하고 로그인화면으로 이동
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
