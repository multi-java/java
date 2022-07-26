package subway;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class MP02_Show extends JFrame {
	JFrame f=new JFrame();
	JPanel p,pC,pS;
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
	
	public MP02_Show() {
		super(":: Toast House App v1.1 ");
		
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p=new JPanel(new BorderLayout(10,10)); 
		p.setBackground(Color.white);
		p.add(pC=new JPanel(),"Center"); 
		pC.setBackground(Color.white);
		p.add(pS=new JPanel(),"South"); 
		pS.setBackground(Color.white);
		

		
		//하단 아이콘 양식 복사
		pS.setLayout(new GridLayout(1,4));
		
		iconMymenu=new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\lovemenu.png");
		iconMenu=new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\menu.png");
		iconMypage=new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\mypage.png");
		iconLogout=new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\logout.png");
		
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
		pC.setLayout(new GridLayout(6,1));
		titleLogo=new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\title.PNG");
		title=new JLabel(titleLogo);
		title.setBounds(75,30,350,100);
		pC.add(title);
		
		laId=new JLabel("아이디 :  "+	Gui03_JoinMembership.getCustomers().get(0).getId());
		laId.setFont(new Font("sans-serif",Font.BOLD,24));
		//laId.setBounds(30, 180, 300, 50);
		laPwd=new JLabel("패스워드 :  "+	Gui03_JoinMembership.getCustomers().get(0).getPassword());
		laPwd.setFont(new Font("sans-serif",Font.BOLD,24));
		//laId.setBounds(30, 180, 300, 50);
		laName=new JLabel("이름 :  "+ Gui03_JoinMembership.getCustomers().get(0).getName());
		laName.setFont(new Font("sans-serif",Font.BOLD,24));
		//laName.setBounds(30, 260, 300, 50);
		laBirthdate=new JLabel("생년월일 :  "+ Gui03_JoinMembership.getCustomers().get(0).getBirthdate());
		laBirthdate.setFont(new Font("sans-serif",Font.BOLD,24));
		//laBirthdate.setBounds(30, 340, 300, 50);
		laPhone=new JLabel("연락처 :  "+Gui03_JoinMembership.getCustomers().get(0).getPhone());
		laPhone.setFont(new Font("sans-serif",Font.BOLD,24));
		//laPhone.setBounds(30, 420, 300, 50);

		pC.add(laId);
		pC.add(laPwd);
		pC.add(laName);
		pC.add(laBirthdate);
		pC.add(laPhone);
		
				
			f.add(p);
			f.setVisible(true);
				
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
						new ShowMainPage();
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
