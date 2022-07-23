package subway;
/** 
 * 
 * 로그인 후 메인화면
 * 
 * 작성자: 김보미
 * 작성일: 22-07-23
 * 버전: 1.1
 */
import javax.swing.*;    
import java.awt.*;
import java.awt.event.*;
/** 
 * 로그인 후 첫화면
 * 
 * 작성자: 김보미
 * 작성일: 22-07-23
 * 버전: 1.1
 */

public class Gui02_MainHome extends JFrame{
	
	JPanel p,pS,pC,pC_b;
	JButton bbMypage, bbMenu, bbMymenu; 
	JLabel laIcon, laWelcome;
	Icon iconMenu, iconMymenu,iconMypage, iconLogout, iconLogo;
	JTabbedPane tabP; 
	
	@Override
	public Insets getInsets () { 
		Insets in=new  Insets(10,10,10,10);
		return in;
	}

	
	public Gui02_MainHome() {
		super(":: Toast House App v1.1 ");
		
		//1. 전체 패널(p) 구성
		p=new JPanel(new BorderLayout()); //전체 패널 p를  보더레이이아웃 설정
		p.setBackground(Color.white);
		p.add(pC=new JPanel(),"Center"); //pC를 p의 중앙에 붙임
		pC.setBackground(Color.white);
		p.add(pS=new JPanel(),"South"); //pS를 p의 남쪽에 붙임
		pS.setBackground(Color.white);
		
		//2. pS를 그리드 레이아웃으로 분할한 후, 아이콘 넣은 버튼 생성
		pS.setLayout(new GridLayout(1,4));
		
		iconMymenu=new ImageIcon("icon_mymenu.png");
		iconMenu=new ImageIcon("icon_menu.png");
		iconMypage=new ImageIcon("icon_mypage.png");
		
		bbMypage=new JButton(iconMypage );
		bbMypage.setBackground(Color.white);
		bbMenu=new JButton( iconMenu);
		bbMenu.setBackground(Color.white);
		bbMymenu=new JButton(iconMymenu);
		bbMymenu.setBackground(Color.white);

		pS.add(bbMypage);
		pS.add(bbMenu);
		pS.add(bbMymenu);
		
		//3. pC를 그리드 레이아웃으로 분할해 위에는 로고, 아래는 환영의 메시지
		pC.setLayout(new GridLayout(2,1));
		
		iconLogo=new ImageIcon("toastlogo.png");
		laIcon=new JLabel(iconLogo);
		pC.add(laIcon);
		
		laWelcome=new JLabel("아이디(이름)님 환영합니다!");
		pC.add(laWelcome);
		
		//4.페이지 전환
		tabP=new JTabbedPane();
		add(tabP);
		tabP.add(p,"Main");
		tabP.setSelectedIndex(0);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}//생성자
	
	public static void main(String[] args) {
		Gui02_MainHome my02=new Gui02_MainHome();
		my02.setSize(500,700);
		my02.setVisible(true);

	}//메인

}//클래스
