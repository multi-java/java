package login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class MP01_Main extends JFrame {
	JFrame f=new JFrame();
	JPanel p,pC,pS;
	JButton bbMypage, bbMenu, bbMymenu,bbLogout,sMember,cMember,dMember;
	JLabel title;
	Icon titleLogo;
	Icon iconMenu, iconMymenu,iconMypage, iconLogout;
	
	@Override
	public Insets getInsets () { 
		Insets in=new  Insets(10,10,10,10);
		return in;
	}
	
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
		p.add(pS=new JPanel(),"South"); 
		pS.setBackground(Color.white);
		

		
		//하단 아이콘 양식 복사
		pS.setLayout(new GridLayout(1,4));
		
		iconMymenu=new ImageIcon("lovemenu.png");
		iconMenu=new ImageIcon("menu.png");
		iconMypage=new ImageIcon("mypage.png");
		iconLogout=new ImageIcon("logout.png");
		
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
		
		//중심 화면
		pC.setLayout(new GridLayout(4,1));
		
		titleLogo=new ImageIcon("title.PNG");
		title=new JLabel(titleLogo);
		title.setBounds(75,30,350,100);
		pC.add(title);
		
		sMember = new JButton("회원정보 조회");
		sMember.setBounds(40,200,410,100);
		cMember = new JButton("회원정보 수정");
		cMember.setBounds(40,330,410,100);
		dMember = new JButton("회원 탈퇴");
		dMember.setBounds(40,460,410,100);
		
		pC.add(sMember);
		pC.add(cMember);
		pC.add(dMember);
		//pC.getRootPane().add(sMember);
		//pC.getRootPane().add(cMember);
		//pC.getRootPane().add(dMember);
		

				
			f.add(p);
			f.setVisible(true);
				
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
						//new ShowCMember();	
						f.setVisible(false);
					}else if(obj==dMember)
					{ 
						//new ShowDMember();	
						f.setVisible(false);
					}else if(obj==bbLogout) {//로그아웃하고 로그인화면으로 이동
						f.setVisible(false);
						new Gui01_Login();			 
					}else if(obj==bbMenu) { //메뉴선택으로 이동
						f.setVisible(false);
						new main.ShowMainPage();
					}else if(obj==bbMymenu) {//나만의 메뉴로 이동
						f.setVisible(false);
						new main.BookMark();
					}else if(obj==bbMypage) {//마이페이지로 이동
						f.setVisible(false);
						new MP01_Main();
				}
			
			}

	}
}
