package subway;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

/** 
 * 환경을 고려해 스마트팜을 통한 무농약 식재료로 만든 토스트 판매 애플리케이션
 * 
 * 쨈 메뉴 선택 화면
 * 
 * 1) 토핑을 선택하면 쨈 메뉴 선택 화면이 나온다.
 * 2) 쨈은 총 3가지로 구성되어 있다.
 * 3) 이전 페이지로 돌아가는 버튼, 메뉴를 선택할 수 있는 버튼, 하단에는 네비게이션 바(my페이지, 주문하기, 즐겨찾기, 로그아웃)으로 구성되어 있다.
 * 	<1> 쨈을 클릭하면 자신이 선택한 메뉴가 출력되는 화면으로 연결된다.
 * 	<2> 이전 버튼을 클릭하면 토핑 선택 화면으로 돌아간다.
 *  
 * @author 박상환
 * 작성일: 22-07-27
 */

/**
 * 추상 클래스인 Sandwich를 상속받는 클래스
 * 
 * @author 박상환
 *
 */
public class Jam extends Sandwich {
	private static String menu;

	@Override
	public String choice(String menu) {
		Jam.menu = menu;
		return menu;
	}

	public void Show() {

	}

	public static String getMenu() {
		return menu;
	}

	public static void setMenu(String menu) {
		Jam.menu = menu;
	}

}

/**
 * 
 * 쨈 메뉴 GUI 출력하기 위한 클래스
 * 
 * @author 박상환
 *
 */
class ShowJam extends JFrame {
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton btBlue, btStraw, btApple, btBefore, btNext, btmypage, btShopping, btbookmark, btlogout;
	JLabel Lblogo, Lbname, Lbline, lbMenu;

	/**
	 * 생성자 버튼이나 라벨과 같은 요소들을 정의하고 프레임에 추가시켜준다.
	 */
	public ShowJam() {

		f.setSize(500, 700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);

		Lblogo = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\까페로고.jpg")); // 메뉴선택 라벨 생성
		Lbname = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\주문하기.jpg")); // 메뉴선택 라벨 생성
		Lbline = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\선.png")); // 메뉴선택 라벨 생성
		btBlue = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\블루베리쨈.jpg"));
		btStraw = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\딸기쨈.jpg"));
		btApple = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\사과쨈.jpg"));
		btBefore = new JButton("", (new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\돌아가기.png")));
		lbMenu = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\쨈을 골라주세요.jpg"));
		btmypage = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\마이페이지.jpg"));
		btShopping = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\mv주문하기.jpg"));
		btbookmark = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\MV주문내역.jpg"));
		btlogout = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\로그아웃.jpg"));

		Lblogo.setBounds(5, 5, 100, 100);
		Lbname.setBounds(170, 10, 150, 100);
		Lbline.setBounds(0, 100, 500, 50);
		lbMenu.setBounds(100, 150, 250, 100);
		btBlue.setBounds(10, 250, 130, 130); /** setBounds -> 좌우,상하,너비,높이 순서 */
		btStraw.setBounds(162, 250, 130, 130);
		btApple.setBounds(312, 250, 130, 130);
		btBefore.setBounds(380, 10, 100, 100);
		btmypage.setBounds(0, 570, 125, 100); // x, y, 가로, 세로
		btShopping.setBounds(125, 570, 125, 100);
		btbookmark.setBounds(250, 570, 125, 100); // x, y, 가로, 세로
		btlogout.setBounds(375, 570, 125, 100); // x, y, 가로, 세로

		btBlue.setBackground(Color.white); // 메뉴사진(bt) 테두리 없애기
		btBlue.setBorderPainted(false);
		btStraw.setBackground(Color.white);
		btStraw.setBorderPainted(false);
		btApple.setBackground(Color.white);
		btApple.setBorderPainted(false);
		btBefore.setBackground(Color.white);
		btBefore.setBorderPainted(false);
		btmypage.setBackground(Color.white);
		btmypage.setBorderPainted(false);
		btShopping.setBackground(Color.white);
		btShopping.setBorderPainted(false);
		btbookmark.setBackground(Color.white);
		btbookmark.setBorderPainted(false);
		btlogout.setBackground(Color.white);
		btlogout.setBorderPainted(false);

		f.getContentPane().add(lbMenu);
		f.getContentPane().add(btBlue);
		f.getContentPane().add(btStraw);
		f.getContentPane().add(btApple);
		f.getContentPane().add(btBefore);
		f.getContentPane().add(Lbline);
		f.getContentPane().add(Lbname);
		f.getContentPane().add(Lblogo);
		f.getContentPane().add(btmypage);
		f.getContentPane().add(btShopping);
		f.getContentPane().add(btbookmark);
		f.getContentPane().add(btlogout);
		f.getContentPane().setBackground(Color.white);
		f.setVisible(true);

		MyEventHandler handler = new MyEventHandler();
		btBlue.addActionListener(handler);
		btStraw.addActionListener(handler);
		btApple.addActionListener(handler);
		btBefore.addActionListener(handler);
		btmypage.addActionListener(handler);
		btShopping.addActionListener(handler);
		btbookmark.addActionListener(handler);
		btlogout.addActionListener(handler);

	}

	/**
	 * 이벤트 핸들러 버튼 클릭과 같은 이벤트가 발생하면 이벤트 처리를 담당하는 클래스
	 * 
	 * @author 박상환
	 *
	 */
	class MyEventHandler implements ActionListener {
		String order = ""; // 주문 내역 저장하기 위한 문자열
		int menu_price = 0; // 메뉴의 가격과 토핑의 가격을 더한 값

		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == btBlue) {
				Jam.setMenu("Blueberry");
				showMenu();
				new Order();
				f.setVisible(false);
			} else if (obj == btStraw) {
				Jam.setMenu("Strawberry");
				showMenu();
				new Order();
				f.setVisible(false);
			} else if (obj == btApple) {
				Jam.setMenu("Apple");
				showMenu();
				new Order();
				f.setVisible(false);
			} else if (obj == btBefore) {
				f.setVisible(false);
				new ShowEgg();
			} else if (obj == btlogout) {// 로그아웃하고 로그인화면으로 이동
				f.setVisible(false);
				new Gui01_Login();
			} else if (obj == btShopping) { // 메뉴선택으로 이동
				f.setVisible(false);
				new ShowMainPage();
			} else if (obj == btbookmark) {// 나만의 메뉴로 이동
				f.setVisible(false);
				new BookMark();
			} else if (obj == btmypage) {// 마이페이지로 이동
				f.setVisible(false);
				new MP01_Main();
			}

		}

		/**
		 * 선택한 메뉴와 가격을 저장,출력하기 위한 메소드
		 */
		public void showMenu() {
			menu_price = Menu.getPrice() + Egg.getTopping_price(); // 메뉴의 가격 저장
			ShowMainPage.setTotal_price(menu_price);
			order = // 주문한 메뉴의 정보를 저장
					(Integer.toString(ShowMainPage.getOrderList().size() + 1)) + ". 선택한 메뉴 : " + Menu.getMenu()
							+ "\n메뉴 가격 : " + Menu.getPrice() + "\n빵 : " + Bread.getMenu() + "\n토핑 : " + Egg.getMenu()
							+ "\n토핑 가격 : " + Egg.getTopping_price() + "\n쨈 가격 : " + Jam.getMenu() + "\n총 가격 : "
							+ Integer.toString(menu_price) + "\n\n====================" + "\n\n";
			ShowMainPage.setOrderList(order);
		}
	}
}
