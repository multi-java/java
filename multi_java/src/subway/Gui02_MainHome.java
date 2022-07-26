package subway;
/** 
 * 
 * 메인화면 : 로그인 후 다양한 메뉴를 선택할 수 있는 화면
 * 
 * 작성자: 김보미
 * 작성일: 22-07-23
 * 버전: 1.1
 */
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Gui02_MainHome extends JFrame{
	JFrame f = new JFrame();
	JPanel p,pS,pC; //pC_b
	JButton bbMypage, bbMenu, bbMymenu,bbLogout; 
	JLabel laIcon, laWelcome;
	Icon iconMenu, iconMymenu,iconMypage, iconLogout, iconLogo, iconWelcome;

	
	@Override
	public Insets getInsets () { 
		Insets in=new  Insets(10,10,10,10);
		return in;
	}

	
	public Gui02_MainHome() {
		super(":: Toast House App v1.1 ");
		
		/**1.전체 패널(p)를  BorderLayout구성*/
		p=new JPanel(new BorderLayout(10,10)); 
		p.setBackground(Color.white);
		p.add(pC=new JPanel(),"Center"); 
		pC.setBackground(Color.white);
		p.add(pS=new JPanel(),"South"); 
		pS.setBackground(Color.white);
		
		/**2. 남쪽의 pS를 GridLayout으로 분할해, 아이콘 버튼 생성 */
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
		
		/**3. 중앙의 pC를 GridLayout으로 분할해, 로고와 환영문구를 아이콘 배치 */
		pC.setLayout(new GridLayout(2,1));
		
		iconLogo=new ImageIcon("toastlogo.png");
		laIcon=new JLabel(iconLogo);
		pC.add(laIcon);
		
		iconWelcome=new ImageIcon("welcome.png");
		laWelcome=new JLabel(iconWelcome);//이미지 수정
		pC.add(laWelcome);
		
		
		//버튼에 이벤트핸들러 부착
		MyEventHandler handler = new MyEventHandler();
		bbMypage.addActionListener(handler);
		bbMenu.addActionListener(handler);
		bbMymenu.addActionListener(handler);
		bbLogout.addActionListener(handler);
		
		/**4.전체 프레임 f에 모든 패널을 배치. 
		 * 크기설정, 시각화 구현 및 창닫기 처리*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		f.setVisible(true);
		f.setSize(500,700);

		}//생성자
	
	/**5.이벤트처리로 메인화면에서 메뉴 이동 절차
	 * 로그아웃 버튼을 누르면 로그아웃하고 로그인화면으로 이동.
	 * 메뉴선택 버튼을 누르면 메뉴선택으로 이동
	 * 나만의 메뉴 버튼을 누르면 나만의 메뉴로 이동
	 * 마이페이지 버튼을 누르면 마이페이지로 이동
	 * */
	
	
	class MyEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource();
			if(obj==bbLogout) {//로그아웃하고 로그인화면으로 이동
				f.setVisible(false);
				new Gui01_Login();			 
				}
			if(obj==bbMenu) { //메뉴선택으로 이동
				f.setVisible(false);
				//new ();
			}
			if(obj==bbMymenu) {//나만의 메뉴로 이동
				f.setVisible(false);
				//new ();
			}
			if(obj==bbMypage) {//마이페이지로 이동
				f.setVisible(false);
				//new ();
			}
			
		}// 보이드
	}//핸들러 클래스

	
}//클래스
