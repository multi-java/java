package subway;

/** 
 * 다양한 선택이 가능한 소비자 중심의 토스트 판매 애플리케이션  
 * 
 * 메인화면 : 로그인 후 네비게이션바 버튼을 통해 다른 기능으로 이동할 수 있는 화면
 * 
 * 1)로그아웃 버튼을 누르면, 첫 로그인화면으로 이동.
 * 	 :  로그인 상태의 메인화면에서 첫 로그인화면으로 돌아가면, 
 *      사용자는 로그인화면만 조작을 할 수 있게 되어 로그아웃 효과.
 * 2)메뉴 선택 버튼을 누르면, 메뉴 선택 화면으로 이동
 * 3)주문 조회 버튼을 누르면, 주문 조회 화면으로 이동
 * 4)마이페이지 버튼을 누르면, 마이페이지로 이동
 * 
 * 작성자: 김보미
 * 작성일: 22-07-27
 * 버전: 1.1
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/** 1.메인홈 화면에 대한 클래스 */
public class Gui02_MainHome extends JFrame {
	JFrame f = new JFrame(":: Cafe7 App v1.1 ");
	JPanel p, pS, pC;
	JButton bbMypage, bbMenu, bbMymenu, bbLogout;
	JLabel laIcon, laWelcome;
	Icon iconMenu, iconMymenu, iconMypage, iconLogout, iconLogo, iconWelcome;

	/** 2. 프레임에 여백을 주는 메서드 */
	@Override
	public Insets getInsets() {
		Insets in = new Insets(10, 10, 10, 10);
		return in;
	}

	/** 3.메인 화면구성에 대한 생성자 */
	public Gui02_MainHome() {
		super(":: Cafe7 App v1.1 ");

		/** 3-1)전체 패널(p)를 BorderLayout구성: pC(중앙), pS(남쪽) 배치 */
		p = new JPanel(new BorderLayout(10, 10));
		p.setBackground(Color.white);
		p.add(pC = new JPanel(), "Center");
		pC.setBackground(Color.white);
		p.add(pS = new JPanel(), "South");
		pS.setBackground(Color.white);

		/** 3-2) 남쪽의 pS를 GridLayout으로 분할해, 아이콘 버튼 생성 */
		pS.setLayout(new GridLayout(1, 4));

		iconMymenu = new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\주문내역.jpg");
		iconMenu = new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\mv주문하기.jpg");
		iconMypage = new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\마이페이지.jpg");
		iconLogout = new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\로그아웃.jpg");

		bbMypage = new JButton(iconMypage);
		bbMypage.setBackground(Color.black);
		bbMenu = new JButton(iconMenu);
		bbMenu.setBackground(Color.black);
		bbMymenu = new JButton(iconMymenu);
		bbMymenu.setBackground(Color.black);
		bbLogout = new JButton(iconLogout);
		bbLogout.setBackground(Color.black);

		pS.add(bbMypage);
		pS.add(bbMenu);
		pS.add(bbMymenu);
		pS.add(bbLogout);

		/** 3-3) 중앙의 pC를 GridLayout으로 분할해, 2개의 이미지 배치 */
		pC.setLayout(new GridLayout(2, 1));

		iconLogo = new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\cafe7logo.png");
		laIcon = new JLabel(iconLogo);
		pC.add(laIcon);

		iconWelcome = new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\welcome6.png");
		laWelcome = new JLabel(iconWelcome);// 이미지 수정
		pC.add(laWelcome);

		/** 3-4) 버튼에 이벤트핸들러 부착 */
		MyEventHandler handler = new MyEventHandler();
		bbMypage.addActionListener(handler);
		bbMenu.addActionListener(handler);
		bbMymenu.addActionListener(handler);
		bbLogout.addActionListener(handler);

		/** 3-5)전체 프레임 f에 모든 패널을 배치. 크기설정, 시각화 구현 및 창닫기 처리 */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		f.setVisible(true);
		f.setSize(500, 700);

	}

	/** 4. 화면 이동에 대한 이벤트 처리하는 클래스 */
	class MyEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == bbLogout) {
				f.setVisible(false);
				new Gui01_Login();
			}
			if (obj == bbMenu) {
				f.setVisible(false);
				new ShowMainPage();
			}
			if (obj == bbMymenu) {
				f.setVisible(false);
				new BookMark();
			}
			if (obj == bbMypage) {
				f.setVisible(false);
				new MP01_Main();
			}

		}
	}

}
